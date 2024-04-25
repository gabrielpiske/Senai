/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sigmenu_gabrielpiske.Cliente;
import sigmenu_gabrielpiske.Produto;

/**
 *
 * @author gabriel_piske
 */
public class ProdutoDAO {

    Connection conexao = null; // Conexão DB
    PreparedStatement stm = null; //Declarações SQL
    ResultSet rs = null; //Resultados Dados

    ArrayList<Produto> listaProd = new ArrayList<>();

    public int salvarProduto(Produto prod) {
        conexao = ModuloConexao.conector();
        int status;

        try {
            stm = conexao.prepareStatement("insert INTO tbProduto VALUES(null, ?, ?, ?, ?)");
            stm.setString(1, prod.getDesc());
            stm.setString(2, prod.getUni());
            stm.setInt(3, prod.getQuanti());
            stm.setFloat(4, prod.getValor());

            status = stm.executeUpdate();
            return status;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO (salvarProduto): " + e);
            return e.getErrorCode();
        }
    }

    public ArrayList<Produto> listarProduto() {
        conexao = ModuloConexao.conector();
        String sql = "select * from tbProduto";

        try {
            stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                prod.setCod(rs.getInt("codigo"));
                prod.setDesc(rs.getString("descricao"));
                prod.setUni(rs.getString("unidade"));
                prod.setQuanti(rs.getInt("quantidade"));
                prod.setValor(rs.getFloat("valor"));
                listaProd.add(prod);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO (listarProduto): " + e);
        }
        return listaProd;
    }

    public void alterarProduto(Produto prod) {
        conexao = ModuloConexao.conector();

        try {
            stm = conexao.prepareStatement("update tbProduto set descricao =?, unidade = ?, quantidade = ?, valor = ? where codigo = ?");
            stm.setString(1, prod.getDesc());
            stm.setString(2, prod.getUni());
            stm.setInt(3, prod.getQuanti());
            stm.setFloat(4, prod.getValor());
            stm.setInt(5, prod.getCod());
            stm.execute();
            stm.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO (alterarProduto: )" + erro);
        }
    }

    public void excluirProduto(int cod) {
        conexao = ModuloConexao.conector();

        try {
            stm = conexao.prepareStatement("delete from tbproduto where codigo = ?");

            stm.setInt(1, cod);
            stm.execute();
            stm.close();

            JOptionPane.showMessageDialog(null, "Registro excluido com sucesso.");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProdutoDAO (excluirProduto): " + erro);
        }
    }
}
