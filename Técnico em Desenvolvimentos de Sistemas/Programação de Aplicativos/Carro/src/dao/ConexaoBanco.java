package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel_piske
 */
public class ConexaoBanco {
    public Connection getConneection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bancocarro", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na conexao com banco: " + e.getMessage());
            return null;
        }
    }
}
