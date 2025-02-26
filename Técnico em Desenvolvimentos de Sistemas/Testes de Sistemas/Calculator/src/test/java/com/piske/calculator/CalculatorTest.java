package com.piske.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gabriel_piske
 */
public class CalculatorTest {
   
    public CalculatorTest(){
        
    }
    
    @Test
    void soma(){
        Calculator c = new Calculator();
        Assertions.assertEquals(5, c.soma(2, 3));
    }
    
    @Test
    void subtracao(){
        Calculator c = new Calculator();
        Assertions.assertEquals(-1, c.subtrair(2, 3));
    }
    
    @Test
    void multiplicacao(){
        Calculator c = new Calculator();
        Assertions.assertEquals(6, c.multiplicacao(2, 3));
    }
    
    @Test
    void divisao(){
        Calculator c = new Calculator();
        Assertions.assertEquals(5, c.divisao(10, 2));
    }
    
    @Test
    void divisaoPorZero(){
        Calculator c = new Calculator();
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            c.divisao(3, 0);
        });
        Assertions.assertEquals("Divisão por zero não existe", exception.getMessage());
    }
    
    @Test
    void potencia(){
        Calculator c = new Calculator();
        Assertions.assertEquals(8, c.potencia(2, 3));
    }
}
