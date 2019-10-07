/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import gramatica.definiciones.Gramatica;
import Modelo.Lexema;
import Sentencia.implementaciones.Atributo;
import definicion.Sentencia;
import Sentencia.implementaciones.Select;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * Clase que representa a un atributo como elemeto gramatical.
 *
 * @author Mauricio
 */
public class GramaticaAtributo implements Gramatica {

    @Override
    public Atributo analizar(Sentencia padre, FlujoTokens flujoTokens) {

        //Sentencia a retornar....
        Atributo atributo = new Atributo();
        flujoTokens.guardarPosicion();
        //primer token de la gramatica.
        Lexema lexema = flujoTokens.getTokenActual();

        //tipo de dato.....
        if (lexema.getTipoLexema().equals("Identificador") || lexema.getTipoLexema().equals("Tipo Dato")) {
            atributo.setTipoDato(lexema);
            lexema = flujoTokens.avanzar();

            //nombre del atributo....
            if (lexema.getTipoLexema().equals("Identificador")) {
                atributo.setNombre(lexema);
                lexema = flujoTokens.avanzar();

                if (lexema.getTipoLexema().equals("PuntoComa")) {
                    //derivar...
                    return atributo;
                } else {
                    //si no es identificador, no es atributo, se retorna el flujo a 
                    //la posicion inicial
                    flujoTokens.backTrack();
                    return null; //se retorna null para que se pruebe con otra regal..
                }

            } else {
                //si no es identificador, no es atributo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

        }
        return null;

    }
}
