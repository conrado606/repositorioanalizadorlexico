/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Modelo.Lexema;
import Sentencia.implementaciones.Select;
import definicion.Sentencia;
import gramatica.definiciones.Gramatica;
import sintatico.excepciones.SintacticException;

/**
 *
 * @author Mauricio
 */
public class GramaticaDelete implements Gramatica {

    @Override
    public Select analizar(Sentencia raiz, Implementaciones.FlujoTokens flujoTokens) {
        //Sentencia a retornar....
        Select metodo = new Select();
        flujoTokens.guardarPosicion();
        //primer token de la gramatica.
        Lexema lexema = flujoTokens.getTokenActual();

        //tipo de retorno.....
        if (lexema.getTipoLexema().equals("palabra reservada")) {
//            metodo.setRetorno(lexema);
            lexema = flujoTokens.avanzar();
            if (lexema == null) {
                throw new SintacticException(new Lexema("", ""), "Palabra");
            }
            //nombre del metodo....
            if (lexema.getTipoLexema().equals("palabra reservada")) {
                metodo.setNombre(lexema);
                lexema = flujoTokens.avanzar();
            } else {
                //si no es identificador, no es metodo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

            //parentesis.......
            if (lexema.getTipoLexema().equals("parentesis abierto")) {
                lexema = flujoTokens.avanzar();

                //lista de parametros......
                //Parametro parametro = grammma.verificar(flujoTokens);
                /////
                if (lexema.getTipoLexema().equals("parentesis cerrado")) {
                    GramaticaFields gc = new GramaticaFields();
                    lexema = flujoTokens.avanzar();
                    //se espera llave abierta.....

                } else {
                    //si no es identificador, no es metodo, se retorna el flujo a 
                    //la posicion inicial
                    flujoTokens.backTrack();
                    return null; //se retorna null para que se pruebe con otra regal..
                }

            } else {
                //si no es identificador o tipo de dato, no es metodo, se retorna el flujo a 
                //la posicion inicial
                flujoTokens.backTrack();
                return null; //se retorna null para que se pruebe con otra regal..
            }

        }
        return null;
    }
}
