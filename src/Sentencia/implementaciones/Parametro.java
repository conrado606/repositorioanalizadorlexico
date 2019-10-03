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
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 *
 * @author Mauricio
 */
public class Parametro extends Sentencia {

    /**
     * Nombre del parametro
     */
    private Lexema nombre;
    /**
     * Tipo de dato del parametro.
     */
    private Lexema tipo;

    /**
     * COnstructor
     */
    public Parametro() {
    }

    /**
     * COnstructor.
     *
     * @param nombre
     * @param tipo
     */
    public Parametro(Lexema nombre, Lexema tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();

        hijos.add(new SentenciaToken(tipo));
        hijos.add(new SentenciaToken(nombre));
        return hijos;
    }

    @Override
    public String toString() {

        return "Parametro:" + nombre.getToken();

    }

    @Override
    public String parse() {
        // TODO Auto-generated method stub
        return null;
    }

}
