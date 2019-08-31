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
public class Automata_Operador_Aritmetico {
     int cont;
    boolean aceptada;

    char[] car;

    public Lexema inicio(Caracteres flujo) {
        cont = flujo.getPosActual();
        car = flujo.getCaracteres();
        aceptada = false;
        qF();
        if (aceptada) {
            Analizador_Lexico.flujo.setPosActual(cont);
            return new Lexema("Operador", "operador_aritmetico");
        } else {
            return null;
        }
    }

    public void qF() {
        if (cont < car.length) {

            if (car[cont] == '+' || car[cont] == '-' || car[cont] == '/'
                   || car[cont] == '*' || car[cont] == '%' ) {

                aceptada = true;
                cont++;
                qF();
            }  else if (car[cont] == ' ') {
                cont++;
                aceptada = true;
            }
        }
    }
}
