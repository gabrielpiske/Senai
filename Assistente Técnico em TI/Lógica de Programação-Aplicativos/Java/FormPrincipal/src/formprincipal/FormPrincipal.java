package formprincipal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FormPrincipal {


    public static void main(String[] args) {
        JFrame form = new JFrame(); //criação frame
        form.setSize(400, 300); //definição tamanho
        form.setLocation(50, 50); //localização de nascimento
        form.setTitle("Minha Primeira Janela"); //definição do nome da janela
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //mensagem de encerramento do formulario
        
        //Layouts
        form.setLayout(null);
        //form.setLayout(new FlowLayout());
        //form.setLayout(new GridLayout(2,3));
        //form.setLayout(new BorderLayout());
        
        //INSERINDO COMPONENTES
        
        //Caixa de texto JTextField
        /*JTextField jtfNome = new JTextField();
        jtfNome.setSize(100, 30); //definição de tamanho
        form.add(jtfNome); //inserindo formulario*/
        
        //Botão simples JButton
        JButton btnOk = new JButton(); //criação botão
        btnOk.setSize(80, 30); //tamanho
        btnOk.setLocation(20,10); //localização
        btnOk.setText("Confirmar"); //definição texto
        form.add(btnOk); //inserindo botão
        
        //Botão Salvar JButton
        JButton btnSalvar = new JButton(); //criação botão
        btnSalvar.setSize(80, 30); //tamanho
        btnSalvar.setLocation(20,45); //localização
        btnSalvar.setText("Salvar"); //definição texto
        form.add(btnSalvar); //inserindo botão
        
        //Botão excluir JButton
        JButton btnExcluir = new JButton(); //criação botão
        btnExcluir.setSize(80, 30); //tamanho
        btnExcluir.setLocation(20,80); //localização
        btnExcluir.setText("Excluir"); //definição texto
        form.add(btnExcluir); //inserindo botão
        
        //Botão editar JButton
        JButton btnEditar = new JButton(); //criação botão
        btnEditar.setSize(80, 30); //tamanho
        btnEditar.setLocation(20,115); //localização
        btnEditar.setText("Editar"); //definição texto
        form.add(btnEditar); //inserindo botão
        
        //Botão mover JButton
        JButton btnMover = new JButton(); //criação botão
        btnMover.setSize(80, 30); //tamanho
        btnMover.setLocation(20,150); //localização
        btnMover.setText("Mover"); //definição texto
        form.add(btnMover); //inserindo botão
        
        
        form.setVisible(true); //visualização de tudo
    }
    
}
