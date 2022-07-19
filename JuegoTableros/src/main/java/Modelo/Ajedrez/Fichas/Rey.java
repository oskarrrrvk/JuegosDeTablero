package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;

import java.util.HashMap;

public class Rey extends Ficha{

    public Rey(Posicion posicion) {
        super('K', posicion, TFicha.REY);
    }

    public Rey(){
        super(TFicha.REY,'K');
    }

    @Override
    public void mostrarMovimiento(Ajedrez ajedrez) {
        movimientos = new HashMap<>();
        Posicion posicion = new Posicion();
        int index = 1;

        posicion.setX(getPosicion().getX());
        posicion.setY(getPosicion().getY() + 1);

        if(posicion.getY() < ajedrez.getTamanio()) {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setY(getPosicion().getY() - 1);

        if(posicion.getY() >= 0){
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() + 1);
        posicion.setY(getPosicion().getY());

        if(posicion.getX() <= 'H') {
            movimientos.put(index, posicion);
            index ++;
        }

        posicion.setX(getPosicion().getX() - 1);

        if(posicion.getX() >= 'A')
            movimientos.put(index, posicion);

    }
}
