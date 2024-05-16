package atividadesjoptionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author gabriel_piske
 */
public class AtividadesJOptionPane {

    public static void main(String[] args) {
        //dolar();
        //poupanca();
        //concessionaria();
        //salario();
        consumo();
    }

    //Dolar para real por cotação
    public static void dolar() {
        double valor, valorFinal, cotacao;

        valor = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja converter ? $: "));
        cotacao = Double.parseDouble(JOptionPane.showInputDialog("Entre com a Cotação atual do Dolar: "));
        JOptionPane.showMessageDialog(null, "Valor convertido: R$" + (valorFinal = valor / cotacao));
    }

    //Rendimentos mensais
    public static void poupanca() {
        double valor, taxa = 0.009, saida;

        valor = Double.parseDouble(JOptionPane.showInputDialog("Entre com valor que deseja aplicar: "));
        JOptionPane.showMessageDialog(null, "Valor após um mês de rendimento: R$" + (saida = valor + (valor * taxa)));
    }

    public static void concessionaria() {
        double valor, desconto, saida;
        int ano;

        ano = Integer.parseInt(JOptionPane.showInputDialog("Qual o ano do carro? :"));
        valor = Double.parseDouble(JOptionPane.showInputDialog("Qual o valor do Carro? : "));
        
        if (ano <= 2000) {
            desconto = 0.18;
        } else {
            desconto = 0.09;
        }
        
        JOptionPane.showMessageDialog(null, "Valor final do carro é: "+(saida = valor + (valor * desconto)));
    }
    
    //Calculo de Reajuste Salarial
    public static void salario(){
        String nome;
        double salario, saida, salMin = 1100;
        
        nome = JOptionPane.showInputDialog(null, "Entre com o nome do funcionario: ");
        salario = Double.parseDouble(JOptionPane.showInputDialog("Qual o salario ?:"));
        
        if(salario < 3*salMin){
            saida = salario + (salario*0.5);
        } else if(salario >= salMin*3 && salario <= salMin*10){
            saida = salario + (salario*0.2);
        } else if(salario > salMin*10 && salario < salMin*20){
            saida = salario + (salario*0.15);
        } else{
            saida = salario + (salario*0.1);
        }
        
        JOptionPane.showMessageDialog(null, "Salário com reajuste do "+nome+": R$"+saida);
    }
    
    //Consumo por litro
    private static void consumo(){
        double km, litros, saida;
        
        litros = Double.parseDouble(JOptionPane.showInputDialog("Quantos litros foram gastos? : "));
        km = Double.parseDouble(JOptionPane.showInputDialog("Quantos KM foram percorridos? : "));
        
        saida = km / litros;
        
        JOptionPane.showMessageDialog(null, "A média de consumo foi de: "+saida+" km p/ litro");
    }
}
