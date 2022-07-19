package Modelo.Ajedrez;

public class Posicion {
    char x;
    int y;

    public Posicion(char x, int y){
        this.x = x;
        this.y = y;
    }
    public Posicion(){}

    public char getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setX(int x){
        this.x = (char) ('A' + x);
    }

    public void setY(int y){
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "" + y;
    }
}
