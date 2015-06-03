/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.model.relatorio;

import br.com.lebrehotel.dibreinn.persistencia.ConectarBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiago.mlima
 */
public class RelatorioDAO {

    public List<Relatorio> reservasStatus(String status) {
        ConectarBD conexao = new ConectarBD();
        List<Relatorio> busca = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;

        String query = "SELECT U.NOME AS UNIDADE, COUNT(R.STATUS) AS QTDE "
                + "FROM TB_RESERVA AS R "
                + "JOIN TB_UNIDADE AS U "
                + "ON U.ID_UNIDADE = R.ID_UNIDADE "
                + "WHERE R.STATUS = '?' "
                + "GROUP BY (U.NOME)";

        try {
            conexao.openConection();
            stm = conexao.conn.prepareStatement(query);
            stm.setString(1, status);

            ResultSet resultados = stm.executeQuery();
            while (resultados.next()) {
                Relatorio r = new Relatorio();
                r.setQuantidade(resultados.getInt("QTDE"));
                r.setUnidade(resultados.getString("UNIDADE"));
                busca.add(r);
            }
        } catch (SQLException ex) {
            // Caso haja erro retorna 0 como ID e informa no log
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao listar os dados: ", ex);
        } finally {
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conexao != null) {
                conexao.closeConection();
            }
        }
        return busca;
    }
}
