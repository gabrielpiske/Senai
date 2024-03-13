/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gmtci
 */
public class FormLogin extends JFrame {
    public FormLogin(){
        super();
        setLocationRelativeTo(this);
        setSize(400, 300);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        initComponentes();
    }
    private void initComponentes(){
        
        
        jbtnClose = new javax.swing.JButton("Fechar");
        jbtnClose.setBounds(50,50,100,25);
        this.add(jbtnClose);
        
        jbtnClose.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"Fechar");
                setVisible(false);
            }
        });
        
    }
    private javax.swing.JButton jbtnClose;
}
