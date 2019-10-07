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
public class Select extends Sentencia {

    /**
     * Nombre del metodo
     */
    private Lexema nombre;

    /**
     * Tipo de retorno.
     */
    private List<Lexema> listalexemas;

    /**
     * Lista de parametros.
     */
    private Condicion condicion;

    /**
     * Instrucciones dentro del metodo.
     */
    /**
     * COnstructor
     */
    public Select() {
        listalexemas = new ArrayList<>();
    }

    public Select(Lexema nombre, List<Lexema> listalexemas, Condicion condicion) {
        this.nombre = nombre;
        this.listalexemas = listalexemas;
        this.condicion = condicion;
    }

    public Lexema getNombre() {
        return nombre;
    }

    public void setNombre(Lexema nombre) {
        this.nombre = nombre;
    }

    public List<Lexema> getListalexemas() {
        return listalexemas;
    }

    public void setListalexemas(List<Lexema> listalexemas) {
        this.listalexemas = listalexemas;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public Sentencia getRoot() {
        return root;
    }

    public void setRoot(Sentencia root) {
        this.root = root;
    }

    public List<Sentencia> getHijos() {
        return hijos;
    }

    public void setHijos(List<Sentencia> hijos) {
        this.hijos = hijos;
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();

//        hijos.add(new SentenciaToken(retorno));
        hijos.add(new SentenciaToken(nombre));

//        if (!listaParametros.getSentencias().isEmpty()) {
//            hijos.add(listaParametros);
//        }
//        if (!listaSentencias.getSentencias().isEmpty()) {
//            hijos.add(listaSentencias);
//        }
        return hijos;

    }

    @Override
    public String toString() {
        return "Select:  " + nombre.getToken();
    }

    @Override
    public String parse() {

        return null;
    }

}
