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
import sigmenu_gabrielpiske.Fornecedor;
import sigmenu_gabrielpiske.Produto;

/**
 *
 * @author gabriel_piske
 */
public class FornecedorDAO {

    Connection conexao = null; // Conexão DB
    PreparedStatement stm = null; //Declarações SQL
    ResultSet rs = null; //Resultados Dados

    ArrayList<Fornecedor> listaForn = new ArrayList<>();

    public int salvarFornecedor(Fornecedor forn) {
        conexao = ModuloConexao.conector();
        int status;

        try {
            stm = conexao.prepareStatement("insert INTO tbFornecedor VALUES(null, ?, ?, ?, ?)");
            stm.setString(3, forn.getNome());
            stm.setString(4, forn.getTele());
            stm.setString(2, forn.getEmail());
            stm.setString(1, forn.getContato());

            status = stm.executeUpdate();
            return status;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO (salvarFornecedor): " + e);
            return e.getErrorCode();
        }
    }

    public ArrayList<Fornecedor> listarFornecedor() {
        conexao = ModuloConexao.conector();
        String sql = "select * from tbFornecedor";

        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setCod(rs.getString("codigo"));
                forn.setNome(rs.getString("nome"));
                forn.setTele(rs.getString("tele"));
                forn.setEmail(rs.getString("email"));
                forn.setContato(rs.getString("contato"));
                listaForn.add(forn);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO (listarFornecedor): " + e);
        }
        return listaForn;
    }

    public void alterarFornecedor(Fornecedor forn) {
        conexao = ModuloConexao.conector();

        try {
            stm = conexao.prepareStatement("update tbFornecedor set nome =?, tele = ?, email = ?, contato = ? where codigo = ?");
            stm.setString(1, forn.getNome());
            stm.setString(2, forn.getTele());
            stm.setString(3, forn.getEmail());
            stm.setString(4, forn.getContato());
            stm.setString(5, forn.getCod());
            stm.execute();
            stm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO (alterarFornecedor: )" + erro);
        }
    }

    public void excluirFornecedor(int cod) {
        conexao = ModuloConexao.conector();

        try {
            stm = conexao.prepareStatement("delete from tbfornecedor where codigo = ?");

            stm.setInt(1, cod);
            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FornecedorDAO (excluirFornecedor): " + erro);
        }
    }
}
