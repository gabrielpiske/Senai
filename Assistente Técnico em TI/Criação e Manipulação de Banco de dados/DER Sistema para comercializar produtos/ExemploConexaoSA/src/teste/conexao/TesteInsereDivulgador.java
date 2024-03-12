/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.conexao;

import dao.DivulgadorDAO;
import java.time.LocalDate;
import java.time.Month;
import modelo.Divulgador;

/**
 *
 * @author gabriel_piske
 */
public class TesteInsereDivulgador {
    public static void main(String[] args) {
        DivulgadorDAO dao = new DivulgadorDAO();
        Divulgador divulgador = new Divulgador("Hermano", "xx xxxxxxxx", "gabriel.piske07@gmail.com", LocalDate.of(2007, Month.MAY, 9), "Gabriel", "123", 2);
        
        dao.adicionaDivulgador(divulgador);
        System.out.println("Divulgador adicionado com sucesso");
    }
}
