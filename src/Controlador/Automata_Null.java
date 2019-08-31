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
 * @author Mauricio
 */
public class Automata_Null {
              int cont;
    boolean aceptada;

    char[] car;

    public Lexema inicio(Caracteres flujo) {
         cont = flujo.getPosActual();
        car = flujo.getCaracteres();
        aceptada = false;
        q0();
        if (aceptada) {
            Analizador_Lexico.flujo.setPosActual(cont);

            return new Lexema("null", "Palabra reservada");
        } else {
            return null;
        }
    }

    public void q0() {

        if (cont < car.length) {

            if (car[cont] == 'n') {

                cont++;

                q1();

            } else {

                aceptada = false;

            }
        }
    }

    public void q1() {

        if (cont < car.length) {

            if (car[cont] == 'u') {
                cont++;

                q2();

            } else {

                aceptada = false;

            }
        }
    }
  public void q2() {

        if (cont < car.length) {

            if (car[cont] == 'l') {

                cont++;

                qF();

            } else {

                aceptada = false;

            }
        }

  }

    public void qF() {
        if (cont < car.length) {

            if (car[cont] == 'l') {

                aceptada = true;
                cont++;
                qF();
            } else if (Character.isLetter(car[cont]) || Character.isDigit(car[cont])) {
                aceptada = false;
                cont--;
            }else if (car[cont] == ' ') {
                cont++;
                aceptada = true;
            }
            
        }
    }
}
