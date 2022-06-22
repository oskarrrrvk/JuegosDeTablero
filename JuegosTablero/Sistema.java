package JuegosTablero;

import JuegosTablero.Exceptions.MovimientoProhibidoException;
import JuegosTablero.Tableros.TresEnRaya;

import java.util.Scanner;

public class Sistema {
    public Sistema(TresEnRaya tablero){

        JugadorTresEnRaya jugador1 = new JugadorTresEnRaya('X');
        JugadorTresEnRaya jugador2 = new JugadorTresEnRaya('O');
        Scanner scanner = new Scanner(System.in);

        tablero.borra();
        tablero.mostrar();

        while(!tablero.gana(jugador1) && !tablero.gana(jugador2) && !tablero.completado()){
            int x;
            int y;
            boolean fallo;
            if(!tablero.gana(jugador2)) {
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
            if(!tablero.gana(jugador1)) {
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
    public static void main(String[] args) {

        TresEnRaya tablero3enRaya = new TresEnRaya();
        char opcion;

        do{
            Sistema sistema = new Sistema(tablero3enRaya);
            System.out.print("Quieres continuar S/n?");
            Scanner scanner = new Scanner(System.in);
            opcion = scanner.next().charAt(0);
        } while(opcion != 'N' && opcion != 'n');

    }
}
