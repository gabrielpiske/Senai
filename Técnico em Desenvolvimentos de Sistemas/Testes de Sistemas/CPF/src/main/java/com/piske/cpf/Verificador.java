package com.piske.cpf;


import javax.swing.JOptionPane;

public class Verificador {

    private String cpf;

    public Verificador() {
    }

    public Verificador(String cpf) {
        this.cpf = cpf;
    }

    public boolean verificarCpf(String cpf) {
        if (!validarFormatoCpf(cpf)) {
            return false;
        }
        return validarDigitosVerificadores(cpf);
    }

    public boolean validarFormatoCpf(String cpf) {
        if (possuiLetras(cpf)) {
            exibirMensagemErro("Não pode conter letras!");
            return false;
        }
        if (cpf.length() != 11) {
            exibirMensagemErro("CPF deve conter exatamente 11 dígitos");
            return false;
        }
        if (cpf.matches("(\\d)\\1{10}")) {
            exibirMensagemErro("CPF não pode ter todos os dígitos iguais");
            return false;
        }
        return true;
    }

    public boolean validarDigitosVerificadores(String cpf) {
        int primeiroDigito = calcularDigitoVerificador(cpf, 9, 10);
        int segundoDigito = calcularDigitoVerificador(cpf, 10, 11);

        if (primeiroDigito == Character.getNumericValue(cpf.charAt(9))
                && segundoDigito == Character.getNumericValue(cpf.charAt(10))) {
            return true;
        } else {
            exibirMensagemErro("CPF inválido");
            return false;
        }
    }

    public int calcularDigitoVerificador(String cpf, int limite, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < limite; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * (pesoInicial - i);
        }
        int digito = (soma * 10) % 11;
        return (digito == 10) ? 0 : digito;
    }

    public boolean possuiLetras(String cpf) {
        return cpf.matches(".*[A-Za-z].*");
    }

    public void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro de Input", JOptionPane.ERROR_MESSAGE);
    }
}
