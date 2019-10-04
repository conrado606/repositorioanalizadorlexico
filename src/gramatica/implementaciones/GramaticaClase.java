/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import gramatica.definiciones.Gramatica;
import Modelo.Lexema;
import sintatico.excepciones.SintacticException;
import definicion.Sentencia;
import Sentencia.implementaciones.Atributo;
import Sentencia.implementaciones.Clase;
import Sentencia.implementaciones.Metodo;
import gramatica.definiciones.Gramatica;
import java.util.List;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * Gramatica que representa la regla de una clase.
 *
 * @author Mauricio
 */
public class GramaticaClase implements Gramatica {

      @Override
    public Clase analizar(Sentencia raiz, FlujoTokens flujoTokens) {

        Clase clase = new Clase();
        Lexema lexema = flujoTokens.getTokenActual();

        //palabra reservada class....
        if (lexema.getToken().equals("clase")) {
            lexema = flujoTokens.avanzar();
            if (lexema == null) {
                throw new SintacticException(new Lexema("", ""), "Identificador");
            } else if (lexema.getTipoLexema().equals("Identificador")) {
                clase.setNombreClase(lexema);
                lexema = flujoTokens.avanzar();
                if (lexema == null) {
                    throw new SintacticException(new Lexema("", ""), "{");
                } else if (lexema.getTipoLexema().equals("corchete abierto")) {
                    //se analiza el cuerpo del metodo.....
                    boolean continuar = true;
                    GramaticaAtributo gramaticaAtributo = new GramaticaAtributo();
                    GramaticaMetodo gramaticaMetodo = new GramaticaMetodo();
                    do {
                        lexema = flujoTokens.avanzar();
                        Metodo met = gramaticaMetodo.analizar(clase, flujoTokens);
                        if (met != null) {
                            clase.getListaMetodos().add(met);
                            continue;
                        }

                        Atributo atributo = gramaticaAtributo.analizar(clase, flujoTokens);
                        if (atributo != null) {
                            clase.getListaAtributos().add(atributo);
                            continue;
                        }
                        continuar = false;

                    } while (continuar);

                    //se acabo el metodo.....
                    if (lexema.getTipoLexema().equals("corchete cerrado")) {

                        return clase;
                    } else {//si no se termina con llave cerrada, excepcion...
                        throw new SintacticException(lexema, "Llave cerrada");
                    }

                } else {//si no se empieza con llave abierta, error.
                    throw new SintacticException(lexema, "Llave abierta");
                }
            }

        } else {
            flujoTokens.backTrack();
            return null;
        }
        return null;
    }

}
