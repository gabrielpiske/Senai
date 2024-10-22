/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Carro;

/**
 *
 * @author gabriel_piske
 */
public class CarroDao {

    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    // Construtor que inicia conexão com banco
    public CarroDao() {
        this.con = new ConexaoBanco().getConneection();
    }
    
    // Método para cadastrar um carro no banco de dados
    public void cadCar(Carro carro) {
        String sql = "INSERT INTO carro (desc_carro, pot_carro, cor_carro) VALUES (?, ?, ?)";
        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, carro.getDesc_carro());
            ps.setInt(2, carro.getPot_carro());
            ps.setString(3, carro.getCor_carro());
            ps.executeUpdate();  // O banco vai gerar o ID automaticamente
        } catch (SQLException e) {
            e.printStackTrace();  // Melhorei o tratamento de exceção para exibir o erro no console
        }
    }
    
    // Método para excluir um carro do banco de dados
    public void deleteCar(int idCarro) throws SQLException {
        String sql = "DELETE FROM carro WHERE cod_carro = ?";
        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCarro);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    // Método para obter todos os carros do banco de dados.
    public ArrayList<Carro> getCarros() {
        String sql = "SELECT * FROM carro";
        ArrayList<Carro> cars = new ArrayList<>();
        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (cars == null) {
                        cars = new ArrayList<>();
                    }
                    Carro car = new Carro();
                    car.setCod_carro(rs.getInt("cod_carro"));
                    car.setCor_carro(rs.getString("cor_carro"));
                    car.setDesc_carro(rs.getString("desc_carro"));
                    car.setPot_carro(rs.getInt("pot_carro"));
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar carros no banco", e);
        }
        return cars;
    }

    // Método para atualizar os dados de um carro no banco de dados.
    public void alterarCarro(Carro carro) {
        String sql = "UPDATE carro SET desc_carro = ?, pot_carro = ?, cor_carro = ? WHERE cod_carro = ?";
        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, carro.getDesc_carro());
            ps.setInt(2, carro.getPot_carro());
            ps.setString(3, carro.getCor_carro());
            ps.setInt(4, carro.getCod_carro());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
