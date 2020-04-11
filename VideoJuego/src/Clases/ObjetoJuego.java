package Clases;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetoJuego {
    protected int x;
    protected int y;
    protected String nombreImagen;
    protected int velocidad;
    protected int ancho;
    protected int alto;

    public ObjetoJuego(int x, int y, String nombreImagen, int velocidad) {
        this.x = x;
        this.y = y;
        this.nombreImagen = nombreImagen;
        this.velocidad = velocidad;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    
    
    
    
    public abstract void pintar(GraphicsContext graficos);
    
    public abstract void mover();
    
    
    
}
