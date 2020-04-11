package Clases;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class Animacion {
    
    private double duracion;
    private Rectangle coordenadas[];

    public Animacion(double duracion, Rectangle coordenadas[]) {
        this.duracion = duracion;
        this.coordenadas = coordenadas;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setCoordenadas(Rectangle[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Rectangle[] getCoordenadas() {
        return coordenadas;
    }

   
    
    public Rectangle calcularFrameActual(double t) {
		int cantidadFrames = this.coordenadas.length;
		int indiceFrameActual = (int)(t%(cantidadFrames*duracion)/duracion);
		return coordenadas[indiceFrameActual];
	}

    
    
    
}
