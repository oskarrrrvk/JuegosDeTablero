package Modelo.Ajedrez;

import Modelo.Ajedrez.Fichas.Ficha;
import Modelo.Ajedrez.Fichas.Rey;

import java.util.ArrayList;

public class JugadorAjedrez {
    private ArrayList<Ficha> fichas;

    public JugadorAjedrez(){
        fichas = new ArrayList<>();
    }

    public void agregarFicha(Ficha ficha){fichas.add(ficha);}
    public void eliminarFicha(Ficha ficha){
            fichas.remove(ficha);
    }
    public boolean buscarFicha(Rey rey){return fichas.contains(rey);}
}
