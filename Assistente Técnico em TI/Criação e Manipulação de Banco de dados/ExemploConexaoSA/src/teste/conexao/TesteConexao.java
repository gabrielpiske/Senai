/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.conexao;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

/**
 *
 * @author Senai
 */
public class TesteConexao {

    public static void main(String[] args) throws SQLException {
        Connection connection = (Connection) new ConnectionFactory().getConnection();

        System.out.println("Conectado");
        //fechar conexão para economizar memória
        connection.close();
    }

}
