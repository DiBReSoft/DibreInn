package br.com.lebrehotel.dibreinn.model.unidade;

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
 * @author Thiago, udimberto.sjunior
 */
public class UnidadeDAO {

  public void cadastrarUnidade(Unidade u) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "INSERT INTO TB_UNIDADE (NOME,STATUS,CNPJ,TIPO,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO) VALUES  (?,?,?,?,?,?,?,?,?,?,?)";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setString(1, u.getNome());
      stmt.setInt(2, u.getStatus());
      stmt.setString(3, u.getCnpj());
      stmt.setInt(4, u.getTipo());
      stmt.setString(5, u.getLogradouro());
      stmt.setString(6, u.getNumero());
      stmt.setString(7, u.getCep());
      stmt.setString(8, u.getComplemento());
      stmt.setString(9, u.getBairro());
      stmt.setString(10, u.getCidade());
      stmt.setString(11, u.getEstado());

      stmt.executeUpdate();
      System.out.println("Dados Salvos com sucesso!!!");

    } catch (SQLException ex) {
      Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }
  
  public void editarUnidade(Unidade u) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "UPDATE TB_UNIDADE SET STATUS = ?, NOME = ?, CNPJ = ?, TIPO = ?, "
	    + "LOGRADOURO = ?, NUM = ?, CEP = ?, COMPLEMENTO = ?, "
	    + "BAIRRO = ?, CIDADE = ?, ESTADO = ? "
	    + "WHERE ID_UNIDADE = ?";

    try {
      
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, u.getStatus());
      stmt.setString(2, u.getNome());
      stmt.setString(3, u.getCnpj());
      stmt.setInt(4, u.getTipo());
      stmt.setString(5, u.getLogradouro());
      stmt.setString(6, u.getNumero());
      stmt.setString(7, u.getCep());
      stmt.setString(8, u.getComplemento());
      stmt.setString(9, u.getBairro());
      stmt.setString(10, u.getCidade());
      stmt.setString(11, u.getEstado());
      
      stmt.setString(12, Integer.toString(u.getId()));

      stmt.executeUpdate();
      
      System.out.println("[INFO] Unidade " + u.getNome() + " atualizada com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public List<Unidade> listarUnidades() {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Unidade> lista = new ArrayList<>();

    String Query = "SELECT ID_UNIDADE, STATUS, NOME, CNPJ, TIPO, LOGRADOURO, NUM, CEP, COMPLEMENTO, BAIRRO, CIDADE, ESTADO \n"
	    + "FROM TB_UNIDADE \n";

    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {
	
	Unidade u = new Unidade();

	u.setId(Integer.parseInt(resultados.getString("ID_UNIDADE")));
	u.setStatus(Integer.parseInt(resultados.getString("STATUS")));
	u.setNome(resultados.getString("NOME"));
	u.setCnpj(resultados.getString("CNPJ"));
	u.setTipo(resultados.getInt("TIPO"));
	u.setNumero(resultados.getString("NUM"));
	u.setCep(resultados.getString("CEP"));
	u.setLogradouro(resultados.getString("LOGRADOURO"));

	u.setComplemento(resultados.getString("COMPLEMENTO"));
	u.setBairro(resultados.getString("BAIRRO"));
	u.setCidade(resultados.getString("CIDADE"));
	u.setEstado(resultados.getString("ESTADO"));

	lista.add(u);
	
      }

      return lista;
    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao consultar os dados de UNIDADES: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }

  public Unidade buscarUnidadeId(String unidadeId) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String Query = "SELECT ID_UNIDADE,STATUS, NOME,CNPJ,TIPO,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO \n"
	    + "FROM TB_UNIDADE WHERE ID_UNIDADE = ? \n";

    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setString(1, unidadeId);

      ResultSet resultados = stmt.executeQuery();

      Unidade u = new Unidade();

      while (resultados.next()) {

	u.setId(Integer.parseInt(resultados.getString("ID_UNIDADE")));
	u.setStatus(Integer.parseInt(resultados.getString("STATUS")));
	u.setNome(resultados.getString("NOME"));
	u.setCnpj(resultados.getString("CNPJ"));
	u.setTipo(resultados.getInt("TIPO"));
	u.setNumero(resultados.getString("NUM"));
	u.setCep(resultados.getString("CEP"));
	u.setLogradouro(resultados.getString("LOGRADOURO"));

	u.setComplemento(resultados.getString("COMPLEMENTO"));
	u.setBairro(resultados.getString("BAIRRO"));
	u.setCidade(resultados.getString("CIDADE"));
	u.setEstado(resultados.getString("ESTADO"));
      }

      return u;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }
}
