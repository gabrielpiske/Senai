/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author gabriel_piske
 */
public class CarroDao {
    
    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;
    
    public CarroDao(){
        this.con = new ConexaoBanco().getConneection();
    }
    
     
}
