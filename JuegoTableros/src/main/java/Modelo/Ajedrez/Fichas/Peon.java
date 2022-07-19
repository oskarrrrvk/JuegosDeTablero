package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;

import java.util.HashMap;

public class Peon extends Ficha {

    public Peon( Posicion posicion) {
        super('P', posicion, TFicha.PEON);
    }

    @Override
    public void mostrarMovimiento(Ajedrez tablero) {
        movimientos = new HashMap<>();
        Posicion posicion = new Posicion();
        int index = 1;

        posicion.setX(getPosicion().getX());
        posicion.setY(getPosicion().getY() + 1);

        if((posicion.getY() + 1) < tablero.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() + 1);
        posicion.setY(getPosicion().getY() + 1);

        if(tablero.getPosicion(posicion.getX(), posicion.getY()) != null && posicion.getX() <= 'H' &&
                posicion.getY() < tablero.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getX() - 1);
        if(tablero.getPosicion(posicion.getX(), posicion.getY()) != null && posicion.getX() >= 'A' &&
                posicion.getY() <= tablero.getTamanio())
            movimientos.put(index,posicion);

    }
}
