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
public class Insert extends Sentencia {

    private Lexema nombreTable;
    private Lista<Parametro> listaAtributosTabla;
    private Lista<Parametro> listaValoresTabla;

    public Insert() {
        listaAtributosTabla = new Lista<>();
        listaValoresTabla = new Lista<>();
    }

    public Lexema getNombreTable() {
        return nombreTable;
    }

    public void setNombreTable(Lexema nombreTable) {
        this.nombreTable = nombreTable;
    }

    public Lista<Parametro> getListaAtributosTabla() {
        return listaAtributosTabla;
    }

    public void setListaAtributosTabla(Lista<Parametro> listaAtributosTabla) {
        this.listaAtributosTabla = listaAtributosTabla;
    }

    public Lista<Parametro> getListaValoresTabla() {
        return listaValoresTabla;
    }

    public void setListaValoresTabla(Lista<Parametro> listaValoresTabla) {
        this.listaValoresTabla = listaValoresTabla;
    }

    @Override
    public List<Sentencia> llenarHijos() {

        hijos = new ArrayList<>();

        if (nombreTable != null) {
            hijos.add(new SentenciaToken(nombreTable));
        }

        if (!listaValoresTabla.getSentencias().isEmpty()) {
            hijos.add(listaValoresTabla);
        }
        if (!listaAtributosTabla.getSentencias().isEmpty()) {
            hijos.add(listaAtributosTabla);
        }

        return hijos;

    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String parse() {

        StringBuilder str = new StringBuilder();

        str.append("insert into");

        if (nombreTable != null) {

            str.append(nombreTable.getToken());
        }
        str.append("(");

        for (int i = 0; i < listaAtributosTabla.getSentencias().size(); i++) {
            str.append(listaAtributosTabla.getSentencias().get(i).parse());
            if (i == listaAtributosTabla.getSentencias().size() - 1) {

            } else {
                str.append(", ");
            }
        }
        str.append(") values (");

        for (int i = 0; i < listaValoresTabla.getSentencias().size(); i++) {
            str.append(listaValoresTabla.getSentencias().get(i).parse());
            if (i == listaValoresTabla.getSentencias().size() - 1) {

            } else {
                str.append(", ");
            }
        }
        str.append("); \n");
        return str.toString();
    }

}
