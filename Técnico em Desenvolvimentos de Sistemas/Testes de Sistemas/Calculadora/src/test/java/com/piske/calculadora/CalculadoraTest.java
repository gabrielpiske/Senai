package com.piske.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gabriel_piske
 */
public class CalculadoraTest {
    
    @Test
    public void testEhPar() {
        // Caminho verdadeiro (número par)
        assertTrue(Calculadora.ehPar(4));
        // Caminho falso (número ímpar)
        assertFalse(Calculadora.ehPar(5));
    }
    
    @Test
    public void testFatorial() {
        // Caminho normal (n > 0)
        assertEquals(120, Calculadora.fatorial(5)); // 5! = 120
        // Caminho com n = 0 (caso especial)
        assertEquals(1, Calculadora.fatorial(0));  // 0! = 1
        // Caminho com exceção (n < 0)
        assertThrows(IllegalArgumentException.class, () -> {
            Calculadora.fatorial(-1);
        });
    }
}
