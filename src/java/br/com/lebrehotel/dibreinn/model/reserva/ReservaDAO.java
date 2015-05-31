package br.com.lebrehotel.dibreinn.model.reserva;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago, Udimberto
 *
 */
public class ReservaDAO {

  public void cadastrarReserva(Reserva res) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_RESERVA (STATUS, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO, DT_FIM, VALOR) VALUES (?, ?, ?, ?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      /* Status da Reserva: A = ABERTA */
      stmt.setString(1, "A");
      stmt.setInt(2, res.getIdFuncionario());
      stmt.setInt(3, res.getIdHospede());
      stmt.setInt(4, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(5, sqlDataCheckin);

      java.sql.Date sqlDataCheckout = new java.sql.Date(res.getCheckOut().getTime());
      stmt.setDate(6, sqlDataCheckout);
      stmt.setDouble(7, res.getValorEstadia());

      stmt.executeUpdate();
      System.out.println("[INFO] Reserva registrada com sucesso.");
      conexao.closeConection();

    } catch (SQLException ex) {

      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

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

  public List<Reserva> buscarReservas(String data) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    java.util.Date checkin = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      checkin = sdf.parse(data);
    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.sql.Date sqlDataCheckin = new java.sql.Date(checkin.getTime());

    List<Reserva> listaReservas = new ArrayList<>();

    String Query = "SELECT STATUS, ID_RESERVA, ID_HOSPEDE, ID_FUNCIONARIO, ID_QUARTO FROM TB_RESERVA WHERE DT_INICIO = ?";

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setDate(1, sqlDataCheckin);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Reserva res = new Reserva();

	res.setStatus(resultados.getString("STATUS"));
	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setCheckIn(checkin);

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

    String sql = " UPDATE INTO TB_RESERVA (ID_RESERVA, STATUS, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO, DT_FIM) VALUES (?, ?, ?, ?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, res.getId());
      stmt.setString(2, res.getStatus());
      stmt.setInt(3, res.getIdFuncionario());
      stmt.setInt(4, res.getIdHospede());
      stmt.setInt(5, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(6, sqlDataCheckin);

      java.sql.Date sqlDataCheckout = new java.sql.Date(res.getCheckOut().getTime());
      stmt.setDate(7, sqlDataCheckout);

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
