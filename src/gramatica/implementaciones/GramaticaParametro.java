/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import gramatica.definiciones.Gramatica;
import Modelo.Lexema;
import sintatico.excepciones.SintacticException;
import definicion.Sentencia;
import Sentencia.implementaciones.Parametro;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 * Gramatica para identificar a un parametro de un metodo. la regla sintactica
 * es: parametro::=<tipodato> <identificador>
 * tipodato::=<identificador>|<tipoprimitivo>
 *
 * @author Mauricio
 */
public class GramaticaParametro implements Gramatica {

    @Override
    public Parametro analizar(Sentencia raiz, FlujoTokens flujoTokens) {

        Lexema tipo, nombre;
        Lexema lexema = flujoTokens.getTokenActual();

        //si empieza con identificador o tipo de dato
        if (lexema.getTipoLexema().equals("Palabra reservada")) {
            tipo = lexema;
            lexema = flujoTokens.avanzar();
            //luego se espera indentificador.
            if (lexema.getTipoLexema().equals("Identificador")) {
                nombre = lexema;
            } else {//si no se recibe <identificador> hay un error de sintaxis.
                throw new SintacticException(lexema, "Identificador");
            }
            //se retorna la sentencia.
            return new Parametro(nombre, tipo);
        } else {
            return null;
        }
    }

}
