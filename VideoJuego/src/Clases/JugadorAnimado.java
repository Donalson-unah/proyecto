package Clases;

import Implementacion.Juego;
import com.sun.prism.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
    private int vidas;
    private HashMap<String,Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;
    
    
    
    
    public JugadorAnimado(int vidas, int x, int y, String nombreImagen, int velocidad, String animacionActual) {
        super(x, y, nombreImagen, velocidad);
        this.vidas = vidas;
        this.animacionActual = animacionActual;
        animaciones = new HashMap<String, Animacion>();
        inicializarAnimaciones();
    }
 
    
    

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 45, 40);    
    }
    
    
    @Override
    public void pintar(GraphicsContext graficos){
        graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen, altoImagen, x, y,50,50);
 
        //graficos.strokeRect(x, y, 45, 40);
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
    
    
    public void inicializarAnimaciones(){
        Rectangle coordenadasCorrer[] = {
        new Rectangle(185,327,290,200),
        new Rectangle(565,329,290,200),};      
        Animacion animacionCorrer = new Animacion(0.35,coordenadasCorrer);
        animaciones.put("correrArriba",animacionCorrer);
  
        Rectangle coordenadasDescanso[]={
        new Rectangle(0,320,290,200),};
        Animacion animacionDescanso = new Animacion(0.35,coordenadasDescanso);
        animaciones.put("estaticoArriba",animacionDescanso);
        
        
        
        Rectangle coordenasDerecha[]={
        new Rectangle(0,896,290,200),
        new Rectangle(196,890,290,200),};
        Animacion animacionDerecha = new Animacion(0.35,coordenasDerecha);
        animaciones.put("correrDerecha",animacionDerecha);
        
        Rectangle coordenadasDescansoDerecha[]={
        new Rectangle(196,890,290,200),};
        Animacion animacionDescansoDerecha = new Animacion(0.35,coordenadasDescansoDerecha);
        animaciones.put("estaticoDerecha",animacionDescansoDerecha);
        
        
        
        Rectangle coordenasIzquierda[]={
        new Rectangle(0,600,290,200),
        new Rectangle(196,600,290,200),};
        Animacion animacionIzquierda = new Animacion(0.35,coordenasIzquierda);
        animaciones.put("correrIzquierda",animacionIzquierda);
        
        Rectangle coordenasDescansoIzquierda[]={
        new Rectangle(0,600,290,200),};
        Animacion animacionDescansoIzquierda = new Animacion(0.35,coordenasDescansoIzquierda);
        animaciones.put("estaticoIzquierda",animacionDescansoIzquierda);
        
        
        
        Rectangle coordenasAbajo[]={
        new Rectangle(180,40,290,200),
        new Rectangle(560,40,290,200),};
        Animacion animacionAbajo = new Animacion(0.35,coordenasAbajo);
        animaciones.put("correrAbajo",animacionAbajo);
        
        Rectangle coordenasDescansoAbajo[]={
        new Rectangle(0,40,290,200),};
        Animacion animacionDescansoAbajo = new Animacion(0.35,coordenasDescansoAbajo);
        animaciones.put("estaticoAbajo",animacionDescansoAbajo);
        
        
    }
    
    public void calcularFrame(double t){
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int)coordenadas.getX();
        this.yImagen = (int)coordenadas.getY();
        this.altoImagen = (int)coordenadas.getWidth();
        this.anchoImagen = (int)coordenadas.getHeight();
        
    }
    
    
    public void verificarColisionesItem(Item item){
        if (!item.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())){
            this.vidas += item.getCantidadPuntos();
            item.setCapturado(true);
        }
        
            //System.out.println("si chocan");
           }
    
}//CIERRE CLASE
