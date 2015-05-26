package br.com.lebrehotel.dibreinn.model.privilegio;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author udimberto.sjunior
 */
public class PrivilegioDAO {

  public void cadastrarPrivilegio(Privilegio priv) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "INSERT INTO TB_PRIVILEGIO (STATUS, PRIVILEGIO) VALUES  (?,?)";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, 1);
      stmt.setString(2, priv.getTitulo());

      stmt.executeUpdate();
      System.out.println("[INFO] Privilégio '" + priv.getTitulo() + "' adicionado com sucesso!");

    } catch (SQLException ex) {
      Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public void editarPrivilegio(Privilegio priv) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "UPDATE TB_PRIVILEGIO SET STATUS = ?, PRIVILEGIO = ? "
	    + "WHERE ID_PRIVILEGIO = ?";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, priv.getStatus());
      stmt.setString(2, priv.getTitulo());

      stmt.setString(3, Integer.toString(priv.getId()));

      stmt.executeUpdate();

      System.out.println("[INFO] Privilégio " + priv.getTitulo() + " atualizado com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public List<Privilegio> listarPrivilegios() {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Privilegio> lista = new ArrayList<>();

    String Query = "SELECT ID_PRIVILEGIO, STATUS, PRIVILEGIO "
	    + "FROM TB_PRIVILEGIO \n";

    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Privilegio priv = new Privilegio();

	priv.setId(Integer.parseInt(resultados.getString("ID_PRIVILEGIO")));
	priv.setStatus(Integer.parseInt(resultados.getString("STATUS")));
	priv.setTitulo(resultados.getString("PRIVILEGIO"));

	lista.add(priv);

      }

      return lista;
    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao consultar os dados de PRIVILÉGIO: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }

  public Privilegio buscarPrivilegioId(String privilegioId) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String Query = "SELECT ID_PRIVILEGIO, STATUS, PRIVILEGIO "
	    + "FROM TB_PRIVILEGIO WHERE ID_PRIVILEGIO = ? \n";

    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setString(1, privilegioId);

      ResultSet resultados = stmt.executeQuery();

      Privilegio priv = new Privilegio();

      while (resultados.next()) {

	priv.setId(Integer.parseInt(resultados.getString("ID_PRIVILEGIO")));
	priv.setStatus(Integer.parseInt(resultados.getString("STATUS")));
	priv.setTitulo(resultados.getString("PRIVILEGIO"));

      }

      return priv;

    } catch (SQLException ex) {
      
      Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PrivilegioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }

}
