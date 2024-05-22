package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.*;
import javafx.scene.shape.Rectangle;

public class Nave extends ComponentesJuego{
    private boolean derecha=false;
    private boolean izquierda=false;
    private boolean arriba=false;
    private boolean abajo=false;
    private boolean disparo=false;

    private int ancho=20;
    private int alto=20;

    public Nave(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        graficos.strokeRect(x,y,ancho,alto);

    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {
        System.out.println(evento.getCode().toString());

        if(evento.isAltDown()){
            String codigo=evento.getCode().toString();
            if(codigo.equals("X")){
                System.out.println("Evento combinado");
            }
        }
        switch (evento.getCode().toString()) {
            case "RIGHT":
                derecha=true;
                izquierda=false;
                arriba=false;
                abajo=false;
                break;
            case "LEFT":
                derecha=false;
                izquierda=true;
                arriba=false;
                abajo=false;
                break;
            case "UP":
                derecha=false;
                izquierda=false;
                arriba=true;
                abajo=false;
                break;
            case "DOWN":
                derecha=false;
                izquierda=false;
                arriba=false;
                abajo=true;
                break;
            case "A":
                if(!presiona) {
                    disparo = true;
                }
                break;
        }
    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {
        if(derecha){
            if(x<SingletonItems.getInstance().getFondo().getImg().getWidth()-ancho) {
                x++;
            }
        }else if(izquierda){
            if(x>=0){
                x--;
            }
        }else if(arriba){
            if(y>0){
                y--;
            }
        }
        else if(abajo){
            if(y<SingletonItems.getInstance().getFondo().getImg().getHeight()-alto){
                y++;
            }
        }
        if(disparo){
            Rectangle rec=new Rectangle(x,y,10,10);
            SingletonItems.getInstance().getDisparo().getDisparos().add(rec);
            disparo=false;

        }
    }
}
