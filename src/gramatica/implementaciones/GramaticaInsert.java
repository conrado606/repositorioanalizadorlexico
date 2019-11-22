/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import Modelo.Lexema;
import Sentencia.implementaciones.Insert;
import Sentencia.implementaciones.Lista;
import Sentencia.implementaciones.Parametro;
import definicion.Sentencia;
import gramatica.definiciones.Gramatica;

/**
 *
 * @author Mauricio
 */
public class GramaticaInsert implements Gramatica {

    @Override
    public Sentencia analizar(Sentencia padre, FlujoTokens flujoTokens) {
        Insert insert = new Insert();

        Lexema lexema = flujoTokens.getTokenActual();

        if (lexema.getToken().equals("insert")) {
            lexema = flujoTokens.avanzar();

            if (lexema.getToken().equals("into")) {
                lexema = flujoTokens.avanzar();

                if (lexema.getTipoLexema().equals("Identificador")) {
                    insert.setNombreTable(lexema);
                    lexema = flujoTokens.avanzar();

                    if (lexema.getToken().equals("(")) {
                        lexema = flujoTokens.avanzar();

                        Lista<Parametro> parametros = new Lista<>();
                        GramaticaParametro gramma = new GramaticaParametro();
                        //Parametro parametro = grammma.verificar(flujoTokens);
                        /////
                        GramaticaLista<Parametro> grammaParametros = new GramaticaLista<>();
                        parametros = grammaParametros.analizar(gramma, insert, flujoTokens, "Coma");
                        insert.setListaAtributosTabla(parametros);
                        lexema = flujoTokens.getTokenActual();

                        if (lexema.getToken().equals(")")) {
                            lexema = flujoTokens.avanzar();

                            if (lexema.getToken().equals("values")) {
                                lexema = flujoTokens.avanzar();

                                if (lexema.getToken().equals("(")) {
                                    lexema = flujoTokens.avanzar();

                                    Lista<Parametro> parametros1 = new Lista<>();
                                    GramaticaParametro gramma1 = new GramaticaParametro();
                                    //Parametro parametro = grammma.verificar(flujoTokens);
                                    /////
                                    GramaticaLista<Parametro> grammaParametros1 = new GramaticaLista<>();
                                    parametros1 = grammaParametros1.analizar(gramma1, insert, flujoTokens, "Coma");
                                    insert.setListaValoresTabla(parametros1);
                                    lexema = flujoTokens.getTokenActual();

                                    if (lexema.getToken().equals(")")) {
                                        lexema = flujoTokens.avanzar();

                                        if (lexema.getToken().equals(";")) {
                                            lexema = flujoTokens.avanzar();
                                            return insert;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return insert;
    }

}
