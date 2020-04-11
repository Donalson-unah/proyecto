package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;


public class Tilemap extends ObjetoJuego {
    
       private int xImagen;
       private int yImagen;
       private int tipoTile;

    public Tilemap(int tipoTile,int x, int y,String nombreImagen, int velocidad, int alto, int ancho) {
        super(x, y, nombreImagen, velocidad);
        this.alto = alto;
        this.ancho = ancho;
        
        
        switch (tipoTile){
            case 1:
                this.xImagen=33;
                this.yImagen=33;
             
                break;
            case 2:
                this.xImagen=132;
                this.yImagen=66;
                break;
            case 3:
                break;
            case 4:
                break;
                
            
        }
        
    }

    public void setxImagen(int xImagen) {
        this.xImagen = xImagen;
    }

    public int getxImagen() {
        return xImagen;
    }

    public void setyImagen(int yImagen) {
        this.yImagen = yImagen;
    }

    public int getyImagen() {
        return yImagen;
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        
        graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
       
    }

    @Override
    public void mover() {
  
    }
       
    
    
    
    
    
    
    
}//CIERRE CLASE
