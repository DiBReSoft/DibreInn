package br.com.lebrehotel.dibreinn.model.usuario;

/**
 *
 * @author thiago
 */
import br.com.lebrehotel.dibreinn.model.unidade.Unidade;
import br.com.lebrehotel.dibreinn.model.unidade.UnidadeDAO;
import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public Usuario validarDados(String usuario, String senha) {

        ConectarBD conexao = new ConectarBD();

        PreparedStatement stmt = null;
        Usuario u = null;

        String query = "SELECT P.EMAIL as EMAIL, P.NOME as NOME, P.SOBRENOME as SOBRENOME, P.ID_PESSOA as ID, "
                + "F.SENHA as SENHA, F.ID_UNIDADE as ID_UNIDADE, F.ID_PRIVILEGIO as ID_PRIVILEGIO "
                + "FROM TB_PESSOA AS P "
                + "JOIN TB_FUNCIONARIO AS F "
                + "ON P.ID_PESSOA = F.ID_PESSOA "
                + "WHERE P.EMAIL = ? AND F.SENHA = ?";

        try {

            conexao.openConection();
            stmt = conexao.conn.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            //Condição que verifica se o usuário tem login no sistema
            if (rs.getString("SENHA").equalsIgnoreCase("")) {

                return u;

                //Condição que verifica se a consulta retornou algo
            } else if (rs.getString("EMAIL").equalsIgnoreCase("")) {

                return u;

            }

            u = new Usuario();
	    u.setId(rs.getInt("ID"));
            u.setLogin(rs.getString("EMAIL"));
            u.setSenha(rs.getString("SENHA"));
            u.setNome(rs.getString("NOME") + " " + rs.getString("SOBRENOME"));
            u.setUnidadeId(rs.getInt("ID_UNIDADE"));
            u.setPrivilegio(rs.getInt("ID_PRIVILEGIO"));
            
            UnidadeDAO unidadeBD = new UnidadeDAO();
            Unidade unidadeUsuario;
            unidadeUsuario = unidadeBD.buscarUnidadeId(u.getUnidadeId());
            u.setUnidadeNome(unidadeUsuario.getNome());

        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar os dados: " + query, ex);

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

    public List<Usuario> listarUsuarios() {
        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        List<Usuario> lista = new ArrayList<>();

        String Query = "SELECT P.ID_PESSOA AS ID, P.EMAIL AS EMAIL, F.SENHA AS SENHA, P.STATUS AS STATUS "
                + "FROM TB_PESSOA AS P "
                + "JOIN TB_FUNCIONARIO AS F "
                + "ON P.ID_PESSOA = F.ID_PESSOA ";

        try {
            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);

            rs = stmt.executeQuery();
            Usuario u = null;
            while (rs.next()) {

                u = new Usuario();
                u.setId(rs.getInt("ID"));
                u.setLogin(rs.getString("EMAIL"));
                u.setSenha(rs.getString("SENHA"));
                u.setStatus(rs.getInt("STATUS"));

                lista.add(u);

            }

            return lista;
        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao consultar os dados de UNIDADES: ", ex);

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
        return null;
    }
    
    

}
