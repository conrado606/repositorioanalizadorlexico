/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentencia.implementaciones;

import Implementaciones.FlujoTokens;
import gramatica.definiciones.Gramatica;
import Modelo.Lexema;
import definicion.Sentencia;
import Sentencia.implementaciones.Lista;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un atributo como elemeto gramatical.
 *
 * @author Mauricio
 */
public class GramaticaLista<T extends Sentencia> {

    /**
     * Metodo que analiza el flujo de tokens buscando lista de sentencias
     * separadas por algun token en especial.
     *
     * @param flujo, flujo de tokens...
     * @return la lista de sentencias o null si no esta.
     */
    public Lista<T> analizar(Gramatica gramma, Sentencia raiz, FlujoTokens flujoTokens, String separador) {

        
        List<T> sentencias = new ArrayList<>();
        T parametro = null;
        boolean go = true;
        do {
            Lexema lexema = flujoTokens.avanzar();
            parametro = (T) gramma.analizar(raiz, flujoTokens);
            if (parametro != null) {
                sentencias.add(parametro);
                lexema = flujoTokens.avanzar();

                if (lexema.getTipoLexema() != separador) {
                    break;
                }
            } else {
                go = false;
            }

        } while (go);

        return new Lista<T>(sentencias);
    }

}
