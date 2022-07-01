package JuegosTablero;


import JuegosTablero.Exceptions.MovimientoProhibidoException;

public abstract class Tablero <E> implements ITablero <E>{

    private E [][] tablero;

    public Tablero (int tamanio){
        this(tamanio,tamanio);
    }
    public Tablero(int tamanio1, int tamanio2){
        tablero = (E[][]) new Object [tamanio1][tamanio2];
    }
    public Tablero(){
        tablero = (E[][]) new Object[3][3];
    }

    @Override
    public E[][] getTablero() {
        return tablero;
    }

    @Override
    public void setTablero(E [][] tablero){
        for (int i = 0 ; i < this.tablero.length; i++)
            for (int j = 0; j < this.tablero.length; j++)
                this.tablero[i][j] = tablero[i][j];
    }

    @Override
    public int getTamanio() {
        return tablero.length;
    }

    public int getTamanioT(){
        return tablero.length * tablero[0].length;
    }

    @Override
    public E getPosicion(int x, int y) {
        return tablero[x][y];
    }

    @Override
    public abstract void setPosicion(int x, int y, E valor)throws MovimientoProhibidoException;

    @Override
    public abstract void borra();

    protected void setValor(int x, int y, E valor){
        tablero[x][y] = valor;
    }

    @Override
    public abstract int ocupacion();


    @Override
    public String toString() {
        return  "Tablero:\n" +
                "-------";
    }

}
