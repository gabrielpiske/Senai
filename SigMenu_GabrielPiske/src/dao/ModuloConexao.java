/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel_piske
 */
public class ModuloConexao {

    public static Connection conector() {
        Connection conexao = null;

        //Definição do Driver
        String driver = "com.mysql.cj.jdbc.Driver";
        //Informações Banco de Dados
        String url = "jdbc:mysql://localhost:3306/mydb";
        String user = "root";
        String password = "";
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro no módulo de Conexão: " + erro);
            return null;
        }
    }
}
