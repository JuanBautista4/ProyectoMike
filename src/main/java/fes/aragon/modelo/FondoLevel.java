package fes.aragon.modelo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import java.io.File;
public class FondoLevel extends ComponentesJuego{
    private Image img;
    public FondoLevel(int x, int y, String imagen, int velocidad) {
        super(x, y, imagen, velocidad);
        try {
            File f = new File(imagen);
            this.img = new Image(f.toURI().toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pintar(GraphicsContext graficos) {

    }

    @Override
    public void teclado(KeyEvent evento, boolean presiona) {

    }

    @Override
    public void raton(MouseEvent evento) {

    }

    @Override
    public void logicaCalculos() {

    }
    public Image getImg() {
        return img;
    }
}
