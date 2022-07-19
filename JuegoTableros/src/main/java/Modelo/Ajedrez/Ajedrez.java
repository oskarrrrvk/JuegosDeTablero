package Modelo.Ajedrez;

import Modelo.Ajedrez.Fichas.Ficha;
import Modelo.Ajedrez.Fichas.Rey;
import Modelo.Exceptions.MovimientoProhibidoException;
import Modelo.Tablero;

public class Ajedrez extends Tablero<Ficha> {


    public Ajedrez(){
        super(8);
    }


    @Override
    public void setPosicion(int x, int y, Ficha ficha) throws MovimientoProhibidoException {
        //recordar dar la vuelta cuando se llame al metodo
            if(!ficha.listaMovimientos().containsValue(new Posicion((char) ('A' + x) ,y)))
                throw new MovimientoProhibidoException();
        else{
            setValor(ficha.getPosicion().getY(),ficha.getPosicion().getX(), null);
            ficha.setPosicion(new Posicion((char) ('A' + x), y));
            setValor(x,y,ficha);
        }
    }

    @Override
    public void borra() {

    }

    public boolean gana(JugadorAjedrez jugador){
        return !jugador.buscarFicha(new Rey());
    }

    @Override
    public int ocupacion() {
        int cont = 0;
        for (int i = 0; i < getTamanio(); i++)
            for(int j = 0; j < getTamanio(); j++)
                if(getPosicion(i,j) != null)
                    cont ++;
        return cont;
    }

    public void mostrar(){
        System.out.println("TABLERO\n-------");
        for(int i = 0; i < getTamanio(); i++) {
            for (int j = 0; j < getTamanio(); j++){
                if(getPosicion(i,j) == null)
                    System.out.print('-');
                else
                    System.out.print(getPosicion(i,j));
            }
            System.out.println();
        }
    }
}
