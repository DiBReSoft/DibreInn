package br.com.lebrehotel.dibreinn.model.reserva;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class ReservaDAO {

  public boolean cadastrarReserva(Reserva res) {

    boolean resultadoOperacao;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_RESERVA (ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO) VALUES (?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, res.getIdFuncionario());
      stmt.setInt(2, res.getIdHospede());
      stmt.setInt(3, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(4, sqlDataCheckin);

      stmt.executeUpdate();
      System.out.println("[INFO] Reserva registrada com sucesso.");

      return resultadoOperacao = true;

    } catch (SQLException ex) {

      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return resultadoOperacao = false;

    } finally {

      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }

    }

  }

  public List<Reserva> buscarReservas(int pesquisa, int tipoBusca) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Reserva> listaReservas = new ArrayList<>();

    String Query = "SELECT ID_RESERVA, ID_HOSPEDE, FROM TB_RESERVA ";

    switch (tipoBusca) {
      case 1:
	Query += "WHERE DT_INICIO = ?";
	break;
      case 2:
	Query += "WHERE DT_FIM = ?";
	break;
    }

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      if (tipoBusca == 1 || tipoBusca == 2) {
	stmt.setInt(1, pesquisa);
      }

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Reserva res = new Reserva();

	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));

	listaReservas.add(res);

      }

      return listaReservas;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

    } finally {

      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }

    }

    return null;

  }

  public boolean alterarReserva(Reserva res) {

    boolean resultadoOperacao;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " UPDATE INTO TB_RESERVA (ID_RESERVA, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO, DT_FIM) VALUES (?, ?, ?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, res.getId());
      stmt.setInt(2, res.getIdFuncionario());
      stmt.setInt(3, res.getIdHospede());
      stmt.setInt(4, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(5, sqlDataCheckin);

      java.sql.Date sqlDataCheckout = new java.sql.Date(res.getCheckOut().getTime());
      stmt.setDate(6, sqlDataCheckout);

      stmt.executeUpdate();
      System.out.println("[INFO] Reserva alterada com sucesso.");

      return resultadoOperacao = true;

    } catch (SQLException ex) {

      System.err.println("[ERRO] Não foi possível alterar a reserva.");
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return resultadoOperacao = false;

    } finally {

      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }

    }

  }

  public boolean deletarReserva(int id) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    
    String query = "DELETE FROM TB_RESERVA WHERE ID_RESERVA = ? \n";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(query);
      
      stmt.setInt(1, id);
      stmt.executeQuery();
      
      System.out.println("[INFO] Reserva #" + id + " deletada com sucesso.");
      return true;

    } catch (SQLException ex) {
      System.out.println("[ERRO] Não foi possível deletar a reserva #" + id + "\n" + ex);
      return false;
    }
  }

}