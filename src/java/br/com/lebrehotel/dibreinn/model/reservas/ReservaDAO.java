package br.com.lebrehotel.dibreinn.model.reservas;

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
 * @author Thiago
 */
public class ReservaDAO {

  public void registrar(Reserva res) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_RESERVA (ID_UNIDADE, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, CHECKIN, CHECKOUT, VALOR_ESTADIA) VALUES (?, ?, ?, ?, ?, ?, ?)\n ";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, res.getIdUnidade());
      stmt.setInt(2, res.getIdFuncionario());
      stmt.setInt(3, res.getIdHospede());
      stmt.setInt(4, res.getIdQuarto());
          //stmt.setDate(5, res.getCheckIn());
      //stmt.setDate(6, res.getCheckOut());
      stmt.setDouble(7, res.getValorEstadia());

      stmt.executeUpdate();
      System.out.println("[INFO] Reserva registrada com sucesso.");

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

  public List<Reserva> listarReservas(int pesquisa, int tipoBusca) {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Reserva> lista = new ArrayList<Reserva>();

    String Query = "SELECT ID, ID_HOSPEDE, FROM TB_RESERVAS ";

    switch (tipoBusca) {
      case 1:
	Query += "WHERE CHECKIN = ?";
	break;
      case 2:
	Query += "WHERE CHECKOUT = ?";
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
	
	res.setId(resultados.getInt("ID_QUARTO"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setIdUnidade(resultados.getInt("ID_UNIDADE"));
	res.setValorEstadia(resultados.getDouble("VALOR_ESTADIA"));

	lista.add(res);
	
      }

      return lista;
      
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

}
