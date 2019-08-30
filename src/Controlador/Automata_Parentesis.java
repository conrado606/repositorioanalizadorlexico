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
public class Automata_Parentesis {
     int contador;
    boolean estado;

    char[] caracter;


    public Lexema inicio(Caracteres flujo) {
        contador = flujo.getPosActual();
        caracter = flujo.getCaracteres();
        estado = false;
        qF();
        if(estado){
            Analizador_Lexico.flujo.setPosActual(contador);
            return new Lexema (" parentesis " , " Delimitadores ");
        }else{
            return null;
        }
    }

   public void qF() {
        if (contador < caracter.length) {

            if (caracter[contador] == '(' | caracter[contador] == ')'
                    && estado == false ) {

                estado=true;
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
