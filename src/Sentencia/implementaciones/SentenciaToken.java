/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sentencia.implementaciones;

import Modelo.Lexema;
import definicion.Sentencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio
 */
public class SentenciaToken extends Sentencia {

    private Lexema simbolo;

    public SentenciaToken() {
    }

    public SentenciaToken(Lexema simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public List<Sentencia> llenarHijos() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {

        return simbolo.getTipoLexema() + ":" + simbolo.getToken();

    }

    public Lexema getSimbolo() {
        return simbolo;
    }

    @Override
    public String parse() {
        // TODO Auto-generated method stub
        return null;
    }

}
