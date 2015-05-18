package br.com.lebrehotel.dibreinn.model.unidade;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago
 */
public class UnidadeDAO {

    public int cadastrarQuarto(Unidade u) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String sql = "INSERT INTO TB_UNIDADE (ID_UNIDADE,CNPJ,TIPO,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO) VALUES  (?,?,?,?,?,?,?,?,?,?)";

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sql);
            
            stmt.setString(1, u.getId_unidade());
            stmt.setString(2,u.getCnpj());
            stmt.setInt(3, u.getTipo());
            stmt.setString(4, u.getLogradouro());
            stmt.setString(5, u.getNumero());
            stmt.setString(6, u.getCep());
            stmt.setString(7, u.getComplemento());
            stmt.setString(8, u.getBairro());
            stmt.setString(9, u.getCidade());
            stmt.setString(10, u.getEstado());   
            
            stmt.executeUpdate();
            System.out.println("Dados Salvos com sucesso!!!");

        } catch (SQLException ex) {
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao.conn != null) {
                try {
                    conexao.conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

    public List<Unidade> BuscarUnidades(String pesquisa,int tipoBusca) {
        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        List<Unidade> lista = new ArrayList<Unidade>();

        String Query = "SELECT ID_UNIDADE,CNPJ,TIPO,LOGRADOURO,NUM,CEP,COMPLEMENTO,BAIRRO,CIDADE,ESTADO \n" +
        "FROM TB_UNIDADE \n";
        
        switch (tipoBusca) {
            case 1:
                Query += "WHERE ID_UNIDADE=?";
                break;
        }

        try {
            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);
            
            if(tipoBusca == 1)
            stmt.setString(1, pesquisa);
            
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Unidade u = new Unidade();
                
                u.setId_unidade(resultados.getString("ID_QUARTO"));
                u.setCnpj(resultados.getString("CNPJ"));
                u.setTipo(resultados.getInt("TIPO"));
                u.setNumero(resultados.getString("NUMERO"));
                u.setCep(resultados.getString("CEP"));
                u.setLogradouro(resultados.getString("LOGRADOURO"));
                
                u.setComplemento(resultados.getString("COMPLEMENTO"));
                u.setBairro(resultados.getString("BAIRRO"));
                u.setCidade(resultados.getString("CIDADE"));
                u.setEstado(resultados.getString("ESTADO"));

                lista.add(u);
            }

            return lista;
        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UnidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {
                conexao.closeConection();
            }
        }
        return null;
    }

}
