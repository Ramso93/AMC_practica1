/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_22.pkg23;

import Codigo.*;

/**
 *
 * @author Ramso
 */
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /* PAT github */
        /* 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 */
        
        Fichero f=new Fichero("berlin52.tsp");
        //Fichero f=new Fichero("ch130.tsp");
        //Fichero f=new Fichero("ch150.tsp");
        //Fichero f=new Fichero("d493.tsp");
        //Fichero f=new Fichero("d657.tsp");
        Punto[] puntos=f.getPuntos();
        //for(Punto p:puntos){ System.out.println(p.verCoordenadas()); }
        
        Algoritmo algoritmos=new Algoritmo();
        
        
        long start = System.currentTimeMillis();
        Triangulo sol=algoritmos.exhaustivo(puntos);
        long end = System.currentTimeMillis();
        double time= (((double)end - (double)start)/1000);
        System.out.println("EXHAUSTIVO -> Tiempo : "+time+" segundos");
        System.out.println("Triangulo sol: ");
        System.out.println(" "+sol.getPuntos());
        
        long start1 = System.currentTimeMillis();
        Triangulo sol2=algoritmos.DyV(puntos);
        long end2 = System.currentTimeMillis();
       
        double time2 = (((double)end - (double)start)/1000);
        System.out.println("\n\nDyV -> Tiempo : "+time2+" segundos");
        System.out.println("Triangulo sol: ");
        System.out.println(" "+sol2.getPuntos());
        
        
        //System.out.println("Ordenacion:");
        //puntos=algoritmos.ordenarPuntosQuickSort(puntos);
        //for(Punto p:puntos){ System.out.println(p.verCoordenadas()); }
        
        algoritmos.Dijkstra(puntos, 0);
        //guardarSolucion g = algoritmos.guardarDijkstra();
        //f.Guardar("prueba", g);
    }
    
}
