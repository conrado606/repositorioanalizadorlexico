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
public class Automata_OP_logico {
    int contador;
    boolean estado;

    char[] caracter;

    public Lexema inicio(Caracteres flujo) {
        contador = flujo.getPosActual();
        caracter = flujo.getCaracteres();
        estado = false;
        q0();
        if(estado){
            Analizador_Lexico.flujo.setPosActual(contador);
            return new Lexema ("Operador" , "Operador_logico");
        }else{
            return null;
        }
    }

    public void q0() {

        if (contador < caracter.length) {

            if (caracter[contador] == '<' || caracter[contador] == '>') {

                contador++;

                qF();

            } else {

                estado = false;

            }
        }
    }

    public void qF() {
        if (contador < caracter.length) {

            if (caracter[contador] == '=') {

                estado = true;
                contador++;
                qF();
            } 
            else if(caracter[contador]== ' '){
                contador++;
                estado=true;
            }
        }
    }
}
