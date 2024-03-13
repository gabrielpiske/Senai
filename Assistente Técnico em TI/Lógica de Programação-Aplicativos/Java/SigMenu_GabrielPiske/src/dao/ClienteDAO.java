package dao;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sigmenu_gabrielpiske.*;

/**
 *
 * @author gabriel_piske
 */
public class ClienteDAO {
    Connection conexao = null; // Conexão DB
    PreparedStatement stm = null; //Declarações SQL
    ResultSet rs = null; //Resultados Dados
    
    ArrayList<Cliente> listaCli = new ArrayList<>();
    
    public int salvarCliente(Cliente cli){
        conexao = ModuloConexao.conector();
        int status;
        
        try {
            stm = conexao.prepareStatement("insert INTO tbCliente VALUES(null, ?, ?, ?, ?)");
            stm.setString(1, cli.getNome());
            stm.setString(2, cli.getTele());
            stm.setString(3, cli.getEmail());
            stm.setString(4, cli.getEnde());
            
            status = stm.executeUpdate();
            return status;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO (salvarCliente): "+e);
            return e.getErrorCode();
        }
    }
    
    public ArrayList<Cliente> listarCliente(){
        conexao = ModuloConexao.conector();
        String sql = "select * from tbCliente";
        
        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setMat(rs.getInt("codigo"));
                cli.setNome(rs.getString("nome"));
                cli.setTele(rs.getString("fone"));
                cli.setEmail(rs.getString("email"));
                cli.setEnde(rs.getString("ende"));
                listaCli.add(cli);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ClienteDAO (listarCliente): "+ e);
        }
        return listaCli;
    }
    
    public void alterarCliente(Cliente cli){
        conexao = ModuloConexao.conector();
        
        try{
            stm = conexao.prepareStatement("update tbCliente set nome =?, fone = ?, email = ?, ende = ? where codigo = ?");
            stm.setString(1, cli.getNome());
            stm.setString(2, cli.getTele());
            stm.setString(3, cli.getEmail());
            stm.setString(4, cli.getEnde());
            stm.setInt(5, cli.getCodigo());
            stm.execute();
            stm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO (alterarCliente: )" + erro);
        }
    }
    
    public void excluirCliente(int cod){
        conexao = ModuloConexao.conector();
        
        try{
            stm = conexao.prepareStatement("delete from tbcliente where codigo = ?");
            
            stm.setInt(1, cod);
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ClienteDAO (excluirCliente): " + erro);
        }
    }
}
