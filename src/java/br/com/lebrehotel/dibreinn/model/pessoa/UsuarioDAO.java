package br.com.lebrehotel.dibreinn.model.pessoa;

/**
 *
 * @author Fabio
 */
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    public Usuario ValidarDados(String usuario, String senha){
        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;
        Usuario u = null;
        
        String query = "SELECT P.EMAIL, F.SENHA FROM TB_PESSOA AS P\n" +
        "JOIN TB_FUNCIONARIO AS F\n" +
        "ON P.ID_PESSOA = F.ID_PESSOA\n" +
        "WHERE P.EMAIL = ? AND F.SENHA = ?";
        
        try{
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            //Condição que verifica se o usuário tem login no sistema
            if (rs.getString("SENHA").equalsIgnoreCase("")){
                return u;
            //Condição que verifica se a consulta retornou algo
            } else if (rs.getString("EMAIL").equalsIgnoreCase("")){
                return u;
            }
            u = new Usuario(rs.getString("USUARIO"), rs.getString("SENHA"), null);
        }catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar os dados: ", ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {
                conexao.closeConection();
            }
        }
        return u;
    }
}
