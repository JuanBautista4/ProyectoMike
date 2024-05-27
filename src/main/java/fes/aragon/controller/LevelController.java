package fes.aragon.controller;

import fes.aragon.modelo.ComponentesJuego;
import fes.aragon.modelo.SingletonItems;
import fes.aragon.modelo.SingletonLevel;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class LevelController {
    private Canvas canvas;
    private GraphicsContext graficos;
    private Scene escena;


    public void setEscena(Scene escena) {
        this.escena = escena;
    }
    public void iniciar(){
        pintar();
    }

    private void pintar() {
        for (ComponentesJuego el: SingletonLevel.getInstance().getElementos()){
            el.pintar(graficos);
        }
    }


}
