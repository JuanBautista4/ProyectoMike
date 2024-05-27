package fes.aragon.modelo;
import java.util.ArrayList;
public class SingletonLevel {
    private static SingletonLevel items;
    private FondoLevel fondo;
    private ArrayList<ComponentesJuego> elementos;

    private SingletonLevel(){this.iniciar();}

    public static SingletonLevel getInstance(){
        if(items == null){
            items = new SingletonLevel();
        }
        return items;
    }

    public void iniciar(){
        fondo=new FondoLevel(0,0,getClass().getResource("/fes/aragon/imagen/fondo2.jpg").getFile(),0);
        elementos.add(fondo);

    }

    public ArrayList<ComponentesJuego> getElementos() {
        return elementos;
    }
}
