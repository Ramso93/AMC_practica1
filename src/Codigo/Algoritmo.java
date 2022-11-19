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
public class Algoritmo {
    /* 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 */
    /**/
    /** ALG EXHAUSTIVO  */
    
    /** ALG DYV */
    public Triangulo DyV(Punto[] puntos){
        return DyV(puntos, 0, puntos.length);
    }
    public Triangulo DyV(Punto[] puntos, int izq, int der){
        Triangulo trii, trid, trim;
        int mitad = (izq+der)/2;
        if( (der-izq)+1 >= 6 ){
            int i, j;
            trii = DyV(puntos, izq, mitad);
            trid = DyV(puntos, mitad, der);
            /* Comparamos area y perimetro de ambos triangulos para quedarnos con el minimo*/
            /*if(trii.perimetro()==trid.perimetro() && trii.area() > trid.area()){
                trim = trii;
            }else{
                trim = trid;
            }*/
        }
        return null;
    }
}
