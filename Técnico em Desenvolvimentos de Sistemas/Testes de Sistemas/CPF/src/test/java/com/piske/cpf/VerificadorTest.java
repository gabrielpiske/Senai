package com.piske.cpf;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gabriel_piske
 */
public class VerificadorTest {
    
    private final Verificador verificador = new Verificador();

    @Test
    public void testFormatoCpfValido() {
        assertTrue(verificador.verificarCpf("12345678909"), "CPF válido deveria ser aceito.");
    }

    @Test
    public void testCpfComLetras() {
        assertFalse(verificador.verificarCpf("12345abc890"), "CPF com letras deve ser inválido.");
    }

    @Test
    public void testCpfComTamanhoInvalido() {
        assertFalse(verificador.verificarCpf("12345678"), "CPF com menos de 11 dígitos deve ser inválido.");
        assertFalse(verificador.verificarCpf("123456789012"), "CPF com mais de 11 dígitos deve ser inválido.");
    }

    @Test
    public void testCpfComDigitosIguais() {
        assertFalse(verificador.verificarCpf("11111111111"), "CPF com todos os dígitos iguais deve ser inválido.");
    }

    @Test
    public void testCpfComDigitosVerificadoresValidos() {
        assertTrue(verificador.verificarCpf("52998224725"), "CPF com dígitos verificadores válidos deve ser aceito.");
    }

    @Test
    public void testCpfComDigitosVerificadoresInvalidos() {
        assertFalse(verificador.verificarCpf("52998224724"), "CPF com dígitos verificadores inválidos deve ser rejeitado.");
    }

    @Test
    public void testCalculoDigitoVerificador() {
        assertEquals(2, new Verificador().calcularDigitoVerificador("529982247", 9, 10));
        assertEquals(5, new Verificador().calcularDigitoVerificador("5299822472", 10, 11));
    }
    
}
