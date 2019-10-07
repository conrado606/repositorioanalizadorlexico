/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentencia.implementaciones;

import Modelo.Lexema;
import definicion.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class fields extends Sentencia{
     private Lexema nombre;

    /**
     * Tipo de dato.
     */
    private Lexema tipoDato;

    public fields() {
    }

    public fields(Lexema nombre, Lexema tipoDato) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        hijos = new ArrayList<>();

        hijos.add(new SentenciaToken(tipoDato));
        hijos.add(new SentenciaToken(nombre));
        return hijos;
    }

    @Override
    public String toString() {
        return "Atributo:" + tipoDato.getToken() + "-" + nombre.getToken();
    }

    public Lexema getNombre() {
        return nombre;
    }

    public void setNombre(Lexema nombre) {
        this.nombre = nombre;
    }

    public Lexema getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Lexema tipoDato) {
        this.tipoDato = tipoDato;
    }

    @Override
    public String parse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
