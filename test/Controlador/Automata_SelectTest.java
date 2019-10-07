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
public class Automata_SelectTest {
    
   @Test
    public void AutomataSelectTest() {
        Automata_Select cons = new Automata_Select();
        char[] caracteres = "select".toCharArray();
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
    public void TestAutomataSelectInCorrecto() {
        Automata_Select cons = new Automata_Select();
        char[] caracteres = "selecionar".toCharArray();
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
