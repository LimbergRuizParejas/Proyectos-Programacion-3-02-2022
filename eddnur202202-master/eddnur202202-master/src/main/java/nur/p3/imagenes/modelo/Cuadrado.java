package nur.p3.imagenes.modelo;

import nur.p3.imagenes.serviicios.IDibujable;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cuadrado extends Figura {


    protected int tamano;

    public Cuadrado(int m, int n, int t){
        x = m;
        y = n;
        tamano = t;
        observado = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        observado.addPropertyChangeListener(listener);
    }

    @Override
    public void dibujar(Graphics g) {
        g.fillRect(x,y,tamano,tamano);
    }



    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public void moverA(int x, int y) {
        this.x = x;
        this.y = y;
        observado.firePropertyChange("CUADRADO", false, true);
    }

    @Override
    public boolean estaDentroDeLaFigura(int x, int y) {
        return (x > getX() && x < (getX() + getTamano()) &&
                y > getY() && y < (getY() + getTamano()));
    }
}
