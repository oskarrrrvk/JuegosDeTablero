package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;

import java.util.HashMap;

public class Caballo extends Ficha{
    public Caballo(Posicion posicion) {
        super('H', posicion, TFicha.CABALLO);
    }

    @Override
    public void mostrarMovimiento(Ajedrez tablero) {
        movimientos = new HashMap<>();
        Posicion posicion = new Posicion();
        int index = 1;

        posicion.setX(getPosicion().getX() + 2);
        posicion.setY(getPosicion().getY() + 1);

        if(posicion.getX() <= 'H' && posicion.getY() < tablero.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getY() - 1);

        if(posicion.getX() <= 'H' && posicion.getY() >= 0) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() - 2);
        posicion.setY(getPosicion().getY() + 1);

        if(posicion.getY() < tablero.getTamanio() && posicion.getX() >= 'A') {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getY() - 1);

        if(posicion.getY() >= 0 && posicion.getX() >= 'A') {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() + 1);
        posicion.setY(getPosicion().getY() + 2);

        if(posicion.getX() <= 'H' && posicion.getY() < tablero.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getY() - 2);

        if(posicion.getX() <= 'H' && posicion.getY() >= 0) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() - 1);
        posicion.setY(getPosicion().getY() + 2);

        if(posicion.getX() >= 'A' && posicion.getY() < tablero.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getY() - 2);

        if(posicion.getX() >= 'A' && posicion.getY() < tablero.getTamanio())
            movimientos.put(index,posicion);

    }
}
