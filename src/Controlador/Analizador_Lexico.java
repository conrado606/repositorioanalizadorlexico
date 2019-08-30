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
    List<Lexema>listLexema= new ArrayList<>();
    Lexema lexe;
    public static Caracteres flujo;

    public List<Lexema> getListLexema() {
        return listLexema;
    }

    public void setListLexema(List<Lexema> listLexema) {
        this.listLexema = listLexema;
    }
    
    
    public void Analizar(Caracteres flu){
        flujo = flu ;
        
        while(flujo.getPosActual()<flujo.getCaracteres().length){
            
            Automata_Condicional_And();
            
        }
        
    }
    
    public void Automata_Condicional_And (){
        Automata_Condicional_And aca = new Automata_Condicional_And();
        lexe = aca.inicio(flujo);
        if(lexe!=null){
            listLexema.add(lexe);
        }
    }
}
