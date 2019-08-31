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
public class Automara_DriverManager {

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

            return new Lexema("drivermanager", "Palabra reservada");
        } else {
            return null;
        }
    }

    public void q0() {

        if (cont < car.length) {

            if (car[cont] == 'd') {

                cont++;

                q1();

            } else {

                aceptada = false;

            }
        }
    }

    public void q1() {

        if (cont < car.length) {

            if (car[cont] == 'r') {

                cont++;

                q2();

            } else {

                aceptada = false;

            }
        }
    }

    public void q2() {

        if (cont < car.length) {

            if (car[cont] == 'i') {

                cont++;

                q3();

            } else {

                aceptada = false;

            }
        }
    }

    public void q3() {

        if (cont < car.length) {

            if (car[cont] == 'v') {

                cont++;

                q4();

            } else {

                aceptada = false;

            }
        }
    }

    public void q4() {

        if (cont < car.length) {

            if (car[cont] == 'e') {
                cont++;

                q5();

            } else {

                aceptada = false;

            }
        }
    }

    public void q5() {

        if (cont < car.length) {

            if (car[cont] == 'r') {

                cont++;

                q6();

            } else {

                aceptada = false;

            }
        }
    }

    public void q6() {

        if (cont < car.length) {

            if (car[cont] == 'm') {

                cont++;

                q7();

            } else {

                aceptada = false;

            }
        }
    }

    public void q7() {

        if (cont < car.length) {

            if (car[cont] == 'a') {

                cont++;

                q8();

            } else {

                aceptada = false;

            }
        }
    }

    public void q8() {

        if (cont < car.length) {

            if (car[cont] == 'n') {

                cont++;

                q9();

            } else {

                aceptada = false;

            }
        }
    }

    public void q9() {

        if (cont < car.length) {

            if (car[cont] == 'a') {

                cont++;

                q10();

            } else {

                aceptada = false;

            }
        }
    }

    public void q10() {

        if (cont < car.length) {
            if (car[cont] == 'g') {

                cont++;

                q11();

            } else {

                aceptada = false;

            }
        }
    }

    public void q11() {

        if (cont < car.length) {

            if (car[cont] == 'e') {

                cont++;

                qF();

            } else {

                aceptada = false;

            }
        }
    }

    public void qF() {
        if (cont < car.length) {

            if (car[cont] == 'r') {

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
