package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author jSilverize data: 02/05/2015
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PessoaDAO {

  public int cadastrarPessoa(Funcionario f, Endereco e) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, TIPO, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sql += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sql += " INSERT INTO TB_ENDERECO (ID_PESSOA,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO,PAIS) VALUES (@IdCliente,?,?,?,?,?,?,?,?) \n ";

    sql += " INSERT INTO TB_FUNCIONARIO (ID_PESSOA,ID_UNIDADE,DEPARTAMENTO,CARGO,SALARIO,SENHA) VALUES (@IdCliente,?,?,?,?,?) \n ";
    
    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setString(1, f.getNome());
      stmt.setString(2, f.getSobrenome());
      stmt.setString(3, f.getSexo());
      stmt.setString(4, f.getRg());
      stmt.setString(5, f.getCpf());
      stmt.setDate(6, f.getDataNascimento());
      stmt.setString(7, f.getTelefone());
      stmt.setString(8, f.getCelular());
      stmt.setString(9, f.getEmail());
      stmt.setString(10, f.getTipo());
      stmt.setInt(11, f.getNewsletter());

      stmt.setString(12, e.getLogradouro());
      stmt.setString(13, e.getNumero());
      stmt.setString(14, e.getCep());
      stmt.setString(15, e.getComplemento());
      stmt.setString(16, e.getBairro());
      stmt.setString(17, e.getCidade());
      stmt.setString(18, e.getEstado());
      stmt.setString(19, e.getPais());
      
      stmt.setString(20, f.getUnidade());
      stmt.setString(21, f.getDepartamento());
      stmt.setString(22, f.getCargo());
      stmt.setDouble(23, f.getSalario());
      stmt.setString(24, f.getSenha());
      
      stmt.executeUpdate();
      System.out.println("Dados Salvos com sucesso!!!");

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
    return 1;
  }

  
  public int cadastrarPessoa(Hospede h, Endereco e) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, TIPO, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sql += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sql += " INSERT INTO TB_ENDERECO (ID_PESSOA,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO,PAIS) VALUES (@IdCliente,?,?,?,?,?,?,?,?) \n ";
    
    sql += " INSERT INTO TB_HOSPEDE (ID_PESSOA,N_CARTAO) VALUES (@IdCliente,?) ";

    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setString(1, h.getNome());
      stmt.setString(2, h.getSobrenome());
      stmt.setString(3, h.getSexo());
      stmt.setString(4, h.getRg());
      stmt.setString(5, h.getCpf());
      stmt.setDate(6, h.getDataNascimento());
      stmt.setString(7, h.getTelefone());
      stmt.setString(8, h.getCelular());
      stmt.setString(9, h.getEmail());
      stmt.setString(10, h.getTipo());
      stmt.setInt(11, h.getNewsletter());

      stmt.setString(12, e.getLogradouro());
      stmt.setString(13, e.getNumero());
      stmt.setString(14, e.getCep());
      stmt.setString(15, e.getComplemento());
      stmt.setString(16, e.getBairro());
      stmt.setString(17, e.getCidade());
      stmt.setString(18, e.getEstado());
      stmt.setString(19, e.getPais());
      
      stmt.setString(20, h.getnCartao());
      
      stmt.executeUpdate();
      System.out.println("Dados Salvos com sucesso!!!");

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
    return 1;
  }
  
  public List<Pessoa> BuscarPessoas(String pesquisa, int tipoBusca) {
    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String tipoPessoa = "";

    List<Pessoa> lista = new ArrayList<Pessoa>();

    String Query = "SELECT ID_PESSOA,NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, TIPO, NEWSLETTER FROM TB_PESSOA WHERE ";

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
	Pessoa p = null;
	
	tipoPessoa = resultados.getString("TIPO");
	if (tipoPessoa.equalsIgnoreCase("f")) {
	  p = new Funcionario();
	  p.setTipo("Funcionário");
	} else {
	  // criando pessoa tipo hospede
	  p = new Hospede();
	  p.setTipo("Hospede");
	}	
	
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
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

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

}
