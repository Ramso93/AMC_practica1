/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

/**
 *
 * @author Ramso
 */
public class Punto {
    private double x;
    private double y;
    private int id;

    public Punto() {
        x=0;
        y=0;
    }
    public Punto(int id, double x, double y){
        this.id=id;
        this.x=x;
        this.y=y;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Punto Coordenada(){
        return this;
    }

    //Getters
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    //Setters
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public static double distancia(Punto p1, Punto p2){
        return Math.sqrt(Math.sqrt(Math.pow(p1.getX()-p2.getId(), 2) + Math.sqrt(Math.pow(p1.getY() - p2.getY(), 2))));
    }
    public Double distancia(Punto p) {
        return Punto.distancia(this, p);
    }
}
