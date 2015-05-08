/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lebrehotel.dibreinn.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luciano
 */
public class ConectarBD {
    
  public Statement stm;
  public ResultSet rs;
  private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//Esse é o nome do driver, que na internet você vai encontrar de varias maneiras, mas só esse resolveu meus problemas  
  private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=DB_DIBREINN";//se não for acessar localmente mude localhost pelo nome do servidor  
  private String usuario = "sa";//esse usuário é um sysadmin ele tem todos os poderes, é bom que se crie um login e usuário a parte  
  private String senha = "admin@123";
  public Connection conn;

  public void openConection() {
    try {
      Class.forName(driver);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ConectarBD.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
       conn = DriverManager.getConnection(caminho, usuario, senha);
      // JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
      System.out.println("Conectado ao banco de dados com sucesso!");
    } catch (SQLException ex) {
        // JOptionPane.showMessageDialog(null, "Erro de Conexão! \nErro: " + ex);
      System.out.println("Erro de Conexão com o banco de dados! \nErro: " + ex);
    }
  }

  public void executaSQL(String sql) {
    try {
      stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
      rs = stm.executeQuery(sql);
    } catch (SQLException ex) {
      // JOptionPane.showMessageDialog(null, "Erro de executa SQL! \nErro: " + ex);
      System.out.println("Erro de execução SQL. \nErro: " + ex);
    }
  }

  public void closeConection() {
   try {
      conn.close();
      // JOptionPane.showMessageDialog(null, "Desconectado com sucesso!");
      System.out.println("Desconectado do banco de dados com sucesso.");
    } catch (SQLException ex) {
      // JOptionPane.showMessageDialog(null, "Erro ao desconectar!" + ex);
      System.out.println("Erro ao desconectado do banco de dados.\nErro: " + ex);
    }
  }

}
    

