package fes.aragon.modelo;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Disparo extends ComponentesJuego{
    private ArrayList<Rectangle> disparos=new ArrayList<>();

    public Disparo(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);

    }

    @Override
    public void pintar(GraphicsContext graficos) {
            for (Rectangle rec:disparos){
                graficos.fillRect(rec.getX(),
                        rec.getY(),
                        rec.getWidth(),rec.getHeight());
            }
    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        //recorrer disparo
        for(Rectangle r:disparos){
            r.setY(r.getY()-1);
        }
        //revisar si el primer disparo del arreglo se
        //sale de la pantalla
        if(!disparos.isEmpty() && disparos.get(0).getY()<=0){
            disparos.remove(0);
        }
        //revisamos si un disparo hace colisión
        //con un enemigo
        ArrayList<Rectangle> enemigo=new ArrayList<>();
        ArrayList<Rectangle> disparo=new ArrayList<>();
        for (Rectangle d:disparos){
            for(Rectangle e:SingletonItems.getInstance().getEnemigos().getEnemigos()){
                if(d.getBoundsInLocal().intersects(e.getBoundsInLocal())){
                    System.out.println("Colisión");
                    EfectosMusica efectosMusica=new EfectosMusica("disparo");
                    Thread hiloEfecto=new Thread(efectosMusica);
                    hiloEfecto.start();
                    enemigo.add(e);
                    disparo.add(d);
                    break;
                }
            }
        }
        //removiendo los disparos
        for(Rectangle d:disparo){
            disparos.remove(d);
        }
        //removiendo los enemigos
        for(Rectangle e:enemigo){
            SingletonItems.getInstance().getEnemigos().getEnemigos().remove(e);
        }
    }

    public ArrayList<Rectangle> getDisparos() {
        return disparos;
    }
}
