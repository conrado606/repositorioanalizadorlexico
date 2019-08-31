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
public class Automata_Operador_Comparacion_IN {
    
    int cont;
    boolean aceptada;

    char[] car;

    public Lexema inicio(Caracteres flujo) {
        cont = flujo.getPosActual();
        car = flujo.getCaracteres();
        aceptada = false;
        q0();
           if(aceptada){
            Analizador_Lexico.flujo.setPosActual(cont);
            return new Lexema ("in","Operador comparacion");
        }else{
           return null ; 
        }
    }

      public void q0() {

        if (cont < car.length) {

            if (car[cont] == 'i') {

                cont++;

                qF();

            } else {

                aceptada = false;

            }
        }
    }

    public void qF() {
        if (cont < car.length) {

            if (car[cont] == 'n') {

                aceptada = true;
                cont++;
                qF();
            } else if (Character.isLetter(car[cont]) || Character.isDigit(car[cont])) {
                aceptada = false;
                cont--;
            }
              else if(car[cont]== ' '){
                cont++;
                aceptada=true;
            }
        }
    } 
}
