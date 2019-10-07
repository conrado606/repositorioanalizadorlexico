/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracteres;
import Modelo.Lexema;

/**
 *
 * @author Acer
 */
public class Automata_corchete_cerrado {

    int posInicial;

    int cont;
    boolean aceptada;

    char[] car;

    public Lexema inicio(Caracteres flujo) {
        cont = flujo.getPosActual();
        posInicial = flujo.getPosActual();

        car = flujo.getCaracteres();
        aceptada = false;
        q0F();
        if (aceptada) {
            Analizador_Lexico.flujo.setPosActual(cont);
            return new Lexema( "}", "corchete abierto");

        } else {
            return null;
        }
    }

    public void q0F() {

        if (cont < car.length) {

            if ((car[cont] == '}') && aceptada == false) {

                cont++;
                aceptada = true;
                q0F();
            } else if (car[cont] == ' ') {
                validarEspacios();
            }
        }
    }

    public void validarEspacios() {
        if (car[cont] == ' ') {
            cont++;
            validarEspacios();
        }
    }
}
