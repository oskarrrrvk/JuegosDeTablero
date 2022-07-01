package JuegosTablero.Ajedrez;

import JuegosTablero.Exceptions.MovimientoProhibidoException;
import JuegosTablero.Tablero;

public class Ajedrez extends Tablero {
    @Override
    public void setPosicion(int x, int y, Object valor) throws MovimientoProhibidoException {

    }

    @Override
    public void borra() {

    }

    @Override
    public int ocupacion() {
        return 0;
    }
}
