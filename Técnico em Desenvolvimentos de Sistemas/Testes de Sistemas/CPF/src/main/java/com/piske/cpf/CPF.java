package com.piske.cpf;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel_piske
 */
public class CPF {

    public static void main(String[] args) throws Exception {
        Verificador verificador = new Verificador();
        String cpf = JOptionPane.showInputDialog("Informe o CPF a ser validado (Somente Números): ");
        if (verificador.verificarCpf(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF válidado", "Validação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "CPF invalido", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
