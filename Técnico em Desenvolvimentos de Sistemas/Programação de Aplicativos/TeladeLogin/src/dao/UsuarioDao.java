package dao;

import java.sql.*;
import java.util.ArrayList;
import view.Usuario;

/**
 *
 * @author gabriel_piske
 */
public class UsuarioDao {

    private Connection con;
    ResultSet rs;
    PreparedStatement pstm;

    public UsuarioDao() {
        this.con = new ConexaoBanco().getConneection();
    }
    
    public Usuario login(String email, String senha){
        return null;
    }
    
    public void cadUsuario(Usuario usuario){
        
    }
    
    public void dltUsuario(int idLogin) throws SQLException{
        
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return null;
    }
    
    public void altUsuario(int codigo, String password){
        
    }
}
