package Implementacion;
import Clases.Fondo;
import Clases.Item;
import Clases.Jugador;
import Clases.JugadorAnimado;
import Clases.Tilemap;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Juego extends Application {
        private GraphicsContext graficos;
        private Group root;
        private Scene escena;
        private Canvas lienzo;
        private int x;
        private Fondo fondo;
      //  private Jugador jugador;
        private JugadorAnimado jugadorAnimado;
        public static boolean arriba;
        public static boolean abajo;
        public static boolean derecha; 
        public static boolean izquierda;
        public static HashMap<String, Image> imagenes;
        //private Tilemap tile;
        private ArrayList<Tilemap> tiles;
        private Item item;

     private int tilemap[][] = {
         {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
         {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
         
         
                                           
     };
            
            
        

    
    public static void main(String[] args){
    launch(args);
    }

    @Override
    public void start(Stage ventana) throws Exception {
    inicializarComponentes();
    gestionarEventos();
     ventana.setScene(escena);
     ventana.setTitle("Juegazo");
     ventana.show();
     cicloJuego();
     
    }
    
    public void cicloJuego(){
        AnimationTimer animationTimer = new AnimationTimer(){
 
            long tiempo = System.nanoTime();
            public void handle(long tiempoActual) {
              double t = (tiempoActual-tiempo)/1000000000.0;
              //  System.out.println(t);
                
                actualizarEstado(t);
                pintar();
                
            }
 
        };
        
        animationTimer.start();
    }
    
    public void actualizarEstado(double t){
          //jugador.mover();
          jugadorAnimado.verificarColisionesItem(item);
          jugadorAnimado.mover();
          fondo.mover();
          jugadorAnimado.calcularFrame(t);
          
       };
    
    public void inicializarComponentes (){
      imagenes = new HashMap<String,Image>();
      cargarImagenes();
      //int x, int y, String nombreImagen, int velocidad, int ancho, int alto, int xImagen, int yImagen)
      //jugador = new Jugador(0, 300, 400, "muñeco", 1);
      jugadorAnimado = new JugadorAnimado(3,300,400,"sprite",2,"estaticoArriba");
      fondo = new Fondo(0,0,"background","background2", 4);
      item = new Item (1,300,200,"corazon",0);
      inicializarTiles();
      //tile = new Tilemap(33,33,"tilemap",0,0,0,32,32);
      root = new Group();
      escena = new Scene(root, 640, 500);
      lienzo = new Canvas(640, 500);
      root.getChildren().add(lienzo);
      graficos = lienzo.getGraphicsContext2D();
       
        
    }
    
  public void inicializarTiles() {
		tiles = new ArrayList<Tilemap>();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if (tilemap[i][j]!=0)
					this.tiles.add(new Tilemap(tilemap[i][j],j*32,i*32,"tilemap",0,32,32));
				
			}
			
		}
		
	}
    
    
    
    public void cargarImagenes(){
        imagenes.put("background", new Image("implementacion/lados.png"));
        imagenes.put("background2", new Image("implementacion/lados2.png"));
    /*    imagenes.put("muñeco", new Image("implementacion/muñeco.png"));
        imagenes.put("muñecoArriba", new Image("implementacion/muñecoArriba.png"));
        imagenes.put("muñecoAbajo", new Image("implementacion/muñecoAbajo.png"));
        imagenes.put("muñecoDerecha", new Image("implementacion/muñecaDerecha.png"));
        imagenes.put("muñecoIzquierda", new Image("implementacion/muñecoIzquierda.png"));*/
        imagenes.put("corazon", new Image("implementacion/heart.png"));
        imagenes.put("tilemap", new Image("implementacion/tilemap.png"));
        imagenes.put("sprite", new Image("implementacion/SpriteSheet.png"));
        
    }
    
    public void pintar () {
      fondo.pintar(graficos);
     // graficos.drawImage(imagenes.get("tilemap"),32,32,32,32,0,0,70,70);
       for (int i=0; i<tiles.size(); i++)
          tiles.get(i).pintar(graficos);
      //jugador.pintar(graficos);
       jugadorAnimado.pintar(graficos);
       item.pintar(graficos);
       graficos.fillText("Vidas : "+jugadorAnimado.getVidas(), 40, 50);
     
     
      
      //tile.pintar(graficos);
    }
    
    public void gestionarEventos(){
    
    escena.setOnKeyPressed(new EventHandler<KeyEvent>(){

       
        public void handle(KeyEvent evento) {
         
         switch(evento.getCode().toString()){
             case "RIGHT":
                 derecha = true;
                 jugadorAnimado.setAnimacionActual("correrDerecha");
                break;
             case "LEFT":
                 izquierda = true;
                 jugadorAnimado.setAnimacionActual("correrIzquierda");
                 break;
             case "DOWN":
                 abajo = true;
                 jugadorAnimado.setAnimacionActual("correrAbajo");
                 break;
             case "UP":
                 arriba = true;
                 jugadorAnimado.setAnimacionActual("correrArriba");
                         break;};
                 
             
         }
        }
    
    
    );
    
    escena.setOnKeyReleased(new EventHandler<KeyEvent>(){

       
        public void handle(KeyEvent evento) {
            switch(evento.getCode().toString()){
             case "RIGHT":
                 derecha = false;
                 jugadorAnimado.setAnimacionActual("estaticoDerecha");
                 break;
             case "LEFT":
                 izquierda = false;
                 jugadorAnimado.setAnimacionActual("estaticoIzquierda");
                 break;
             case "DOWN":
                 abajo = false;
                 jugadorAnimado.setAnimacionActual("estaticoAbajo");
                 break;
             case "UP":
                 arriba = false;
                jugadorAnimado.setAnimacionActual("estaticoArriba");
                 break;
             
         }
            
            
        }
        
    
       
    });
    
   
        
        
    }
        
  

    
}//CIERRE
