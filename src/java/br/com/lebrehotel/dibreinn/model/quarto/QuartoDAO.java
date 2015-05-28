package br.com.lebrehotel.dibreinn.model.quarto;

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
 * @author Thiago, udimberto.sjunior
 */
public class QuartoDAO {

    public void cadastrarQuarto(Quarto q) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String sql = " INSERT INTO TB_QUARTO (ID_UNIDADE, STATUS, VALOR_DIARIA, NUMERO, ANDAR, RAMAL) "
                + "VALUES (?, ?, ?, ?, ?, ?) \n ";

        try {

            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sql);

            stmt.setDouble(1, q.getIdUnidade());
            stmt.setInt(2, q.getStatus());
            stmt.setDouble(3, q.getValorDiaria());
            stmt.setInt(4, q.getNumero());
            stmt.setString(5, q.getAndar());
            stmt.setInt(6, q.getRamal());

            stmt.executeUpdate();
            System.out.println("[INFO] Dados do Quarto salvos com sucesso!");

        } catch (SQLException ex) {

            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);

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

    }

    public void editarQuarto(Quarto q) {

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String sql = "UPDATE TB_QUARTO SET STATUS = ?, NUMERO = ?, "
                + "ANDAR = ?, RAMAL = ?, VALOR_DIARIA = ? "
                + "WHERE ID_QUARTO = ?";

        try {

            conexao.openConection();
            stmt = conexao.conn.prepareStatement(sql);

            stmt.setInt(1, q.getStatus());
            stmt.setInt(2, q.getNumero());
            stmt.setString(3, q.getAndar());
            stmt.setInt(4, q.getRamal());
            stmt.setDouble(5, q.getValorDiaria());

            stmt.setInt(6, q.getId());

            stmt.executeUpdate();

            System.out.println("[INFO] Quarto " + q.getNumero() + " da unidade #" + q.getIdUnidade() + " atualizado com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    public List<Quarto> listarQuartos(String busca, int tipoBusca) {
        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        List<Quarto> lista = new ArrayList<>();

        String Query = "SELECT ID_QUARTO, ID_UNIDADE, STATUS, NUMERO, ANDAR, RAMAL, VALOR_DIARIA "
                + "FROM TB_QUARTO ";
        
        switch (tipoBusca) {
            case 1:
                Query += "WHERE ID_UNIDADE = ?";
                break;
            case 2:
                Query += "WHERE NUMERO = ?";
                break;
            default:
                break;
        }

        try {
            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);

            ResultSet resultados = stmt.executeQuery();

            while (resultados.next()) {
                Quarto q = new Quarto();

                q.setId(resultados.getInt("ID_QUARTO"));
                q.setIdUnidade(resultados.getInt("ID_UNIDADE"));
                q.setStatus(resultados.getInt("STATUS"));
                q.setNumero(resultados.getInt("NUMERO"));
                q.setAndar(resultados.getString("ANDAR"));
                q.setRamal(resultados.getInt("RAMAL"));
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

    public Quarto buscarQuartoId(String quartoId) {

        ResultSet rs = null;

        ConectarBD conexao = new ConectarBD();
        PreparedStatement stmt = null;

        String Query = "SELECT ID_UNIDADE, STATUS, VALOR_DIARIA, NUMERO, ANDAR, RAMAL \n"
                + "FROM TB_QUARTO WHERE ID_QUARTO = ? \n";

        try {

            conexao.openConection();

            stmt = conexao.conn.prepareStatement(Query);

            stmt.setString(1, quartoId);

            ResultSet resultados = stmt.executeQuery();

            Quarto q = new Quarto();

            while (resultados.next()) {

                q.setId(Integer.parseInt(quartoId));
                q.setIdUnidade(Integer.parseInt(resultados.getString("ID_UNIDADE")));
                q.setStatus(Integer.parseInt(resultados.getString("STATUS")));
                q.setValorDiaria(Double.parseDouble(resultados.getString("VALOR_DIARIA")));
                q.setNumero(Integer.parseInt(resultados.getString("NUMERO")));
                q.setAndar(resultados.getString("ANDAR"));
                q.setRamal(Integer.parseInt(resultados.getString("RAMAL")));

            }

            return q;

        } catch (SQLException ex) {

            Logger.getLogger(QuartoDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao buscar dados: ", ex);

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
