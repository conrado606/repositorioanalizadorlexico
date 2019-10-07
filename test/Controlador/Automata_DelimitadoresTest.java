/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracteres;
import Modelo.Lexema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class Automata_DelimitadoresTest {
    @Test
    public void AutomataDelimitadoresTest() {
        Automata_Delimitadores cons = new Automata_Delimitadores();
        char[] caracteres = ";".toCharArray();
        Lexema resultado = cons.inicio(new Caracteres(0, caracteres));
        int esperado = 1;
        int resultadoMetodo;
        if (resultado != null) {
            resultadoMetodo = 1;
        } else {
            resultadoMetodo = 0;
        }

        assertEquals(esperado, resultadoMetodo);

    }
    
    
    
    
       @Test
    public void TestAutomataDelimitadoresInCorrecto() {
        Automata_Delimitadores cons = new Automata_Delimitadores();
        char[] caracteres = "delimi".toCharArray();
        Lexema resultado = cons.inicio(new Caracteres(0, caracteres));
        int esperado = 0;
        int resultadoMetodo;
        if (resultado != null) {
            resultadoMetodo = 1;
        } else {
            resultadoMetodo = 0;
        }

        assertEquals(esperado, resultadoMetodo);

    }
    
}
