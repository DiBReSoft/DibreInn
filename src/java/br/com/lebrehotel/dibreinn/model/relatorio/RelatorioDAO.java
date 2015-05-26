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
    
    
    
  public List<Relatorio> listarQuantidadeReservas(int unidade,Date de,Date ate) {

    ResultSet rs = null;

    ConectarBD conexao = new ConectarBD();
    PreparedStatement stmt = null;

    List<Relatorio> lista = new ArrayList<>();

    String Query = "SELECT TB_UNIDADE.NOME as nome,COUNT(ID_RESERVA) as quantidade FROM TB_RESERVA "
            + "WHERE TB_UNIDADE.ID_UNIDADE = ? and DT_INICIO BETWEEN "+de+" and "+ate+"  \n"
            
            
            +"INNER JOIN TB_UNIDADE on TB_UNIDADE.ID_UNIDADE TB_RESERVA.ID_UNIDADE \n"            
            + "GROUP BY TB_UNIDADE.NOME";

    try {

      conexao.openConection();

      stmt = conexao.conn.prepareStatement(Query);

      stmt.setInt(1, unidade);
     

      ResultSet resultados = stmt.executeQuery();

      while (resultados.next()) {

	Relatorio re = new Relatorio();

	re.setQuantidade(resultados.getInt("quantidade"));
        re.setUnidade(resultados.getString("nome"));

	lista.add(re);

      }

      return lista;

    } catch (SQLException ex) {
      // Caso haja erro retorna 0 como ID e informa no log
      Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, "[INFO] Erro ao gravar os dados: ", ex);

    } finally {

      if (stmt != null) {
	try {
	  stmt.close();
	} catch (SQLException ex) {
	  Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
	}
      }
      if (conexao != null) {
	conexao.closeConection();
      }

    }

    return null;

  }
    
    
    
}
