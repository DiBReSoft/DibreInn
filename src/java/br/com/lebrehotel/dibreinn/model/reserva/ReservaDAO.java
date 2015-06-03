package br.com.lebrehotel.dibreinn.model.reserva;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import br.com.lebrehotel.dibreinn.model.funcionario.Funcionario;
import br.com.lebrehotel.dibreinn.model.funcionario.FuncionarioDAO;
import br.com.lebrehotel.dibreinn.model.hospede.Hospede;
import br.com.lebrehotel.dibreinn.model.hospede.HospedeDAO;
import br.com.lebrehotel.dibreinn.model.quarto.Quarto;
import br.com.lebrehotel.dibreinn.model.quarto.QuartoDAO;
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

    String sql = " INSERT INTO TB_RESERVA (STATUS, ID_UNIDADE, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO, DT_FIM, VALOR) VALUES (?, ?, ?, ?, ?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      /* Status da Reserva: A = ABERTA */
      stmt.setString(1, "A");
      stmt.setInt(2, res.getIdUnidade());
      stmt.setInt(3, res.getIdFuncionario());
      stmt.setInt(4, res.getIdHospede());
      stmt.setInt(5, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(6, sqlDataCheckin);

      java.sql.Date sqlDataCheckout = new java.sql.Date(res.getCheckOut().getTime());
      stmt.setDate(7, sqlDataCheckout);
      stmt.setDouble(8, res.getValorEstadia());

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

  public List<Reserva> buscarReservas(String dtInicio, String dtFim) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    java.util.Date dataIni = new java.util.Date();
    java.util.Date dataFim = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      dataIni = sdf.parse(dtInicio);
      dataFim = sdf.parse(dtFim);
    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.sql.Date sqlDataInicio = new java.sql.Date(dataIni.getTime());
    java.sql.Date sqlDataFim = new java.sql.Date(dataFim.getTime());

    List<Reserva> listaReservas = new ArrayList<>();

    String Query = "SELECT STATUS, ID_RESERVA, ID_UNIDADE, ID_HOSPEDE, ID_FUNCIONARIO, ID_QUARTO, DT_INICIO, DT_FIM FROM TB_RESERVA "
	    + "WHERE DT_INICIO >= ? AND DT_INICIO <= ?";

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setDate(1, sqlDataInicio);
      stmt.setDate(2, sqlDataFim);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Reserva res = new Reserva();

	res.setStatus(resultados.getString("STATUS"));
	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdUnidade(resultados.getInt("ID_UNIDADE"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setCheckIn(resultados.getDate("DT_INICIO"));
	res.setCheckOut(resultados.getDate("DT_FIM"));

	FuncionarioDAO funcionarioBD = new FuncionarioDAO();
	res.setFuncionario(funcionarioBD.getFuncionarioById(res.getIdFuncionario()));

	HospedeDAO hospedeBD = new HospedeDAO();
	res.setHospede(hospedeBD.getHospedeById(res.getIdHospede()));

	QuartoDAO quartoBD = new QuartoDAO();
	res.setQuarto(quartoBD.buscarQuartoId(resultados.getString("ID_QUARTO")));

	listaReservas.add(res);

      }

      return listaReservas;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
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

  public List<Reserva> listarReservasParaCheckIn(String dtInicio) throws ParseException {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    java.util.Date dataIni = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      dataIni = sdf.parse(dtInicio);
    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.sql.Date sqlDataInicio = new java.sql.Date(dataIni.getTime());

    List<Reserva> listaReservas = new ArrayList<>();

    String Query = "SELECT STATUS, ID_RESERVA, ID_UNIDADE, ID_HOSPEDE, ID_FUNCIONARIO, ID_QUARTO, DT_INICIO, DT_FIM FROM TB_RESERVA "
	    + "WHERE DT_INICIO = ? ";

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setDate(1, sqlDataInicio);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Reserva res = new Reserva();

	res.setStatus(resultados.getString("STATUS"));
	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdUnidade(resultados.getInt("ID_UNIDADE"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setCheckIn(resultados.getDate("DT_INICIO"));
	res.setCheckOut(resultados.getDate("DT_FIM"));

	FuncionarioDAO funcionarioBD = new FuncionarioDAO();
	res.setFuncionario(funcionarioBD.getFuncionarioById(res.getIdFuncionario()));

	HospedeDAO hospedeBD = new HospedeDAO();
	res.setHospede(hospedeBD.getHospedeById(res.getIdHospede()));

	QuartoDAO quartoBD = new QuartoDAO();
	res.setQuarto(quartoBD.buscarQuartoId(resultados.getString("ID_QUARTO")));

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

  public List<Reserva> listarReservasParaCheckOut(String dtFim) throws ParseException {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    java.util.Date dataIni = new java.util.Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try {
      dataIni = sdf.parse(dtFim);
    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    java.sql.Date sqlDataFim = new java.sql.Date(dataIni.getTime());

    List<Reserva> listaReservas = new ArrayList<>();

    String Query = "SELECT STATUS, ID_RESERVA, ID_UNIDADE, ID_HOSPEDE, ID_FUNCIONARIO, ID_QUARTO, DT_INICIO, DT_FIM FROM TB_RESERVA "
	    + "WHERE DT_FIM = ? ";

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setDate(1, sqlDataFim);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Reserva res = new Reserva();

	res.setStatus(resultados.getString("STATUS"));
	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdUnidade(resultados.getInt("ID_UNIDADE"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setCheckIn(resultados.getDate("DT_INICIO"));
	res.setCheckOut(resultados.getDate("DT_FIM"));

	FuncionarioDAO funcionarioBD = new FuncionarioDAO();
	res.setFuncionario(funcionarioBD.getFuncionarioById(res.getIdFuncionario()));

	HospedeDAO hospedeBD = new HospedeDAO();
	res.setHospede(hospedeBD.getHospedeById(res.getIdHospede()));

	QuartoDAO quartoBD = new QuartoDAO();
	res.setQuarto(quartoBD.buscarQuartoId(resultados.getString("ID_QUARTO")));

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

  public Reserva getReservaByID(int idReserva) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String Query = "SELECT STATUS, ID_RESERVA, ID_UNIDADE, ID_HOSPEDE, ID_FUNCIONARIO, ID_QUARTO, DT_INICIO, DT_FIM FROM TB_RESERVA "
	    + "WHERE ID_RESERVA = ? ";

    try {

      Reserva res = new Reserva();

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setInt(1, idReserva);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	res.setStatus(resultados.getString("STATUS"));
	res.setId(resultados.getInt("ID_RESERVA"));
	res.setIdUnidade(resultados.getInt("ID_UNIDADE"));
	res.setIdFuncionario(resultados.getInt("ID_FUNCIONARIO"));
	res.setIdHospede(resultados.getInt("ID_HOSPEDE"));
	res.setIdQuarto(resultados.getInt("ID_QUARTO"));
	res.setCheckIn(resultados.getDate("DT_INICIO"));
	res.setCheckOut(resultados.getDate("DT_FIM"));

	FuncionarioDAO funcionarioBD = new FuncionarioDAO();
	res.setFuncionario(funcionarioBD.getFuncionarioById(res.getIdFuncionario()));

	HospedeDAO hospedeBD = new HospedeDAO();
	res.setHospede(hospedeBD.getHospedeById(res.getIdHospede()));

	QuartoDAO quartoBD = new QuartoDAO();
	res.setQuarto(quartoBD.buscarQuartoId(resultados.getString("ID_QUARTO")));

      }

      return res;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

    } catch (ParseException ex) {
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " UPDATE INTO TB_RESERVA (ID_RESERVA, STATUS, ID_UNIDADE, ID_FUNCIONARIO, ID_HOSPEDE, ID_QUARTO, DT_INICIO, DT_FIM) VALUES (?, ?, ?, ?, ?, ?, ?, ?)\n ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, res.getId());
      stmt.setString(2, res.getStatus());
      stmt.setInt(3, res.getIdUnidade());
      stmt.setInt(4, res.getIdFuncionario());
      stmt.setInt(5, res.getIdHospede());
      stmt.setInt(6, res.getIdQuarto());

      java.sql.Date sqlDataCheckin = new java.sql.Date(res.getCheckIn().getTime());
      stmt.setDate(7, sqlDataCheckin);

      java.sql.Date sqlDataCheckout = new java.sql.Date(res.getCheckOut().getTime());
      stmt.setDate(8, sqlDataCheckout);

      stmt.executeUpdate();
      System.out.println("[INFO] Reserva alterada com sucesso.");

      return true;

    } catch (SQLException ex) {

      System.err.println("[ERRO] Não foi possível alterar a reserva.");
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return false;

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

  public boolean checkInReserva(int reservaID) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " UPDATE TB_RESERVA SET STATUS = 'P' \n"
	    + "WHERE ID_RESERVA = ? ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, reservaID);

      stmt.executeUpdate();
      System.out.println("[INFO] Check-In da Reserva #" + reservaID + " iniciado com sucesso.");

      return true;

    } catch (SQLException ex) {

      System.err.println("[ERRO] Não foi possível o check-in da reserva #" + reservaID + ".");
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return false;

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

  public boolean checkOutReserva(int reservaID) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " UPDATE TB_RESERVA SET STATUS = 'F' \n"
	    + "WHERE ID_RESERVA = ? ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, reservaID);

      stmt.executeUpdate();
      System.out.println("[INFO] Check-out da estadia #" + reservaID + " fechado com sucesso.");

      return true;

    } catch (SQLException ex) {

      System.err.println("[ERRO] Não foi possível o check-out da reserva #" + reservaID + ".");
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return false;

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

  public boolean cancelarReserva(int reservaID) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " UPDATE TB_RESERVA SET STATUS = 'C' \n"
	    + "WHERE ID_RESERVA = ? ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, reservaID);

      stmt.executeUpdate();
      System.out.println("[INFO] Cancelamento da reserva #" + reservaID + " realizado com sucesso.");

      return true;

    } catch (SQLException ex) {

      System.err.println("[ERRO] Não foi possível cancelar a reserva #" + reservaID + ".");
      Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);

      return false;

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
