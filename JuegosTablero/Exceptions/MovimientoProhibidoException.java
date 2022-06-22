package JuegosTablero.Exceptions;

public class MovimientoProhibidoException extends Exception{
    public  MovimientoProhibidoException(){
        super("No se puede hacer esa accion");
    }
}
