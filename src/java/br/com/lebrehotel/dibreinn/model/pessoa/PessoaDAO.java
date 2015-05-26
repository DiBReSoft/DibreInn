package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author jSilverize data: 02/05/2015
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO {

  public int cadastrarPessoa(Funcionario f, Endereco e) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    int codPessoa;

    String sqlConsulta = "SELECT max(ID_PESSOA) as ID_PESSOA FROM TB_PESSOA";

    String sqlInsert = " INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sqlInsert += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sqlInsert += " INSERT INTO TB_FUNCIONARIO (ID_PESSOA,ID_UNIDADE,DEPARTAMENTO,CARGO,SALARIO,SENHA) VALUES (@IdCliente,?,?,?,?,?) \n ";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sqlInsert);

      stmt.setString(1, f.getNome());
      stmt.setString(2, f.getSobrenome());
      stmt.setString(3, f.getSexo());
      stmt.setString(4, f.getRg());
      stmt.setString(5, f.getCpf());
      stmt.setDate(6, (Date) f.getDataNascimento());
      stmt.setString(7, f.getTelefone());
      stmt.setString(8, f.getCelular());
      stmt.setString(9, f.getEmail());
      stmt.setInt(10, f.getNewsletter());

      stmt.setInt(20, f.getUnidade());
      stmt.setString(21, f.getDepartamento());
      stmt.setString(22, f.getCargo());
      stmt.setDouble(23, f.getSalario());
      stmt.setString(24, f.getSenha());
      stmt.executeUpdate();

      System.out.println("Dados Salvos com sucesso!!!");

      System.out.println("Bucando o id da pessoa cadastrada...");
      conexao.executaSQL(sqlConsulta);
      conexao.rs.next();
      codPessoa = conexao.rs.getInt("ID_PESSOA");
      System.out.println("Id encontrado!!");
      System.out.println("Id: " + codPessoa + "\n");

    } catch (SQLException ex) {
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
      return 0;
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return codPessoa;
  }

  public int cadastrarPessoa(Hospede h, Endereco e) {

    int codPessoa;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sqlConsulta = "SELECT max(ID_PESSOA) as ID_PESSOA FROM TB_PESSOA";

    String sqlInsert = " INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sqlInsert += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sqlInsert += " INSERT INTO TB_HOSPEDE (ID_PESSOA,N_CARTAO) VALUES (@IdCliente,?) ";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sqlInsert);

      stmt.setString(1, h.getNome());
      stmt.setString(2, h.getSobrenome());
      stmt.setString(3, h.getSexo());
      stmt.setString(4, h.getRg());
      stmt.setString(5, h.getCpf());
      stmt.setDate(6, (Date) h.getDataNascimento());
      stmt.setString(7, h.getTelefone());
      stmt.setString(8, h.getCelular());
      stmt.setString(9, h.getEmail());
      stmt.setInt(10, h.getNewsletter());

      stmt.setString(11, h.getnCartao());

      stmt.executeUpdate();
      System.out.println("Dados Salvos com sucesso!!!");

      System.out.println("Bucando o id da pessoa cadastrada...");

      conexao.executaSQL(sqlConsulta);
      conexao.rs.next();
      codPessoa = conexao.rs.getInt("ID_PESSOA");
      System.out.println("Id encontrado!!");
      System.out.println("Id: " + codPessoa + "\n");

    } catch (SQLException ex) {
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
      return 0;
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return codPessoa;
  }

  public List<Pessoa> buscarPessoas(String pesquisa, int tipoBusca) {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Pessoa> lista = new ArrayList<>();

    String Query = "SELECT STATUS, ID_PESSOA,NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, NEWSLETTER \n"
	    + "FROM TB_PESSOA WHERE ";

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
	Query += "ID_PESSOA = ?";
	break;
    }
    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);
      
      stmt.setString(1, pesquisa);
      
      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {
	
	Hospede p = new Hospede();

	p.setStatus(resultados.getInt("STATUS"));
	p.setId(resultados.getInt("ID_PESSOA"));
	p.setNome(resultados.getString("NOME"));
	p.setSobrenome(resultados.getString("SOBRENOME"));
	p.setSexo(resultados.getString("SEXO"));
	p.setRg(resultados.getString("RG"));
	p.setCpf(resultados.getString("CPF"));
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
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }
    }
    return null;
  }

  public int atualizaPessoaFuncionario(int id, Funcionario p, Endereco e) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "BEGIN TRANSACTION "
	    + "DECLARE @idCliente INT = ? "
	    + "UPDATE TB_PESSOA SET SOBRENOME='?', DATANASC='?', TELEFONE='?',CEL='?', EMAIL='?',NEWSLETTER=?"
	    + "WHERE ID_PESSOA = @idCliente"
	    + "UPDATE TB_FUNCIONARIO SET ID_UNIDADE='?',DEPARTAMENTO='?',CARGO='?',SALARIO=?,SENHA='?'"
	    + "WHERE ID_PESSOA =@idCliente"
	    + "UPDATE TB_ENDERECO SET LOGRADOURO='?',NUM=?,CEP='?',COMPLEMENTO='?',BAIRRO='?',CIDADE='?',ESTADO='?',PAIS='?'"
	    + "WHERE ID_PESSOA = @idCliente"
	    + "IF @@ERROR <> 0\n BEGIN\n ROLLBACK\n END\n ELSE\n COMMIT\n GO";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setInt(1, id);
      stmt.setString(2, p.getSobrenome());
      stmt.setDate(3, (Date) p.getDataNascimento());
      stmt.setString(4, p.getTelefone());
      stmt.setString(5, p.getCelular());
      stmt.setString(5, p.getEmail());
      stmt.setInt(7, p.getNewsletter());

      stmt.setInt(8, p.getUnidade());
      stmt.setString(9, p.getDepartamento());
      stmt.setString(10, p.getCargo());
      stmt.setDouble(11, p.getSalario());
      stmt.setString(12, p.getSenha());

      stmt.setString(13, e.getLogradouro());
      stmt.setString(14, e.getNumero());
      stmt.setString(15, e.getCep());
      stmt.setString(16, e.getComplemento());
      stmt.setString(17, e.getBairro());
      stmt.setString(18, e.getCidade());
      stmt.setString(19, e.getEstado());
      stmt.setString(20, e.getPais());

      stmt.executeUpdate();
      System.out.println("Dados Alterados com sucesso!!!");

    } catch (SQLException ex) {
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println("Erro ao alterar os dados");
      return 0;
    } finally {
      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao.conn != null) {
	try {
	  conexao.conn.close();
	} catch (SQLException ex) {
	  Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
    }
    return 1;
  }

  public Funcionario getFuncionario(int id) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query;
    Funcionario func = new Funcionario();

    query = "SELECT pe.STATUS, pe.ID_PESSOA, pe.NOME, pe.SOBRENOME, pe.SEXO, pe.RG, CPF, pe.DATANASC, pe.TELEFONE, pe.CEL, pe.EMAIL, pe.TIPO,pe.NEWSLETTER,"
	    + "func.ID_UNIDADE, func.DEPARTAMENTO, func.CARGO, func.SALARIO "
	    + "FROM TB_FUNCIONARIO as func "
	    + "INNER JOIN TB_PESSOA as pe on pe.ID_PESSOA = func.id_pessoa Where func.ID_PESSOA =?";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet result = stmt.executeQuery();
      result.next();

      func.setStatus(result.getInt("STATUS"));
      func.setId(result.getInt("ID_PESSOA"));
      func.setNome(result.getString("NOME"));
      func.setSobrenome(result.getString("SOBRENOME"));
      func.setSexo(result.getString("SEXO"));
      func.setRg(result.getString("RG"));
      func.setCpf(result.getString("CPF"));
      func.setDataNascimento(result.getDate("DATANASC"));
      func.setTelefone(result.getString("TELEFONE"));
      func.setCelular(result.getString("CEL"));
      func.setEmail(result.getString("EMAIL"));
      func.setNewsletter(result.getInt("NEWSLETTER"));
      func.setUnidade(Integer.parseInt(result.getString("ID_UNIDADE")));
      func.setDepartamento(result.getString("DEPARTAMENTO"));
      func.setCargo(result.getString("CARGO"));
      func.setSalario(result.getDouble("SALARIO"));

      System.out.println("Dados de funcionario populados com sucesso");
      conexao.closeConection();

    } catch (SQLException ex) {
      // Caso haja erro 
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de funcionario: ", ex);
      conexao.closeConection();
    }

    return func;

  }

  public Hospede getHospede(int id) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query;
    Hospede hosp = new Hospede();

    query = "SELECT pe.STATUS, pe.ID_PESSOA,pe.NOME, pe.SOBRENOME, pe.SEXO, pe.RG, CPF, pe.DATANASC, pe.TELEFONE, pe.CEL, pe.EMAIL, pe.TIPO,pe.NEWSLETTER,\n"
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

      hosp.setStatus(result.getInt("STATUS"));
      hosp.setId(result.getInt("ID_PESSOA"));
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

      System.out.println("Dados de funcionario populados com sucesso");
      conexao.closeConection();

    } catch (SQLException ex) {
      // Caso haja erro 
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de hospede gravar os dados: ", ex);
      conexao.closeConection();
    }

    return hosp;

  }

  public int consultarIdPessoa(String cpf) {
    int idPessoa;
    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String consultaCpf = "SELECT ID_PESSOA FROM TB_PESSOA WHERE CPF=" + cpf;

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(consultaCpf);
      ResultSet result = stmt.executeQuery();
      result.next();
      idPessoa = result.getInt("ID_PESSOA");
      System.out.println("ID encontrado com sucesso!");
      conexao.closeConection();
      return idPessoa;

    } catch (SQLException ex) {
      conexao.closeConection();
      System.out.println("Erro ao retornar o id: " + ex);
      return 0;
    }

  }

  public boolean isFuncionario(int id) {
    String tipoPessoa;
    boolean result = false;
    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String consultaCpf = "SELECT TIPO FROM TB_PESSOA WHERE ID_PESSOA=?";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(consultaCpf);
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
      rs.next();

      tipoPessoa = rs.getString("TIPO");
      if (tipoPessoa.equalsIgnoreCase("f")) {
	conexao.closeConection();
	System.out.println("É funcionario");
	result = true;

      } else {
	conexao.closeConection();
	System.out.println("É Hospede");
	result = false;
	return result;
      }

    } catch (SQLException ex) {
      System.out.println("Erro ao procurar o tipo de pessoa: " + ex);
    }
    return result;
  }

  public int deletarPessoa(int id, String tipo) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ? \n";
    if (tipo.equalsIgnoreCase("f")) {
      query += " DELETE FROM TB_FUNCIONARIO WHERE ID_PESSOA = ?";
    } else {
      query += " DELETE FROM TB_HOSPEDE WHERE ID_PESSOA = ?";
    }

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(query);
      stmt.setInt(1, id);
      stmt.executeQuery();
      System.out.println("deletado com sucesso!");
      conexao.closeConection();
      return 1;

    } catch (SQLException ex) {
      conexao.closeConection();
      System.out.println("Erro ao retornar o id: " + ex);
      return 0;
    }
  }

  public Endereco getEndereco(int id) {

    Endereco end = new Endereco();
    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;
    String query;

    query = "SELECT LOGRADOURO, NUM, CEP, COMPLEMENTO, BAIRRO,CIDADE, ESTADO, PAIS FROM TB_ENDERECO WHERE ID_PESSOA = ?";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(query);
      stmt.setInt(1, id);
      ResultSet result = stmt.executeQuery();
      result.next();

      end.setLogradouro(result.getString("LOGRADOURO"));
      end.setNumero(result.getString("NUM"));
      end.setCep(result.getString("CEP"));
      end.setComplemento(result.getString("COMPLEMENTO"));
      end.setBairro(result.getString("BAIRRO"));
      end.setCidade(result.getString("CIDADE"));
      end.setEstado(result.getString("ESTADO"));
      end.setPais(result.getString("Pais"));

      System.out.println("Dados de endereço populados com sucesso");
      conexao.closeConection();

    } catch (SQLException ex) {
      // Caso haja erro 
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao popular os dados de hospede gravar os dados: ", ex);
      conexao.closeConection();
    }

    return end;
  }
}
