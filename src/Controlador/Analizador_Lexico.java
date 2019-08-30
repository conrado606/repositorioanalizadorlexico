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
 
            //_------------DELIMITADORES--------------------
            Automata_Delimitadores();
            Automata_Parentesis();
            Automata_Llave();
            Automata_Corchete();

            //--------------COMPARACION--------------
            Automata_Operador_Comparacion();
            Automata_Operador_ComparacionIN();
            Automata_Comparacion_Between();
            
            Automata_Operador_LIKE();
            Automata_Comparacion_ISNULL();
            Automata_Comparacion_IS_NOT_NULL();
            Automata_Comparacion_ALL();
            Automata_Comparacion_ANY();

            //-------------OPERADOR ARITMETICO-------------------
            Automata_Operador_Aritmetico();
            //-------------OPERADOR RELACIONAL-------------------

//            Automata_Condicional_Operador_Logico();
//            Automata_Condicional_Operador_Logico1();
            //---------------CONDICIONALES---------------------
            Automata_Condicional_And();
            Automata_Condicional_Case();
            Automata_Condicional_Else();
            Automata_Condicional_Or();
            Automata_Comparacion_NOT();
            Automata_Condicional_Where();
            Automata_Condicional_While();
            Automata_Condicional_if();

            // -------------TIPO DE DATO-------------------
            Automata_Tipo_Dato_Bit();
            Automata_Tipo_Dato_Char();
            Automata_Tipo_Dato_DataText();
            Automata_Tipo_Dato_Decimal();
            Automata_Tipo_Dato_Float();
            Automata_Tipo_Dato_Integer();
            Automata_Tipo_Dato_Text();
            Automata_Tipo_Dato_Varchar();

            // ---------OPERADORES LOGICOS --------------------
            Automata_Diferente();
            Automata_OP_logico();
            Automata_Operador_Logico();
            Automata_Logico_XOR ();
      
         
           
        

            //-----------PALABRAS RESERVADAS ----------------------
        }

    }
    
     public void Automata_Diferente() {
        Automata_Diferente delimitadores = new Automata_Diferente();
        lexe = delimitadores.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
     
      
     
     

    public void Automata_Delimitadores() {
        Automata_Delimitadores delimitadores = new Automata_Delimitadores();
        lexe = delimitadores.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
    
     public void Automata_OP_logico() {
        Automata_OP_logico delimitadores = new Automata_OP_logico();
        lexe = delimitadores.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
    

    public void Automata_Comparacion_NOT() {
        Automata_Comparacion_NOT not = new Automata_Comparacion_NOT();
        lexe = not.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
    
    public void Automata_Logico_XOR () {
        Automata_Logico_XOR xor = new Automata_Logico_XOR();
        lexe = xor.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Comparacion_ISNULL() {
        Automata_Comparacion_ISNULL isnull = new Automata_Comparacion_ISNULL();
        lexe = isnull.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Comparacion_IS_NOT_NULL() {
        Automata_Comparacion_IS_NOT_NULL is_not_null = new Automata_Comparacion_IS_NOT_NULL();
        lexe = is_not_null.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Comparacion_ANY() {
        Automata_Comparacion_ANY any = new Automata_Comparacion_ANY();
        lexe = any.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Comparacion_ALL() {
        Automata_Comparacion_ALL all = new Automata_Comparacion_ALL();
        lexe = all.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

  

    public void Automata_Operador_Comparacion() {
        Automata_Operador_Comparacion comparacion = new Automata_Operador_Comparacion();
        lexe = comparacion.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Parentesis() {
        Automata_Parentesis p = new Automata_Parentesis();
        lexe = p.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Llave() {
        Automata_Llave llave = new Automata_Llave();
        lexe = llave.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Corchete() {
        Automata_Corchete corchete = new Automata_Corchete();
        lexe = corchete.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Operador_ComparacionIN() {
        Automata_Operador_Comparacion_IN in = new Automata_Operador_Comparacion_IN();
        lexe = in.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Operador_Aritmetico() {
        Automata_Operador_Aritmetico aritmetico = new Automata_Operador_Aritmetico();
        lexe = aritmetico.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
    
      public void Automata_Operador_Logico() {
        Automata_Operador_Logico opl = new Automata_Operador_Logico();
        lexe = opl.inicio(flujo);
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

    public void Automata_Operador_LIKE() {
        Automata_Comparacion_LIKE like = new Automata_Comparacion_LIKE();
        lexe = like.inicio(flujo);
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

    public void Automata_Tipo_Dato_Bit() {
        Automata_Tipo_Dato_Bit bit = new Automata_Tipo_Dato_Bit();
        lexe = bit.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Char() {
        Automata_Tipo_Dato_Char cha = new Automata_Tipo_Dato_Char();
        lexe = cha.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_DataText() {
        Automata_Tipo_Dato_Datatext data = new Automata_Tipo_Dato_Datatext();
        lexe = data.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Decimal() {
        Automata_Tipo_Dato_Decimal decimal = new Automata_Tipo_Dato_Decimal();
        lexe = decimal.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Float() {
        Automata_Tipo_Dato_Float flooat = new Automata_Tipo_Dato_Float();
        lexe = flooat.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Integer() {
        Automata_Tipo_Dato_Integer Integer = new Automata_Tipo_Dato_Integer();
        lexe = Integer.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Text() {
        Automata_Tipo_Dato_Text text = new Automata_Tipo_Dato_Text();
        lexe = text.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Tipo_Dato_Varchar() {
        Automata_Tipo_Dato_Varchar var = new Automata_Tipo_Dato_Varchar();
        lexe = var.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Comparacion_Between() {
        Automata_Comparacion_Between between = new Automata_Comparacion_Between();
        lexe = between.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

}
