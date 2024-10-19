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

    public CarroDao() {
        this.con = new ConexaoBanco().getConneection();
    }

    public void cadCar(Carro carro) {
        String sql = "INSERT INTO carro (cod_carro, desc_carro, pot_carro, cor_carro) VALUES (?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, carro.getCod_carro());
            ps.setString(2, carro.getDesc_carro());
            ps.setInt(3, carro.getPot_carro());
            ps.setString(4, carro.getCor_carro());

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Carro cadastrado com Sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void deleteCar(int idCarro) throws SQLException{
        String sql = "DELETE FROM carro WHERE cod_carro = ?";
        try (Connection connection = new ConexaoBanco().getConneection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, idCarro);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public ArrayList<Carro> getCarros(){
        String sql = "SELECT * FROM carro";
        ArrayList<Carro> cars = null;
        try (Connection connection = new ConexaoBanco().getConneection();
                PreparedStatement ps = connection.prepareStatement(sql)){
            try (ResultSet rs = ps.executeQuery()){
                while(rs.next()){
                    if(cars == null){
                        cars = new ArrayList<>();
                    }
                    Carro car = new Carro();
                    car.setCod_carro(rs.getInt("co_login"));
                    car.setCor_carro(rs.getString("cor_carro"));
                    car.setDesc_carro(rs.getString("desc_carro"));
                    car.setPot_carro(rs.getInt("pot_carro"));
                    cars.add(car);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return cars;
    }
    
    public void alterarCarro(int codigo){
        
    }
}
