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
public class Automata_Delimitadores {

    int cont;
    boolean aceptada;/*para guardar los caratcteres y los va ir separando*/

    char[] car;

    public Lexema inicio(Caracteres flujo) {
        cont = flujo.getPosActual();
        car = flujo.getCaracteres();
        aceptada = false;
        qF();
        if (aceptada) {
            Analizador_Lexico.flujo.setPosActual(cont);
            return new Lexema("Delimitador", "Delimitadores");
        } else {
            return null;
        }
    }

    public void qF() {
        if (cont < car.length) {/*cuantos espacios tiene mi arreglo*/

            if (car[cont] == ';' || car[cont] == ',' || car[cont] == ' ') {/*el arreglo car en el contador 0 lo vamos a comparar si es = a*/

                aceptada = true;
                cont++;
                qF();
            } else if (Character.isLetter(car[cont]) || Character.isDigit(car[cont])) {
                aceptada = false;
                cont--;
            } else if (car[cont] == ' ') {
                cont++;
                aceptada = true;
            }
        }
    }
}
