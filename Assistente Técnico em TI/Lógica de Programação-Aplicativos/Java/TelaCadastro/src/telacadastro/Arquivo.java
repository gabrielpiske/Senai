/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package telacadastro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author gabriel_piske
 */
public class Arquivo {
    
    public static String read(String path){
        String conteudo = "";
        try{
            FileReader arquivo = new FileReader(path);
            BufferedReader leitura = new BufferedReader(arquivo);
            
            String linha = "";
            
            try{
                linha = leitura.readLine();
                while (linha != null){
                    conteudo += linha + "\n";
                    linha =leitura.readLine();
                }
                arquivo.close();
                return conteudo;
                
            }catch(IOException ex){
                System.out.println("Erro de Leitura do Arquivo.");
                return "";
            }
            
        }catch(FileNotFoundException ex){
            System.out.println("Erro: Aruivo não Encontrado.");
            return "";
        }
    }
    
    public static boolean write(String path, String txt){
        try{
            FileWriter arquivo = new FileWriter(path);
            PrintWriter gravar = new PrintWriter(arquivo);
            gravar.print(txt);
            arquivo.close();
            
            return true;
        }catch(IOException ex){
            System.out.println("Erro: " + ex.getMessage());
            return false;
            
        }
    }
    
}
