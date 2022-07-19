import Modelo.Exceptions.MovimientoProhibidoException;
import Modelo.Sudoku.Sudoku;
import Modelo.TresEnRaya.JugadorTresEnRaya;
import Modelo.TresEnRaya.TresEnRaya;

import java.util.Scanner;

public class Sistema {
    public Sistema(){}
    public void jugarTresEnraya(TresEnRaya tablero){

        JugadorTresEnRaya jugador1 = new JugadorTresEnRaya('X');
        JugadorTresEnRaya jugador2 = new JugadorTresEnRaya('O');
        Scanner scanner = new Scanner(System.in);

        tablero.borra();
        tablero.mostrar();
        while(!tablero.gana(jugador1) && !tablero.gana(jugador2) && tablero.ocupacion() < tablero.getTamanioT()){
            int x;
            int y;
            boolean fallo;
            if(!tablero.gana(jugador2) && tablero.ocupacion() < tablero.getTamanioT()) {
                fallo = false;
                do {
                    System.out.print("x1: ");
                    x = scanner.nextInt();
                    x %= 3;
                    System.out.print("y1: ");
                    y = scanner.nextInt();
                    y %= 3;
                    try {
                        tablero.setPosicion(x, y, jugador1.getFicha());
                    } catch (MovimientoProhibidoException e) {
                        System.out.println(e.getMessage());
                        fallo = true;
                    }
                }while(fallo);
                tablero.mostrar();
            }
            if(!tablero.gana(jugador1) && tablero.ocupacion() < tablero.getTamanioT()) {
                do {
                    fallo = false;
                    System.out.print("x2: ");
                    x = scanner.nextInt();
                    x %= 3;
                    System.out.print("y2: ");
                    y = scanner.nextInt();
                    y %= 3;
                    try {
                        tablero.setPosicion(x, y, jugador2.getFicha());
                    } catch (MovimientoProhibidoException e) {
                        System.out.println(e.getMessage());
                        fallo = true;
                    }
                } while (fallo);
                tablero.mostrar();
            }
        }
    }


   public void jugarSudoku(Sudoku tablero){

        int x;
        int y;
        int valor;
        Scanner scn = new Scanner(System.in);

        tablero.borra();
        tablero.mostrar();

        while(!tablero.gana()){

            System.out.print("X: ");
            x = scn.nextInt();

            System.out.print("Y: ");
            y = scn.nextInt();

            System.out.print("Valor: ");
            valor = scn.nextInt();

            try {
                tablero.setPosicion(x,y,valor);
            } catch (MovimientoProhibidoException e) {
                System.out.println(e.getMessage());
            }
            tablero.mostrar();
        }

    }

    public static void main(String[] args) {
        int index;
        Scanner scn = new Scanner(System.in);
        Sistema sist = new Sistema();

        do{
            System.out.println("\t1.TresEnRaya\n\t2.Sudoku\n\t0.Salir");
            System.out.print("eleccion? ");
            index = scn.nextInt();
            switch (index) {
                case 1: sist.jugarTresEnraya(new TresEnRaya());
                    break;
                case 2: sist.jugarSudoku(new Sudoku());
                    break;
                case 0:
                    break;
            }
        } while(index != 0);

    }
}
