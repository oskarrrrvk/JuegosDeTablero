package JuegosTablero.Tableros;

import JuegosTablero.Exceptions.MovimientoProhibidoException;

import java.util.Random;

public class Sudoku extends Tablero <Integer>{

    private int [][] sol;

    public Sudoku(){
        super(9);
        sol = new int[9][9];
    }

    public Sudoku(int tamanio){
        this(tamanio,tamanio);
    }
    public Sudoku(int tamanio1, int tamanio2){
        super(tamanio1,tamanio2);
        sol = new int[tamanio1][tamanio2];
    }

    /**
     *
     * @param x Índice x.
     * @param y Índice y.
     *          Los dos primeros parámetros indican la posicion donde quieres poner el numero
     * @param valor Contenido a colocar en la casilla.
     *           El parametro valor indica el número que quieres introducir en la matriz
     * @throws MovimientoProhibidoException Esta excepcion saltará en el caso de que se intente modificar un numero
     * ya establecido al principio de la partida
     */

    @Override
    public void setPosicion(int x, int y, Integer valor) throws MovimientoProhibidoException {
        if(super.getPosicion(x,y) != -1)
            throw new MovimientoProhibidoException();
        sol[x][y] = valor;
    }

    /**
     * generamos posiciones aleatorias para insertar posteriormente un valor aleatorio en dicha posicion
     * con el proposito de inicializar la matriz de nuestro sudoku
     *
     * Las posiciones vacias se inicializaran a -1
     */
    @Override
    public void borra() {

        Random rand = new Random();
        int i, x, y , valor;

        for (i = 0; i < getTamanio(); i++)
            for (int j = 0; j < getTamanio(); j++)
                setValor(i, j, -1);

        i = 0;
        while(i < 28) {
            x = rand.nextInt(getTamanio() -1);
            y = rand.nextInt(getTamanio() -1);
            valor = rand.nextInt(9);

            if(ganaHorizontal(x,valor) && ganaVertical(y,valor)) {
                setValor(x, y, valor);
                i++;
            }
        }
        for (i = 0; i < getTamanio(); i++)
            for (int j = 0; j < getTamanio(); j++)
                sol[i][j] = getPosicion(i,j);
    }

    /**
     * Contamos las posiciones libres en la matriz para ello
     * @return la diferencia entre el numero de huecos libres con el numero total de huecos
     */
    @Override
    public int ocupacion() {
        int cont = 0;
        for (int i = 0; i < getTamanio(); i++)
            for(int j = 0; j < getTamanio(); j++)
                if(sol[i][j] == -1)
                    cont ++;
        return getTamanioT() - cont;
    }

    /**
     * Indica si al completar el sudoku es correcto o no
     * @return res, un boolean que dice si se ha completado concretamente
     */

    public boolean gana() {
        boolean res = false;
        int i = 0, j = 0;
        while (i < sol.length && !res){
            while (j < sol.length && !res) {
                if (ganaVertical(j, sol[i][j]) && ganaHorizontal(i, sol[i][j]) && ocupacion() == getTamanioT())
                    res = true;
                j++;
            }
            i++;
        }
        return res;
    }

    private boolean ganaVertical(int indexY, int element){
        int cont = 0;
        for (int i = 0; i < sol.length; i++)
            if (sol[i][indexY] == element)
                cont ++;
        return cont <= 1;
    }
    private boolean ganaHorizontal(int indexX, int element){
        int cont = 0;
        for(int i = 0; i < sol.length; i++)
            if(sol[indexX][i] == element)
                cont ++;
        return cont <= 1;
    }

    /**
     * Muestra el avance de la matriz del sudoku
     */
    public void mostrar(){
        System.out.println(super.toString());

        System.out.println("plantilla:");
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++)
                System.out.print(getPosicion(i, j) + "\t");
            System.out.println();
        }
        System.out.println("solucion:");
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++)
                System.out.print(sol[i][j] + "\t");
            System.out.println();
        }

        System.out.println("numero de casillas ocupadas: " + ocupacion());
    }

}
