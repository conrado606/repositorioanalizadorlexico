/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Modelo.Lexema;
import Sentencia.implementaciones.Atributo;
import definicion.Sentencia;
import gramatica.definiciones.Gramatica;

/**
 *
 * @author Mauricio
 */
public class GramaticaFields implements Gramatica {

    @Override
    public Atributo analizar(Sentencia padre, Implementaciones.FlujoTokens flujoTokens) {

        Atributo atributo = new Atributo();
        flujoTokens.guardarPosicion();
        //primer token de la gramatica.
        Lexema lexema = flujoTokens.getTokenActual();

        //tipo de dato.....
        if (lexema.getTipoLexema().equals("Identificador") || lexema.getTipoLexema().equals("Palabra reservada")) {
            atributo.setTipoDato(lexema);
            lexema = flujoTokens.avanzar();

            //nombre del atributo....
            if (lexema.getTipoLexema().equals("parentesis abierto")) {
                atributo.setNombre(lexema);
                lexema = flujoTokens.avanzar();

                if (lexema.getTipoLexema().equals("Identificador")) {
                    atributo.setNombre(lexema);
                    lexema = flujoTokens.avanzar();

                    if (lexema.getTipoLexema().equals("parentesis cerrado")) {
                        atributo.setNombre(lexema);
                        lexema = flujoTokens.avanzar();

                        if (lexema.getTipoLexema().equals("punto coma")) {
                            lexema = flujoTokens.avanzar();

                            if (lexema.getTipoLexema().equals("palabra reservada")) {
                                lexema = flujoTokens.avanzar();

                                if (lexema.getTipoLexema().equals("parentesis abierto")) {
                                    lexema = flujoTokens.avanzar();

                                    if (lexema.getTipoLexema().equals("Identificador")) {
                                        lexema = flujoTokens.avanzar();

                                        if (lexema.getTipoLexema().equals("parentesis cerrado")) {
                                            lexema = flujoTokens.avanzar();

                                            if (lexema.getTipoLexema().equals("Asigancion")) {
                                                lexema = flujoTokens.avanzar();

                                                if (lexema.getTipoLexema().equals("Identificador")) {
                                                    lexema = flujoTokens.avanzar();

                                                    if (lexema.getTipoLexema().equals("punto coma")) {
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

                                        }
                                    }

                                }
                            }
                        }
                    }
                }

            }
        }
        return null;

    }
}
