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
public class Automata_ConnectionTest {
     @Test
    public void AutomataAsTest() {
        Automata_Connection con = new Automata_Connection();
        char[] caracteres = "connection".toCharArray();
        Lexema resultado = con.inicio(new Caracteres(0, caracteres));
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
    public void TestAutomataAsInCorrecto() {
        Automata_Connection con = new Automata_Connection();
        char[] caracteres = "conecxion".toCharArray();
        Lexema resultado = con.inicio(new Caracteres(0, caracteres));
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
