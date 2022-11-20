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
public class Triangulo {
    private Punto p1, p2, p3;
    
    Triangulo(Punto p1, Punto p2, Punto p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }
    
    public Punto getDistanciaMenor(){
        // suma de la distancia de cada punto con los otros dos puntos
        double d1, d2, d3;
        d1 = p1.getDistancia(p2) + p1.getDistancia(p3);
        d2 = p2.getDistancia(p1) + p1.getDistancia(p3);
        d3 = p3.getDistancia(p1) + p1.getDistancia(p2);
        if(d1 < d2 && d1 < d3){
            p1.setDistanciaMenor(d1);
            return p1;
        }else if(d2 < d1 && d2 < d3){
            p2.setDistanciaMenor(d2);
            return p2;
        }else{
            p3.setDistanciaMenor(d3);
            return p3;
        }
    }
    
    public String getPuntos(){
        return "A: "+p1.verCoordenadas()+", B: "+p2.verCoordenadas()+", C:"+p3.verCoordenadas();
    }
    public Punto getA(){ return this.p1; }
    public Punto getB(){ return this.p2; }
    public Punto getC(){ return this.p3; }
    
}
