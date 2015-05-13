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

  public int cadastrarPessoa(Pessoa p, Endereco e) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = " INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, CEL, EMAIL, TIPO, NEWSLETTER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) \n ";

    sql += " DECLARE @IdCliente AS INT = @@IDENTITY \n";//pega o id_pessoa da transação

    sql += " INSERT INTO TB_ENDERECO (ID_PESSOA,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO,PAIS) VALUES (@IdCliente,?,?,?,?,?,?,?,?) \n ";

//        if (p instanceof Funcionario) {
//        sql += " INSERT INTO TB_FUNCIONARIO (ID_PESSOA,ID_UNIDADE,DEPARTAMENTO,CARGO,SALARIO,USUARIO,SENHA) VALUES (@IdCliente,?,?,?,?,?,?) \n ";
//        }else{
//        sql += " INSERT INTO TB_HOSPEDE (ID_PESSOA,CPF_NOTA,NACIONALIDADE,N_PASSAPORTE,N_CARTAO) VALUES (@IdCliente,?,?,?,?) ";
//        }
    try {
      conexao.openConection();
      stmt = conexao.conn.prepareStatement(sql);

      stmt.setString(1, p.getNome());
      stmt.setString(2, p.getSobrenome());
      stmt.setString(3, p.getSexo());
      stmt.setString(4, p.getRg());
      stmt.setString(5, p.getCpf());
      stmt.setDate(6, p.getDataNascimento());
      stmt.setString(7, p.getTelefone());
      stmt.setString(8, p.getCelular());
      stmt.setString(9, p.getEmail());
      stmt.setString(10, p.getTipo());
      stmt.setInt(11, p.getNewsletter());

      stmt.setString(12, e.getLogradouro());
      stmt.setString(13, e.getNumero());
      stmt.setString(14, e.getCep());
      stmt.setString(15, e.getComplemento());
      stmt.setString(16, e.getBairro());
      stmt.setString(17, e.getCidade());
      stmt.setString(18, e.getEstado());
      stmt.setString(19, e.getPais());

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
