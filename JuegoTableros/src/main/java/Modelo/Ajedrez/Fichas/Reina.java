package Modelo.Ajedrez.Fichas;

import Modelo.Ajedrez.Ajedrez;
import Modelo.Ajedrez.Posicion;

import java.util.HashMap;

public class Reina extends Ficha{
    public Reina(Posicion posicion) {
        super('Q', posicion, TFicha.REINA);
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

        posicion.setX(getPosicion().getX());

        while(posicion.getY() < tablero.getTamanio() && !encontrado){
            posicion.setY(getPosicion().getY() + i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i++;
            movimientos.put(index, posicion);
            index++;
        }

        i = 0;
        encontrado = false;
        posicion.setY(getPosicion().getY());

        while(posicion.getX() <= 'H' && !encontrado){
            posicion.setX(getPosicion().getX() + i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i++;
            movimientos.put(index, posicion);
            index ++;
        }

        i = 0;
        encontrado = false;
        posicion.setX(getPosicion().getX());

        while(posicion.getY() >= 0 && !encontrado){
            posicion.setY(getPosicion().getY() - i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i++;
            movimientos.put(index,posicion);
            index ++;
        }

        i = 0;
        encontrado = false;
        posicion.setY(getPosicion().getY());

        while (posicion.getX() >= 'A' && !encontrado) {
            posicion.setX(getPosicion().getX() - i);
            if(tablero.getPosicion(posicion.getX(),posicion.getY()) != null)
                encontrado = true;
            i++;
            movimientos.put(index,posicion);
            index++;
        }
    }
}
