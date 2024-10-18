package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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

    public Usuario login(String nome, String senha) {
        Usuario usuario = null;
        String sql = "SELECT * FROM login WHERE nom_login = ? AND pas_login = ?";

        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, nome);
            stm.setString(2, senha);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setUsu(rs.getString("nom_login"));
                    usuario.setPass(rs.getString("pas_login"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;

    }

    public void cadUsuario(Usuario usuario) {
        String sql = "INSERT INTO login(user_login, nom_login, pas_login) values (?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(2, usuario.getNome());
            ps.setString(1, usuario.getUsu());
            ps.setString(3, usuario.getPass());

            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado!");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Erro: " + e);
        }
    }

    public void dltUsuario(int idLogin) throws SQLException {
        String sql = "DELETE FROM login WHERE cod_login = ?";
        try (Connection connection = new ConexaoBanco().getConneection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idLogin);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            JOptionPane.showConfirmDialog(null, "Erro: " + e);
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        String sql = "SELECT * FROM login";
        ArrayList<Usuario> users = null;
        try (Connection connection = new ConexaoBanco().getConneection(); 
                PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (users == null) {
                        users = new ArrayList<>();
                    }
                    Usuario usuario = new Usuario();
                    usuario.setCod(rs.getInt("cod_login"));
                    usuario.setNome(rs.getString("nom_login"));
                    usuario.setPass(rs.getString("pas_login"));
                    usuario.setUsu(rs.getString("user_login"));
                    users.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void altUsuario(int codigo, String password) {
        String sql = "UPDATE login SET pas_login = ? WHERE cod_login = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, password);
            ps.setInt(2, codigo);
            ps.execute();
            ps.close();
        } catch (Exception e) {
        }
    }
}
