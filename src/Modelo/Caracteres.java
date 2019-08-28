/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Mauricio
 */
public class Caracteres {

    int posActual;
    char[] caracteres;

    public Caracteres(int posActual, char[] caracteres) {
        this.posActual = posActual;
        this.caracteres = caracteres;
    }

    public int getPosActual() {
        return posActual;
    }

    public void setPosActual(int posActual) {
        this.posActual = posActual;
    }

    public char[] getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(char[] caracteres) {
        this.caracteres = caracteres;
    }

}
