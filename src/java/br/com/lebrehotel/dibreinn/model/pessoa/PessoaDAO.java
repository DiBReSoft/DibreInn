package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author jSilverize data: 02/05/2015
 */
import br.com.lebrehotel.dibreinn.model.DAO;
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PessoaDAO {
    
        public void cadastrarPessoa(Pessoa p) {
      
            ConectarBD conexao = new ConectarBD();
            PreparedStatement stmt = null;
            
        try{
            conexao.openConection();
            stmt = conexao.conn.prepareStatement("INSERT INTO TB_PESSOA (NOME, SOBRENOME, SEXO, RG, CPF, DATANASC, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getSobrenome());
            stmt.setString(2, p.getSexo());
            stmt.setString(4, p.getRg());
            stmt.setInt(5, p.getCpf());
            stmt.setDate(6, new java.sql.Date(p.getDataNascimento().getTime()));
            stmt.setInt(7, p.getTelefone());
            stmt.setString(8, p.getEmail());
            stmt.executeUpdate();
            conexao.closeConection();
            JOptionPane.showMessageDialog(null, "Dados Incluidos com sucesso");

//        } catch (SQLException ex) {
//            Logger.getLogger(IncluirPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(IncluirPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(IncluirPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if (conn != null) {
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(IncluirPessoaServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
        } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "Erro ao gravar os dados " + ex);
    }
    }


  /*
   public List<Pessoa> listarPessoas() {
    
   DAO dao = new DAO();
    
   // dibrar
    
   }
   */
}
