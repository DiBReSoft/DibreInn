package br.com.lebrehotel.dibreinn.model;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * import javax.swing.JOptionPane;
 *
 * @author thiago
 * data:04/04/2015
 * classe DAO que faz os Dibre loko no banco \o/
 */
public class DAO {

    private Connection conn = null;

    public Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                
                conn = DriverManager.getConnection("jdbc:sqlserver://122.15.510.699\\SQLEXPRESS:1433; "
                        + "databaseName=teste;"
                        + "user=teste;"
                        + "password=11;");

            } catch (SQLException erro) {
                throw new RuntimeException(erro);
            }
        }

        return conn;
    }

    public boolean ExecutaSQL(String Query, List<String> Pessoa) throws SQLException{
        PreparedStatement smt = getConnection().prepareStatement(Query);
        for(int i=1; i < Pessoa.size(); i++ ){
            smt.setString(i, Pessoa.get(i));            
        }        
        if(smt.execute()==true)
            return true;            
        
        desconectar();
        return false;
    }
    
    public ResultSet Consulta(String Query, List<String> Pessoa) throws SQLException{
        PreparedStatement smt = getConnection().prepareStatement(Query);
        for(int i=0; i < Pessoa.size(); i++){
            smt.setString(i,Pessoa.get(i));
        }
        ResultSet rs = smt.executeQuery();
        desconectar();        
        return rs;
    }
    
    //Desconecta com o banco...
    public void desconectar() {
        try {
            conn.close(); // desconecta com o banco... (conexão.close) 
        } catch (SQLException ex) {
            System.out.println(" Erro: " + ex.getMessage()); // apresenta o erro + a mensagem do BD
        }
    }
}
