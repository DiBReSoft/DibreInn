package br.com.lebrehotel.dibreinn.model.quarto;

import br.com.lebrehotel.dibreinn.model.Quarto;
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
public class QuartoDAO {

    public int cadastrarQuarto(Quarto q) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String sql = " INSERT INTO TB_QUARTO (VALOR_DIARIA,OCUPADO,NUMERO,ANDAR,RAMAL) VALUES (?, ?, ?, ?,?) \n ";

        try {
            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sql);
            
            stmt.setDouble(1, q.getValorDiaria());
            stmt.setInt(2,0);
            stmt.setInt(3, q.getNumero());
            stmt.setString(4, q.getAndar()+"º");
            stmt.setInt(5, q.getRamal());
            
            stmt.executeUpdate();
            System.out.println("Dados Salvos com sucesso!!!");

        } catch (SQLException ex) {
            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao.conn != null) {
                try {
                    conexao.conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return 1;
    }

    public List<Quarto> BuscarQuartos(int pesquisa,int tipoBusca) {
        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        List<Quarto> lista = new ArrayList<Quarto>();

        String Query = "SELECT ID_QUARTO, NUMERO, ANDAR, RAMAL, VALOR_DIARIA,OCUPADO FROM TB_QUARTO  ";
        
        switch (tipoBusca) {
            case 1:
                Query += "WHERE OCUPADO = ?";
                break;
            case 2:
                Query += "WHERE ID_QUARTO = ?";
                break;
        }

        try {
            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);
            
            if(tipoBusca == 1 || tipoBusca ==2)
            stmt.setInt(1, pesquisa);
            
            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Quarto q = new Quarto();
                
                q.setId(resultados.getInt("ID_QUARTO"));
                q.setNumero(resultados.getInt("NUMERO"));
                q.setAndar(resultados.getString("ANDAR"));
                q.setRamal(resultados.getInt("RAMAL"));                
                q.setOcupado(resultados.getInt("OCUPADO"));
                q.setValorDiaria(resultados.getDouble("VALOR_DIARIA"));

                lista.add(q);
            }

            return lista;
        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {
                conexao.closeConection();
            }
        }
        return null;
    }

}
