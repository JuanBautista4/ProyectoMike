package fes.aragon.modelo;

import java.util.ArrayList;

public class SingletonItems {
    private static SingletonItems items;
    private Nave nave;
    private Fondo fondo;
    private Enemigos enemigos;
    private Disparo disparo;
    private ArrayList<ComponentesJuego> elementos;

    private SingletonItems() {
        this.iniciar();
    }
    public static SingletonItems getInstance(){
        if(items == null){
            items = new SingletonItems();
        }
        return items;
    }
    public void  iniciar(){
        nave=new Nave(50,200,null,1);
        fondo=new Fondo(0,0,getClass().getResource("/fes/aragon/imagen/fondo2.jpg").getFile(),
                getClass().getResource("/fes/aragon/imagen/fondo3.jpg").getFile(),3);
        enemigos = new Enemigos(20, 20, null, 1);
        disparo=new Disparo(0,0,null,3);
        elementos=new ArrayList<>();
        elementos.add(fondo);
        elementos.add(nave);
        elementos.add(enemigos);
        elementos.add(disparo);
    }

    public ArrayList<ComponentesJuego> getElementos() {
        return elementos;
    }

    public Nave getNave() {
        return nave;
    }

    public Fondo getFondo() {
        return fondo;
    }

    public Disparo getDisparo() {
        return disparo;
    }

    public Enemigos getEnemigos() {
        return enemigos;
    }
}
