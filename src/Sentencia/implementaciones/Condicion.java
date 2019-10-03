package Sentencia.implementaciones;

import java.util.ArrayList;
import java.util.List;

import definicion.Sentencia;

public class Condicion extends Sentencia {

    @Override
    public List<Sentencia> llenarHijos() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "condicion";
    }

    @Override
    public String parse() {
        // TODO Auto-generated method stub
        return " condicion ";
    }

}
