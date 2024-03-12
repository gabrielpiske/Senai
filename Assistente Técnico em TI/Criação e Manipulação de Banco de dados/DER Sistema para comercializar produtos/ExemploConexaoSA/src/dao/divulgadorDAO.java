/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import jdbc.ConnectionFactory;
import modelo.Divulgador;

/**
 *
 * @author gabriel_piske
 */
public class DivulgadorDAO {
    private Connection connection;
    
    public DivulgadorDAO(){
        connection = new ConnectionFactory().getConnection();
    }
    
    public void adicionaDivulgador(Divulgador divulgador){
        String SQL = "insert into divulgador (nome, telefone, email, dataNascimento, "
                + "usuario, senha, nivel)" + "values (?,?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(SQL);
            stmt.setString(1, divulgador.getNome());
            stmt.setString(2, divulgador.getTelefone());
            stmt.setString(3, divulgador.getEmail());
            stmt.setDate(4, Date.valueOf(divulgador.getDataNascimento()));
            stmt.setString(5, divulgador.getUsuario());
            stmt.setString(6, divulgador.getSenha());
            stmt.setInt(7, divulgador.getNivel());
            stmt.execute();
            stmt.close();

            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
              
    }
     public ArrayList<Divulgador> getDivulgadores(){
            try{
                String SQL = "select * from divulgador";
                PreparedStatement stmt = connection.prepareStatement(SQL);
                ResultSet rs = stmt.executeQuery();
                ArrayList<Divulgador> divulgadores = new ArrayList<>();
                
                while(rs.next()){
                    Divulgador divulgador = new Divulgador();
                    divulgador.setIddivulgador(rs.getInt("idDivulgador"));
                    divulgador.setNome(rs.getString("nome"));
                    divulgador.setTelefone(rs.getString("telefone"));
                    divulgador.setEmail(rs.getString("email"));
                    divulgador.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                    divulgador.setUsuario(rs.getString("usuario"));
                    divulgador.setSenha(rs.getString("senha"));
                    divulgador.setNivel(rs.getInt("nivel"));
                    divulgadores.add(divulgador);
                    
                }
                rs.close();
                stmt.close();
                return divulgadores;
                
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }
}
