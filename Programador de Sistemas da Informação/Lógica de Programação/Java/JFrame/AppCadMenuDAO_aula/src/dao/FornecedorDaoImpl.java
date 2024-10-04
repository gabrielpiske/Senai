package dao;

import java.sql.*;
import java.util.*;

import model.Fornecedor;

/**
 *
 * @author gabriel_piske
 */
public class FornecedorDaoImpl implements FornecedorDao {

    private Connection connection;

    public FornecedorDaoImpl() {
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
    public void addFornecedor(Fornecedor fornecedor) {
        try {
            String query = "INSERT INTO fornecedor (id, empresa, contato, telefone, email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, fornecedor.getCod());
            statement.setString(2, fornecedor.getEmpresa());
            statement.setString(3, fornecedor.getContato());
            statement.setString(4, fornecedor.getFone());
            statement.setString(5, fornecedor.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Fornecedor getFornecedor(int id) {
        Fornecedor fornecedor = null;
        try {
            String query = "SELECT * FROM fornecedor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                fornecedor = new Fornecedor(
                        resultSet.getInt("id"),
                        resultSet.getString("empresa"),
                        resultSet.getString("contato"),
                        resultSet.getString("telefone"),
                        resultSet.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getAllFornecedores() {
        List<Fornecedor> fornecedor = new ArrayList<>();
        try {
            String query = "SELECT * FROM fornecedor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                fornecedor.add(new Fornecedor(
                        resultSet.getInt("id"),
                        resultSet.getString("empresa"),
                        resultSet.getString("contato"),
                        resultSet.getString("telefone"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornecedor;
    }

    @Override
    public void updateFornecedor(Fornecedor fornecedor) {
        try {
            String query = "UPDATE fornecedor SET empresa = ?, contato = ?, telefone = ?, email = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, fornecedor.getEmpresa());
            statement.setString(2, fornecedor.getContato());
            statement.setString(3, fornecedor.getFone());
            statement.setString(4, fornecedor.getEmail());
            statement.setInt(5, fornecedor.getCod());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFornecedor(int id) {
        try {
            String query = "DELETE FROM fornecedor WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
