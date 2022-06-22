package JuegosTablero.Tableros;

import JuegosTablero.Exceptions.MovimientoProhibidoException;
import JuegosTablero.JugadorTresEnRaya;

public class TresEnRaya extends Tablero <Character>{

    public TresEnRaya(){
        super();
    }
    public TresEnRaya(int tamanio1, int tamanio2){
        super(tamanio1,tamanio2);
    }

    public TresEnRaya(int tamanio){
        super(tamanio);
    }

    @Override
    public void setPosicion(int x, int y, Character valor) throws MovimientoProhibidoException{
        if(getPosicion(x,y) == '-' || getPosicion(x,y) == null)
            setValor(x,y,valor);
        else throw new MovimientoProhibidoException();
    }


    @Override
    public void borra() {
        for(int i = 0; i < getTamanio(); i++)
            for(int j = 0; j < getTamanio(); j++)
               setValor(i,j,'-');
    }

    @Override
    public int ocupacion() {
        int cont = 0;
        for(int i = 0; i < getTamanio(); i++)
            for (int j = 0; j < getTamanio(); j++)
                if(getPosicion(i,j) == '-')
                    cont ++;

        return getTamanio()-cont;
    }

    @Override
    public boolean gana(JugadorTresEnRaya jugador){
        return ganaVertical(jugador.getFicha()) || ganaHorizontal(jugador.getFicha()) ||
                ganaDiagonalPrincipal(jugador.getFicha()) || ganaDiagonalInversa(jugador.getFicha());
    }

    private boolean ganaVertical(char ficha){
        int cont, i = 0;
        boolean vertical = false;
        while(i < getTamanio() && !vertical){
            cont = 0;
            for (int j = 0; j < getTamanio(); j++)
                if(getPosicion(j,i) == ficha)
                    cont ++;
            if(cont == 3)
                vertical = true;
            i++;
        }
        return vertical;
    }
    private boolean ganaHorizontal(char ficha){
        int cont, i = 0;
        boolean vertical = false;
        while(i < getTamanio() && !vertical){
            cont = 0;
            for (int j = 0; j < getTamanio(); j++)
                if(getPosicion(i,j) == ficha)
                    cont ++;
            if(cont == 3)
                vertical = true;
            i++;
        }
        return vertical;
    }
    private boolean ganaDiagonalPrincipal(char ficha){
        int cont = 0, i = 0;
        boolean vertical = false;
        while(i < getTamanio() && !vertical){
            if(getPosicion(i,i) == ficha)
                cont ++;
            if(cont == 3)
                vertical = true;
            i++;
        }
        return vertical;

    }
    private boolean ganaDiagonalInversa(char ficha){
        int cont = 0, i = 0;
        boolean vertical = false;
        while(i < getTamanio() && !vertical){
                if(getPosicion(i, (getTamanio() - 1)- i) == ficha)
                    cont ++;
            if(cont == 3)
                vertical = true;
            i++;
        }
        return vertical;
    }

    public boolean completado(){
        int cont = 0;
        for(int i = 0; i < getTamanio(); i++)
            for(int j = 0; j < getTamanio(); j++)
                if(getPosicion(i,j) == '-')
                    cont ++;
        return cont == 0;
    }
    public void mostrar(){
        System.out.println(super.toString());
        for (int i = 0; i < getTamanio(); i++){
            for (int j = 0; j < getTamanio(); j++)
                System.out.print(getPosicion(i,j) + " ");
            System.out.println();
        }
    }
}
