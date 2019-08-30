/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracteres;
import Modelo.Lexema;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class Analizador_Lexico {

    List<Lexema> listLexema = new ArrayList<>();
    Lexema lexe;
    public static Caracteres flujo;

    public List<Lexema> getListLexema() {
        return listLexema;
    }

    public void setListLexema(List<Lexema> listLexema) {
        this.listLexema = listLexema;
    }

    public void analizar(Caracteres flu) {
        flujo = flu;

        while (flujo.getPosActual() < flujo.getCaracteres().length) {

            Automata_Into();

        }
    }

    public void Automata_Into() {
        Auotomata_Into automata = new Auotomata_Into();
        lexe = automata.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
}
