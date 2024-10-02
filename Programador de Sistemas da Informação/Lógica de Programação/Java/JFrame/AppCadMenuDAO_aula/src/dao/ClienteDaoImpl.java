package dao;

import java.sql.*;
import java.util.*;

import model.Cliente;

/**
 *
 * @author gabriel_piske
 */
public class ClienteDaoImpl implements ClienteDao{
    
    private Connection connection;
    
    public ClienteDaoImpl() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_cad";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCliente(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente (cod, nome, fone, email, endreco) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getCodigo());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getFone());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cliente getCliente(int id) {
        Cliente cli = null;
        try {
            String query = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cli = new Cliente(
                        resultSet.getInt("cod"), 
                        resultSet.getString("nome"),
                        resultSet.getString("fone"),
                        resultSet.getString("email"),
                        resultSet.getString("endereco")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cli;
    }

    @Override
    public List<Cliente> getAllClientes() {
        List<Cliente> cliente = new ArrayList<>();
        try {
            String query = "SELECT * FROM cliente";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                cliente.add(new Cliente(
                        resultSet.getInt("cod"),
                        resultSet.getString("nome"),
                        resultSet.getString("fone"),
                        resultSet.getString("email"),
                        resultSet.getString("endereco")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void updateCliente(Cliente cliente) {
        try {
            String query = "UPDATE cliente SET nome = ?, fone = ?, email = ?, endereco = ? WHERE cod = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cliente.getCodigo());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getFone());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getEndereco());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(int id) {
        try {
            String query = "DELETE FROM cliente WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
