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
 * @author Acer
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

    public void Analizar(Caracteres flu) {
        flujo = flu;

        while (flujo.getPosActual() < flujo.getCaracteres().length) {

            Automata_Condicional_Operador_Logico();
            Automata_Condicional_Operador_Logico1();
            
            Automata_Condicional_And();
            Automata_Condicional_Case();
            Automata_Condicional_Else();
            Automata_Condicional_Or();
            Automata_Condicional_Where();
            Automata_Condicional_While();
            Automata_Condicional_if();

        }

    }

     public void Automata_Condicional_Operador_Logico() {
        Automata_Operador_Logico opl = new Automata_Operador_Logico();
        lexe = opl.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
     
     public void Automata_Condicional_Operador_Logico1() {
        Automata_Operador_Logico1 opl1 = new Automata_Operador_Logico1();
        lexe = opl1.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
     
      public void Automata_Condicional_And() {
        Automata_Condicional_And aca = new Automata_Condicional_And();
        lexe = aca.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
    
    
    
    

    public void Automata_Condicional_Case() {
        Automata_Condicional_Case cas = new Automata_Condicional_Case();
        lexe = cas.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_Else() {
        Automata_Condicional_Else els = new Automata_Condicional_Else();
        lexe = els.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_Or() {
        Automata_Condicional_Or or = new Automata_Condicional_Or();
        lexe = or.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_Where() {
        Automata_Condicional_Where where = new Automata_Condicional_Where();
        lexe = where.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_While() {
        Automata_Condicional_While whil = new Automata_Condicional_While();
        lexe = whil.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_if() {
        Automata_Condicional_if iff = new Automata_Condicional_if();
        lexe = iff.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

}
