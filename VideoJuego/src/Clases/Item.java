package Clases;

import Implementacion.Juego;
import com.sun.prism.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class Item extends ObjetoJuego {
    private int cantidadPuntos;
    private boolean capturado=false;

    public Item(int cantidadPuntos, int x, int y, String nombreImagen, int velocidad) {
        super(x, y, nombreImagen, velocidad);
        this.cantidadPuntos = cantidadPuntos;
        this.ancho = (int)Juego.imagenes.get("corazon").getWidth();
        this.alto = (int)Juego.imagenes.get("corazon").getHeight();
    }

    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public boolean isCapturado() {
        return capturado;
    }
      
    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }
    
       
    
    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, ancho, alto);    
    }
    
    @Override
    public void pintar(GraphicsContext graficos) {
        if(this.capturado)
         return;
        
        else{
        graficos.drawImage(Juego.imagenes.get("corazon"),this.x,this.y);
      //  graficos.strokeRect(x, y, ancho, alto);
        }
        }

    @Override
    public void mover() {
        
    }
    
    
    
    
    
    
}//CIERRE CLASE
