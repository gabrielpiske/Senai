package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Senai
 */
public class ConnectionFactory {
     public Connection getConnection() {
        System.out.println("Conectando com o banco de dados");
        //tentando fazer a conexão
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
               
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/divulgacaoSA", //nome do banco de dados
                    "root", //usuario
                    ""); //senha
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
   
}