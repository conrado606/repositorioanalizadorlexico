/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Caracteres;
import Modelo.Lexema;
import java.sql.DriverManager;
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
            Automata_Operador_Comparacion();
            Automata_Operador_ComparacionIN();
            Automata_Comparacion_Between();
            Automata_Comparacion_NOT();
            Automata_Operador_LIKE();
            //-------------------------------------
            Automata_Operador_Aritmetico();
            //---------------------------------------
            Automata_Condicional_Operador_Logico();
            Automata_Condicional_Operador_Logico1();
            //----------------------------------------
            Automata_Condicional_And();
            Automata_Condicional_Case();
            Automata_Condicional_Else();
            Automata_Condicional_Or();
            Automata_Condicional_Where();
            Automata_Condicional_While();
            Automata_Condicional_if();
            // ----------------------------------
            Automata_Tipo_Dato_Bit();
            Automata_Tipo_Dato_Char();
            Automata_Tipo_Dato_DataText();
            Automata_Tipo_Dato_Decimal();
            Automata_Tipo_Dato_Float();
            Automata_Tipo_Dato_Integer();
            Automata_Tipo_Dato_Text();
            Automata_Tipo_Dato_Varchar();
            //__________________________________________
            Automata_Into();
            Automata_Condition();
        }

    }

    public void Automata_Comparacion_NOT() {
        Automata_Comparacion_NOT not = new Automata_Comparacion_NOT();
        lexe = not.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Condicional_Operador_Logico() {
        Automata_Operador_Logico opl = new Automata_Operador_Logico();
        lexe = opl.inicio(flujo);
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

    public void Automata_Into() {
        Auotomata_Into into = new Auotomata_Into();
        lexe = into.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_DriverManager() {
        Automara_DriverManager driver = new Automara_DriverManager();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Alter() {
        Automata_Alter driver = new Automata_Alter();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Analyze() {
        Automata_Analyze driver = new Automata_Analyze();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_As() {
        Automata_As driver = new Automata_As();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Before() {
        Automata_Before driver = new Automata_Before();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Between() {
        Automata_Between driver = new Automata_Between();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Cascade() {
        Automata_Cascade driver = new Automata_Cascade();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Catch() {
        Automata_Catch driver = new Automata_Catch();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Change() {
        Automata_Change driver = new Automata_Change();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Check() {
        Automata_Check driver = new Automata_Check();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Class() {
        Automata_Class driver = new Automata_Class();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Column() {
        Automata_Column driver = new Automata_Column();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Connect() {
        Automata_Connect driver = new Automata_Connect();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Condition() {
        Automata_Condition driver = new Automata_Condition();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Connection() {
        Automata_Connection driver = new Automata_Connection();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Constraint() {
        Automata_Constraint driver = new Automata_Constraint();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Convert() {
        Automata_Convert driver = new Automata_Convert();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Create() {
        Automata_Create driver = new Automata_Create();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_DataBase() {
        Automata_DataBase driver = new Automata_DataBase();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Default() {
        Automata_Default driver = new Automata_Default();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Delete() {
        Automata_Delete driver = new Automata_Delete();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Describe() {
        Automata_Describe driver = new Automata_Describe();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Distinct() {
        Automata_Distinct driver = new Automata_Distinct();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }

    }

    public void Automata_Drop() {
        Automata_Drop driver = new Automata_Drop();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
}
