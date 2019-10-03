package gramatica.implementaciones;

import Implementaciones.FlujoTokens;
import gramatica.definiciones.Gramatica;
import definicion.Sentencia;
import Sentencia.implementaciones.Condicion;

public class GramaticaCondicion implements Gramatica {

    @Override
    public Condicion analizar(Sentencia padre, FlujoTokens flujoTokens) {
        // TODO Auto-generated method stub
        return new Condicion();
    }

}
