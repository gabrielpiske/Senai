/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste.conexao;

import dao.DivulgadorDAO;
import java.util.ArrayList;
import modelo.Divulgador;

/**
 *
 * @author gabriel_piske
 */
public class TesteListaTodos {
    public static void main(String[] args) {
            DivulgadorDAO dao = new DivulgadorDAO();
            ArrayList<Divulgador> divulgadores = dao.getDivulgadores();
            for (Divulgador d : divulgadores){
                System.out.println(d + "\n");
            }
    }
}
