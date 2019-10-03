package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import Modelo.Lexema;
import sintatico.excepciones.SintacticException;
import gramatica.definiciones.Gramatica;
import definicion.Sentencia;
import Sentencia.implementaciones.Condicion;
import Sentencia.implementaciones.IF;

public class GramaticaIF implements Gramatica {

    @Override
    public IF analizar(Sentencia raiz, FlujoTokens flujoTokens) {
        IF si = new IF();
        flujoTokens.guardarPosicion();

        Lexema lexema = flujoTokens.getTokenActual();

        if (lexema.getToken().equals("if")) {
            lexema = flujoTokens.avanzar();
            if (lexema == null) {
                throw new SintacticException(new Lexema("", ""), "(");
            } else if (lexema.getToken().equals("(")) {
                GramaticaCondicion gc = new GramaticaCondicion();
                lexema = flujoTokens.avanzar();
                Condicion condicion = gc.analizar(si, flujoTokens);

                if (condicion != null) {
                    si.setCondicion(condicion);
                    lexema = flujoTokens.avanzar();
                } else if (lexema == null) {
                    throw new SintacticException(new Lexema("", ""), ")");
                }

                if (lexema.getToken().equals(")")) {
                    lexema = flujoTokens.avanzar();
                } else if (lexema == null) {
                    throw new SintacticException(new Lexema("", ""), "{");
                }

                if (lexema.getToken().equals("{")) {
                    lexema = flujoTokens.avanzar();
                } else if (lexema == null) {
                    throw new SintacticException(new Lexema("", ""), "}");
                }
                if (lexema.getToken().equals("}")) {
                    flujoTokens.backTrack();
                }
            }

        } else {
            flujoTokens.backTrack();
            return null;
        }

        return null;

    }
}
