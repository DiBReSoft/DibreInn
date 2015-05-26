package br.com.lebrehotel.dibreinn.model.hospede;

/**
 *
 * @author luciano, udimberto.sjunior data: 25/05/2015
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HospedeDAO {

  public boolean cadastrarHospede(Hospede h) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sqlInsert = "INSERT INTO TB_PESSOA (STATUS, NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sqlInsert += "DECLARE @IdCliente AS INT = @@IDENTITY \n";
    //pega o id_pessoa da transação

    sqlInsert += "INSERT INTO TB_HOSPEDE (ID_PESSOA, N_CARTAO) VALUES (@IdCliente, ?) ";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sqlInsert);

      stmt.setInt(1, 1);
      stmt.setString(2, h.getNome());
      stmt.setString(3, h.getSobrenome());
      stmt.setString(4, h.getSexo());
      stmt.setString(5, h.getRg());
      stmt.setString(6, h.getCpf());

      java.sql.Date sqlDataNasc = new java.sql.Date(h.getDataNascimento().getTime());
      stmt.setDate(7, sqlDataNasc);

      stmt.setString(8, h.getTelefone());
      stmt.setString(9, h.getCelular());
      stmt.setString(10, h.getEmail());
      stmt.setInt(11, h.getNewsletter());
      stmt.setString(12, h.getnCartao());

      stmt.executeUpdate();
      System.out.println("[INFO] Hospede " + h.getNome() + " " + h.getSobrenome() + " cadastrado com sucesso!");

      return true;

    } catch (SQLException ex) {

      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);

      return false;

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public void editarHospede(Hospede h) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "UPDATE TB_PESSOA SET STATUS = ?, NOME = ?, SOBRENOME = ?, "
	    + "SEXO = ?, RG = ?, CPF = ?, DATANASC = ?, TELEFONE = ?, CEL = ?, EMAIL = ?, NEWSLETTER = ? \n"
	    + "WHERE ID_PESSOA = ? \n";

    sql += " UPDATE TB_HOSPEDE SET N_CARTAO = ? WHERE ID_PESSOA = ?";

    try {

      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, h.getStatus());
      stmt.setString(2, h.getNome());
      stmt.setString(3, h.getSobrenome());
      stmt.setString(4, h.getSexo());
      stmt.setString(5, h.getRg());
      stmt.setString(6, h.getCpf());

      java.sql.Date sqlDataNasc = new java.sql.Date(h.getDataNascimento().getTime());
      stmt.setDate(7, sqlDataNasc);

      stmt.setString(8, h.getTelefone());
      stmt.setString(9, h.getCelular());
      stmt.setString(10, h.getEmail());
      stmt.setInt(11, h.getNewsletter());
      stmt.setInt(12, h.getId());

      stmt.setString(13, h.getnCartao());
      stmt.setInt(14, h.getId());

      stmt.executeUpdate();

      System.out.println("[INFO] Hospede " + h.getNome() + " " + h.getSobrenome() + " atualizado com sucesso.");

    } catch (SQLException ex) {
      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
  }

  public List<Hospede> buscarHospedes(String pesquisa, int tipoBusca) {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Hospede> lista = new ArrayList<>();

    String Query = "SELECT STATUS, TB_PESSOA.ID_PESSOA,NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER \n"
	    + "FROM TB_PESSOA \n"
            + "INNER JOIN TB_HOSPEDE on TB_HOSPEDE.ID_PESSOA = TB_PESSOA.ID_PESSOA \n"
            + " WHERE ";
    switch (tipoBusca) {
      case 1:
	Query += "NOME = ?";
	break;
      case 2:
	Query += "EMAIL = ?";
	break;
      case 3:
	Query += "CPF = ?";
	break;
      case 4:
	Query += "TB_PESSOA.ID_PESSOA = ?";
	break;
    }
    
    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setString(1, pesquisa);

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Hospede p = new Hospede();

	p.setId(resultados.getInt("ID_PESSOA"));
	p.setStatus(resultados.getInt("STATUS"));	
	p.setNome(resultados.getString("NOME"));
	p.setSobrenome(resultados.getString("SOBRENOME"));
	p.setSexo(resultados.getString("SEXO"));
	p.setRg(resultados.getString("RG"));
	p.setCpf(resultados.getString("CPF"));
	
      //  Date teste =resultados.getDate("DATANASC");
        //int dia,mes,ano;
        //dia = teste.getDay();
        //mes = teste.getMonth();
        //ano = teste.getYear();
       //String data = dia+"/"+mes+"/"+ano;
      
        p.setDataNascimento(resultados.getDate("DATANASC"));
	p.setTelefone(resultados.getString("TELEFONE"));
	p.setCelular(resultados.getString("CEL"));
	p.setEmail(resultados.getString("EMAIL"));
	p.setNewsletter(resultados.getInt("NEWSLETTER"));

	lista.add(p);

      }

      return lista;
    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }

  public Hospede getHospedeById(int id) {

    System.out.println("Buscar hospede pelo ID: " + id);

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query;
    Hospede hosp = new Hospede();

    query = "SELECT pe.ID_PESSOA, pe.STATUS, pe.NOME, pe.SOBRENOME, pe.SEXO, pe.RG, CPF, pe.DATANASC, pe.TELEFONE, pe.CEL, pe.EMAIL ,pe.NEWSLETTER,\n"
	    + "hosp.N_CARTAO\n"
	    + "FROM TB_HOSPEDE as hosp\n"
	    + "INNER JOIN TB_PESSOA as pe on pe.ID_PESSOA = hosp.ID_PESSOA\n"
	    + "WHERE hosp.ID_PESSOA = ?";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(query);
      stmt.setInt(1, id);

      ResultSet result = stmt.executeQuery();
      result.next();

      hosp.setId(id);
      hosp.setStatus(result.getInt("STATUS"));
      hosp.setNome(result.getString("NOME"));
      hosp.setSobrenome(result.getString("SOBRENOME"));
      hosp.setSexo(result.getString("SEXO"));
      hosp.setRg(result.getString("RG"));
      hosp.setCpf(result.getString("CPF"));

      hosp.setDataNascimento(result.getDate("DATANASC"));

      hosp.setTelefone(result.getString("TELEFONE"));
      hosp.setCelular(result.getString("CEL"));
      hosp.setEmail(result.getString("EMAIL"));
      hosp.setNewsletter(result.getInt("NEWSLETTER"));
      hosp.setnCartao(result.getString("N_CARTAO"));

      System.out.println("[INFO] Hospede encontrado e retornando.");
      conexao.closeConection();

      return hosp;

    } catch (SQLException ex) {
      // Caso haja erro 
      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de hospede: ", ex);
      conexao.closeConection();

      return null;

    }

  }

}
