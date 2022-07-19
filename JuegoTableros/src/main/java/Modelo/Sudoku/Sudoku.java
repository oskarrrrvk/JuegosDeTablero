package Modelo.Sudoku;

import Modelo.Exceptions.MovimientoProhibidoException;
import Modelo.Tablero;

import java.util.Random;

public class Sudoku extends Tablero<Integer> {

    private final int[][] sol;

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
        if(sol[x][y] != -1)
            throw new MovimientoProhibidoException();
        setValor(x,y,valor);
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
                sol[i][j] = -1;

        i = 0;
        while(i < 28) {
            x = rand.nextInt(getTamanio() -1);
            y = rand.nextInt(getTamanio() -1);
            valor = rand.nextInt(9);

            int cont = 0;
            for(int j = 0; j < sol.length; j++)
                if(sol[x][j] == valor || sol[j][y] == valor)
                    cont ++;

            if(cont < 1) {
                sol[x][y] = valor;
                i++;
            }
        }

        for (i = 0; i < sol.length; i++)
            for (int j = 0; j < sol.length; j++)
                setValor(i,j,sol[i][j]);
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
                if(getPosicion(i,j) == -1)
                    cont ++;
        return getTamanioT() - cont;
    }

    /**
     * Indica si al completar el sudoku es correcto o no
     * @return res, un boolean que dice si se ha completado concretamente
     */

    public boolean gana() {
        boolean res = true;
        int i = 0, j = 0;
        while (i < getTamanio() && res){
            while (j < getTamanio() && res) {
                if (!ganaVertical(j, getPosicion(i,j)) || !ganaHorizontal(i, getPosicion(i,j)) ||
                        ocupacion() < getTamanioT())
                    res = false;
                j++;
            }
            i++;
        }
        return res;
    }

    private boolean ganaVertical(int indexY, int element){
        int cont = 0;
        for (int i = 0; i < sol.length; i++)
            if (getPosicion(i, indexY) == element)
                cont ++;
        return cont <= 1;
    }
    private boolean ganaHorizontal(int indexX, int element){
        int cont = 0;
        for(int i = 0; i < getTamanio(); i++)
            if(getPosicion(indexX,i) == element)
                cont ++;
        return cont <= 1;
    }

    /**
     * Muestra el avance de la matriz del sudoku
     */
    public void mostrar(){
        System.out.println(super.toString());

        System.out.println("\nplantilla:");
        for (int i = 0; i < sol.length; i++) {
            if(i % 3 == 0 & i > 1){
                for (int k = 0; k < sol.length-3; k++)
                    System.out.print("--\t--\t");
                System.out.println();
            }
            for (int j = 0; j < sol.length; j++) {
                if(j % 3 == 0)
                    System.out.print("|\t");
                if(getPosicion(i,j) == -1)
                    System.out.print(RED+getPosicion(i, j)+RESET + "\t");
                else
                    System.out.print(GREEN+getPosicion(i, j)+RESET + "\t");
            }
            System.out.println();
        }

        System.out.println("\nsolucion:");
        for (int i = 0; i < getTamanio(); i++) {
            if(i % 3 == 0 & i > 1){
                for (int k = 0; k < getTamanio()-3; k++)
                    System.out.print("--\t--\t");
                System.out.println();
            }
            for (int j = 0; j < getTamanio(); j++) {
                if(j % 3 == 0)
                    System.out.print("|\t");
                if(getPosicion(i,j) == -1)
                    System.out.print(RED+getPosicion(i, j)+RESET + "\t");
                else
                    System.out.print(GREEN+getPosicion(i, j)+RESET + "\t");

            }
            System.out.println();
        }
        System.out.println("numero de casillas ocupadas: " + ocupacion());
    }

}
