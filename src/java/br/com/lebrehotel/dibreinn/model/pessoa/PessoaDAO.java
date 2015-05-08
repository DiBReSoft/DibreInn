package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author jSilverize data: 02/05/2015
 */
import br.com.lebrehotel.dibreinn.model.DAO;
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PessoaDAO {
////    
//    public static void main (String[] args){
//     Funcionario p =  new Funcionario();
//     
//      p.setNome("Teste");
//      p.setSobrenome("Silva");
//      p.setCpf("43874154");
//      p.setRg("5555555");
//      p.setDataNascimento(java.sql.Date.valueOf("1988-1-28"));
//      p.setEmail("Thiago@junior@hotmail.com");
//      p.setCep("22222222");
//      p.setBairro("interlagos");
//      p.setLogradouro("av.socorro");
//      p.setCidade("sp");
//      p.setComplemento("na");
//      p.setNumero(23);
//      p.setSexo("M");
//     
//     cadastrarPessoa(p);
//      
//     
//    
//    }

  public int cadastrarPessoa(Pessoa p) {

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    String sql = "INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try {
      conexao.openConection();

      stmt = conexao.conn.prepareStatement(sql);

      stmt.setString(1, p.getNome());
      stmt.setString(2, p.getSobrenome());
      stmt.setString(3, p.getSexo());
      stmt.setString(4, p.getRg());
      stmt.setString(5, p.getCpf());
      stmt.setDate(6, null);
      //stmt.setDate(6, p.getDataNascimento()); // Não está funcionando ainda
      stmt.setString(7, p.getTelefone());
      stmt.setString(8, p.getEmail());

      stmt.execute();

      /* Seria o bloco de código para pegar o ID gerado pelo BD 
       * e retorna-lo para a pagina, mas não está funcionando
      
       ResultSet rsId = stmt.getGeneratedKeys();
       p.setId(rsId.getInt(1));
      
       */
      
      // Fechando conexão
      conexao.closeConection();

      // Faz o retorno do ID, para uso de redirecionamento
      // return p.getId(); // Depende do bloco de getGeneratedKeys();
      
      // TESTE: irá retornar 1 se o cadastro for feito e então a página será
      // redirecionada com o paramêtro 1. Se houver erro, o parametro será 0
      return 1;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);
      return 0;
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

  }

  /*

   public boolean montarQueryInsert(Hospede hospede) {
   String Query = "INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, EMAIL) \n" +
   "           VALUES \n" +
   "        (?,?,?,?,?,?,?,?)";

   List<Object> listaHospede= new ArrayList<Object>();
   listaHospede.add(hospede.getNome());
   listaHospede.add(hospede.getSobrenome());
   listaHospede.add(hospede.getSexo());
   listaHospede.add(hospede.getRg());
   listaHospede.add(hospede.getCpf());
   listaHospede.add(hospede.getDataNascimento());
   listaHospede.add(hospede.getTelefone());
   listaHospede.add(hospede.getEmail());
   listaHospede.add(hospede.getCep());
   listaHospede.add(hospede.getBairro());
   listaHospede.add(hospede.getLogradouro());
   listaHospede.add(hospede.getCidade());
   listaHospede.add(hospede.getComplemento());
   listaHospede.add(hospede.getNumero());
   listaHospede.add(hospede.getnPassaporte());
   listaHospede.add(hospede.getFoto());
   listaHospede.add(hospede.getNacionalidade());
   listaHospede.add(hospede.getnCartao());
   boolean r = false;
   try{
   DAO dao = new DAO();
             
   r=  dao.ExecutaSQL(Query, listaHospede);
   }catch(SQLException ex){
   System.out.println(ex);
   }
   return r;
   }
   
   //public montarQueryBuscar(String Pesquisa){
       
       
   //}

   */
}
