/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintatico.main;

//

import Controlador.Analizador_Lexico;
import Modelo.Caracteres;
import Modelo.Caracteres;
import Implementaciones.FlujoTokens;
import Modelo.Lexema;
import Vista.VentanaPrincipal;
//import co.edu.eam.tlf.analizadorlexico.vista.FrmAnalizar;
//import co.edu.eam.tlf.analizadorsintactico.gramatica.implementaciones.GramaticaClase;
import definicion.Sentencia;
import gramatica.implementaciones.GramaticaClase;
import java.util.List;

/**
 *
 * @author alvaro
 */
public class AnalizadorSintactico {

    /**
     * Analizador Lexico
     */
    private final Analizador_Lexico analizadorLexico;

    /**
     * Raiz del arbol de derivacion
     */
    private Sentencia unidadCompilacion;
    private char[] caracteres; 
    VentanaPrincipal FrmAnalizar;

    /**
     * Constrctor
     */
    public AnalizadorSintactico() {
        analizadorLexico = new Analizador_Lexico();
    }

    /**
     * Metodo para analizar el codigo sintacticamente
     *
     * @param codigo
     */
    public void analizar(String codigo) {
        caracteres = codigo.toCharArray();

        Caracteres fc = new Caracteres(0, caracteres);
        analizadorLexico.analizar(fc);
//        List<Lexema> tokens = analizadorLexico.getClass()
//        List<Lexema> errores = analizadorLexico.g

        FrmAnalizar.listar();
////        FrmAnalizar.listarErrores();
//        if (errores.isEmpty()) {
//            FlujoTokens flujo = new FlujoTokens(tokens);
//            GramaticaClase gramm = new GramaticaClase();
//
//            unidadCompilacion = gramm.analizar(null, flujo);
//
//        }
    }

    public Analizador_Lexico getAnalizadorLexico() {
        return analizadorLexico;
    }

    public Sentencia getUnidadCompilacion() {
        return unidadCompilacion;
    }

}
