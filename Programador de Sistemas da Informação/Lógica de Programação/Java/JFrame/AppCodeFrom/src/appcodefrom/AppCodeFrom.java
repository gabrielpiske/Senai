package appcodefrom;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * @author gabriel_piske
 */
public class AppCodeFrom extends JFrame {

    public AppCodeFrom() {
        setTitle("Aplicativo Exemplo de Formulario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        JLabel lblEmpresa = new JLabel("Empresa Tal ");
        lblEmpresa.setBounds(30, 20, 90, 20);
        JButton btnPedido = new JButton("Gerar Pedido");
        btnPedido.setBounds(200, 20, 140, 20);

        JLabel lblServicos = new JLabel("Formulario de Serviços");
        lblServicos.setBounds(30, 70, 150, 20);
        JButton btnPedidoClean = new JButton("Limpar Pedido");
        btnPedidoClean.setBounds(200, 70, 140, 20);

        JLabel lblOrdem = new JLabel("Ordem de Serviços:  1");
        lblOrdem.setBounds(30, 120, 150, 20);

        String[] opcoes = { "Opção 1", "Opção 2", "Opção 3" };
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        comboBox.setBounds(200, 120, 140, 20);
        
        JLabel lblQuantidade = new JLabel("Quantidade");
        lblQuantidade.setBounds(30, 180, 150, 20);
        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(30,200,60,20);
        
        JLabel lblServico = new JLabel("Serviço");
        lblServico.setBounds(130, 180, 150, 20);
        JTextField txtServico = new JTextField();
        txtServico.setBounds(125,200,60,20);
        
        JLabel lblDescricao = new JLabel("Descrição");
        lblDescricao.setBounds(215, 180, 150, 20);
        JTextField txtDescricao = new JTextField();
        txtDescricao.setBounds(215,200,60,20);
        
        JLabel lblValor = new JLabel("Valor");
        lblValor.setBounds(315, 180, 150, 20);
        JTextField txtValor = new JTextField();
        txtValor.setBounds(300,200,60,20);

        add(lblEmpresa);
        add(btnPedido);
        add(lblServicos);
        add(btnPedidoClean);
        add(lblOrdem);
        add(comboBox);
        add(lblQuantidade);
        add(txtQuantidade);
        add(lblServico);
        add(txtServico);
        add(txtDescricao);
        add(lblDescricao);
        add(txtValor);
        add(lblValor);
    }

    public static void main(String[] args) {
        AppCodeFrom form = new AppCodeFrom();
        form.setVisible(true);
    }
}
