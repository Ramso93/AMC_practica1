/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Ramso
 */
public class Arista {
    private Punto origen;
    private Punto destino;
    private double distancia;
    
    Arista(Punto p1, Punto p2){
        origen=p1;
        destino=p2;
        distancia=distancia(origen,destino); 
    }
    public double distancia(Punto origen,Punto destino){
        return (double) abs(sqrt(pow(destino.getX() - origen.getX(), 2) + pow(destino.getY() - origen.getY(), 2)));
    }
    public Punto getOrigen(){
        return new Punto(origen.getID(),origen.getX(),origen.getY());
    }
    public Punto getDestino(){
        return new Punto(destino.getID(),destino.getX(),destino.getY());
    }
    public double getDistancia(){
        return distancia;
    }
    public boolean equal(Arista a){
        if(origen.equal(a.origen) && destino.equal(a.destino) && (distancia==a.distancia)){
            return true;
        }
        else{
            return false;
        }
    }
}
