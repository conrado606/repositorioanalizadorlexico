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

  public static List<Lexema> listLexema = new ArrayList<>();

    public static List<Lexema> getListLexema() {
        return listLexema;
    }

    public static void setListLexema(List<Lexema> listLexema) {
        Analizador_Lexico.listLexema = listLexema;
    }

    public static List<Lexema> getListaErrores() {
        return listaErrores;
    }

    public static void setListaErrores(List<Lexema> listaErrores) {
        Analizador_Lexico.listaErrores = listaErrores;
    }
    public static List<Lexema> listaErrores = new ArrayList<>();
    Lexema lexe;
    public static Caracteres flujo = new Caracteres(0, null);
    int posInicial = 0;

    public void analizar(Caracteres flu) {
        flujo = flu;

        while (flujo.getPosActual() < flujo.getCaracteres().length) {
            Automata_Operador_Comparacion();
            Automata_Operador_ComparacionIN();
            Automata_Comparacion_Between();
            Automata_Comparacion_NOT();

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
            //__________________________________________
            Automata_Into();
            Automata_Condition();

            Automata_Diferente();

            Automata_OP_logico();

            Automata_Operador_Logico();

            Automata_Logico_XOR();
        }

    }

    // ---------OPERADORES LOGICOS --------------------
    //-----------PALABRAS RESERVADAS ----------------------
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

    public void Automata_Logico_XOR() {
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

    public void Automata_Exception() {
        Automata_Exception driver = new Automata_Exception();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_False() {
        Automata_False driver = new Automata_False();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_FindIterable() {
        Automata_FindIterable driver = new Automata_FindIterable();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Foreach() {
        Automata_Foreach driver = new Automata_Foreach();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Foreing() {
        Automata_Foreing driver = new Automata_Foreing();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Forname() {
        Automata_Forname driver = new Automata_Forname();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_From() {
        Automata_From driver = new Automata_From();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Ignore() {
        Automata_Ignore driver = new Automata_Ignore();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Index() {
        Automata_Index driver = new Automata_Index();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Inner() {
        Automata_Inner driver = new Automata_Inner();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Insert() {
        Automata_Insert driver = new Automata_Insert();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Iterable() {
        Automata_Iterable driver = new Automata_Iterable();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Key() {
        Automata_Key driver = new Automata_Key();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Left() {
        Automata_Left driver = new Automata_Left();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Lock() {
        Automata_Lock driver = new Automata_Lock();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Null() {
        Automata_Null driver = new Automata_Null();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Password() {
        Automata_Password driver = new Automata_Password();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Primary() {
        Automata_Primary driver = new Automata_Primary();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Procedure() {
        Automata_Procedure driver = new Automata_Procedure();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Public() {
        Automata_Public driver = new Automata_Public();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Read() {
        Automata_Read driver = new Automata_Read();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_References() {
        Automata_References driver = new Automata_References();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Rename() {
        Automata_Rename driver = new Automata_Rename();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Require() {
        Automata_Require driver = new Automata_Require();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Resultset() {
        Automata_Resultset driver = new Automata_Resultset();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Return() {
        Automata_Return driver = new Automata_Return();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Right() {
        Automata_Right driver = new Automata_Right();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Role() {
        Automata_Role driver = new Automata_Role();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Schema() {
        Automata_Schema driver = new Automata_Schema();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Select() {
        Automata_Select driver = new Automata_Select();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Sql() {
        Automata_Sql driver = new Automata_Sql();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_System() {
        Automata_System driver = new Automata_System();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Table() {
        Automata_Table driver = new Automata_Table();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_This() {
        Automata_This driver = new Automata_This();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_True() {
        Automata_True driver = new Automata_True();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Unique() {
        Automata_Unique driver = new Automata_Unique();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Update() {
        Automata_Update driver = new Automata_Update();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Use() {
        Automata_Use driver = new Automata_Use();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_User() {
        Automata_User driver = new Automata_User();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automata_Values() {
        Automata_Values driver = new Automata_Values();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automatas_Grant() {
        Automatas_Grant driver = new Automatas_Grant();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automatas_Group() {
        Automatas_Group driver = new Automatas_Group();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automatas_Join() {
        Automatas_Join driver = new Automatas_Join();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }

    public void Automatas_add() {
        Automatas_add driver = new Automatas_add();
        lexe = driver.inicio(flujo);
        if (lexe != null) {
            listLexema.add(lexe);
        }
    }
}
