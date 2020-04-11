package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Jugador extends ObjetoJuego{
    private int vidas;

    public Jugador(int vidas, int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
        this.vidas = vidas;
    }
 
    
    

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }

    
    
    
    @Override
    public void pintar(GraphicsContext graficos){
        graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
    }
    
    
    @Override
    public void mover(){
        
        if(y==-50)
            y=500;
                
        if (Juego.derecha) 
         x+=velocidad;
        if(Juego.izquierda)
         x-=velocidad;
        if(Juego.arriba)
         y-=velocidad;
        if(Juego.abajo)
         y+=velocidad;
 
    }
    
    
    
}
