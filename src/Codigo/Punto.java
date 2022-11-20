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
    private int id;
    private double x, y;
    private double distMenor;
    
    public Punto(int id, double x, double y){
        this.id = id;
        this.x=x;
        this.y=y;
    }
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    
    public int getID(){
        return this.id;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public double getDistancia(Punto p2){
        return Math.sqrt(Math.pow(this.x - p2.getX(), 2) + Math.pow(this.getY(), 2));
    }
    
    public void setDistanciaMenor(double distancia){ this.distMenor = distancia; }
    public Double getDistMenor(){ return this.distMenor; }
    
    public String verCoordenadas(){
        return "("+x+", "+y+")";
    }
    
    public int DistanciaDisjk(Punto p2){
        return (int)((((Math.sqrt(Math.pow(this.x - p2.x, 2) + Math.pow(this.y - p2.y, 2)))*100)%100)+1);
    }
    public boolean equal(Punto p){
       if((this.id==p.id) && (this.x==p.getX()) && (this.y==p.getY())){
           return true;
       }
       else{
           return false;
       }
    }
}
