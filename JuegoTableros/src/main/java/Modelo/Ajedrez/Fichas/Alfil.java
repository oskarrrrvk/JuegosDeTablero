package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;

import java.util.HashMap;

public class Alfil extends Ficha {
    public Alfil(Posicion posicion) {
        super('B', posicion, TFicha.ALFIL);
    }

    @Override
    public void mostrarMovimiento(Ajedrez tablero) {
        movimientos = new HashMap<>();
        Posicion posicion = new Posicion();
        int i = 0, index = 1;
        boolean encontrado = false;

        while(posicion.getY() < tablero.getTamanio() && posicion.getX() <= 'H' && !encontrado){
            posicion.setX(getPosicion().getX() + i);
            posicion.setY(getPosicion().getY() + i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i ++;
            movimientos. put(index,posicion);
            index ++;
        }

        i = 0;
        encontrado = false;

        while(posicion.getY() < tablero.getTamanio() && posicion.getX() >= 'A' && !encontrado){
            posicion.setX(getPosicion().getX() - i);
            posicion.setY(getPosicion().getY() + i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i ++;
            movimientos. put(index,posicion);
            index ++;
        }

        i = 0;
        encontrado = false;

        while(posicion.getY() >= 0 && posicion.getX() <= 'H' && !encontrado){
            posicion.setX(getPosicion().getX() + i);
            posicion.setY(getPosicion().getY() - i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i ++;
            movimientos. put(index,posicion);
            index ++;
        }
        i = 0;
        encontrado = false;

        while(posicion.getY() >= 0 && posicion.getX() >= 'A' && !encontrado){
            posicion.setX(getPosicion().getX() - i);
            posicion.setY(getPosicion().getY() - i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i ++;
            movimientos. put(index,posicion);
            index ++;
        }
    }
}
