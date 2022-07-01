package JuegosTablero.Ajedrez;

public abstract class Ficha {

    private final String nombre;

    public Ficha(String nombre){
        this.nombre = nombre;
    }

    public abstract int setMovimiento ();

    public String getNombre(){return nombre;}
}
