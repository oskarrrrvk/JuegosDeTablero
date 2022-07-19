package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;
import Modelo.Tablero;

import java.util.HashMap;

public abstract class Ficha{
    private final char nombre;
    private Posicion posicion;
    private final TFicha tFicha;

    protected HashMap<Integer,Posicion> movimientos;

    public Ficha(char nombre, Posicion posicion, TFicha tFicha){
        this.nombre = nombre;
        this.posicion = posicion;
        this.tFicha = tFicha;
    }
    public Ficha(TFicha tFicha, char nombre){
        this.tFicha = tFicha;
        this.nombre = nombre;
    }

    public char getNombre(){return nombre;}
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public abstract void mostrarMovimiento(Ajedrez tablero); //HashMap con posibles movimientos
    public HashMap<Integer,Posicion> listaMovimientos(){return movimientos;}
}
