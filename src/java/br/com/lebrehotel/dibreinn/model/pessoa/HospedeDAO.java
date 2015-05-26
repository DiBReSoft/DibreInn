package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author luciano, udimberto.sjunior data: 25/05/2015
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HospedeDAO {

  public int cadastrarHospede(Hospede h) {

    int codPessoa;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sqlInsert = " INSERT INTO TB_PESSOA (STATUS, NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sqlInsert += " DECLARE @IdCliente AS INT = @@IDENTITY \n";
    //pega o id_pessoa da transação

    sqlInsert += " INSERT INTO TB_HOSPEDE (ID_PESSOA,N_CARTAO) VALUES (@IdCliente, ?) ";
    
    String sqlConsulta = "SELECT max(ID_PESSOA) as ID_PESSOA FROM TB_PESSOA";

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
      System.out.println("[INFO] Hospede " + h.getNome() + h.getSobrenome() + " cadastrado com sucesso!");

      System.out.println("Bucando o ID da pessoa cadastrada...");
      conexao.executaSQL(sqlConsulta);
      conexao.rs.next();
      codPessoa = conexao.rs.getInt("ID_PESSOA");
      System.out.println("ID encontrado!!!");
      System.out.println("ID: " + codPessoa + "\n");
      return codPessoa;

    } catch (SQLException ex) {
      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, null, ex);
      return 0;
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
	    + "SEXO = ?, RG = ?, CPF = ?, DATANASC ?, TEL = ?, CEL = ?, EMAIL = ?, NEWSLETTER = ? "
	    + "WHERE ID_PESSOA = ?";

    sql += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sql += " UPDATE INTO TB_HOSPEDE (ID_PESSOA, N_CARTAO) VALUES (@IdCliente, ?) ";

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
      stmt.setInt(13, h.getId());

      stmt.setString(12, h.getnCartao());

      stmt.executeUpdate();

      System.out.println("[INFO] Hospede " + h.getNome() + h.getSobrenome() + " atualizado com sucesso.");

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

  public Hospede getHospedeById(int id) {
    
    System.out.println("Buscar hospede pelo ID: " + id);

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query;
    Hospede hosp = new Hospede();

    query = "SELECT pe.ID_PESSOA, pe.STATUS, pe.NOME, pe.SOBRENOME, pe.SEXO, pe.RG, CPF, pe.DATANASC, pe.TELEFONE, pe.CEL, pe.EMAIL ,pe.NEWSLETTER,\n"
	    + "hosp.N_CARTAO\n"
	    + "FROM TB_PESSOA as pe\n"
	    + "INNER JOIN TB_HOSPEDE as hosp on hosp.ID_PESSOA = pe.ID_PESSOA\n"
	    + "WHERE pe.ID_PESSOA = ?";

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

    } catch (SQLException ex) {
      // Caso haja erro 
      Logger.getLogger(HospedeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de hospede: ", ex);
      conexao.closeConection();
    }

    return hosp;

  }

}
