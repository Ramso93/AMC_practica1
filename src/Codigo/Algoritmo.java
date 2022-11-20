/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Ramso
 */
public class Algoritmo {
    /* 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 */
    /**/
    /* Algoritmo de Ordenación */
    Punto[] puntos;
    ArrayList<ArrayList<Integer>>lista;
    //ArrayList<Integer>
    /*public Algoritmo(Punto[] puntos){
        this.puntos = puntos;
    }*/
    guardarSolucion g;
    public Punto[] ordenarPuntosQuickSort(Punto[] puntos){
        //System.out.println("entro aca 1");
        return ordenarPuntosQuickSort(puntos, 0, puntos.length-1);
    }
    public Punto[] ordenarPuntosQuickSort(Punto[] puntos, int izq, int der){
        Punto[] p=puntos;
        Punto piv=p[izq], aux;// tomamos primer elemento como pivote
        int i=izq, j=der;// i realiza la búsqueda de izquierda a derecha y j viceversa
        while(i<j){// mientras no se crucen las búsquedas    
            while(p[i].getX() <= piv.getX() && i<j ){ i++; }// busca elemento mayor que pivote
            while(p[j].getX()>piv.getX()){ j--; } // busca elemento menor que pivote
            if(i<j){// si no se han cruzado los intercambia  
                aux=p[i];
                p[i]=p[j];
                p[j]=aux;
            }
        }
        p[izq]=p[j];// se coloca el pivote en su lugar de forma que tendremos        
        p[j]=piv;// los menores a su izquierda y los mayores a su derecha
        if( izq<j-1){ ordenarPuntosQuickSort(p,izq,j-1);} // ordenamos subarray izquierdo
        if( j+1<der){ ordenarPuntosQuickSort(p,j+1,der);}// ordenamos subarray derecho
        this.puntos = p;
        return p;
        
    }
    /** ALG EXHAUSTIVO  */
    public Triangulo exhaustivo(Punto[] puntos){
         return exhaustivo(puntos, 0, puntos.length);
    }
    public Triangulo exhaustivo (Punto[] puntos, int i, int d){
        //dmin=distancia(puntos[i],puntos[i+1],puntos[i+2]);
        Triangulo min = new Triangulo(puntos[0], puntos[1], puntos[2]);
        for(int a=i; a<d; a++){
            for(int b=a+1; b<d; b++){
                for(int c=b+1; c<d; c++){
                    Triangulo aux = new Triangulo(puntos[a], puntos[b], puntos[c]);
                    if(aux.getDistanciaMenor().getDistMenor() < min.getDistanciaMenor().getDistMenor() ){
                        min = aux;
                    }
                }
            }
        }
        return min;
    }
    
    /** ALG DyV  */
    public Triangulo DyV(Punto[] puntos){
        /* 1ro ordenamos antes de implemental el algoritmo */
        ordenarPuntosQuickSort(puntos);
        /* una vez ordenado, implementamos el alg. */
        return DyV(puntos, 0, puntos.length -1 );
    }
    
    public Triangulo DyV(Punto[] puntos, int izq, int der){
        Triangulo menor, solIzq,solDer=null;
        int medio=(izq+der)/2;
        if( (der-izq)+1 < 6 ){//al haber un max de 5 puntos, es mejor usar alg exh
            menor = exhaustivo(puntos, izq, der);
        }else {//para un conj de 3 puntos el min nec es de 6 puntos
            int i,j;//j->franja por la izq | i->franja por la der
            solIzq=DyV(puntos,izq,medio);//sol de la parte izq
            solDer=DyV(puntos,medio+1,der);//sol de la parte der
            //ahora comparamos solIzq & solDer y nos quedamos con el mmenor
            if(solIzq.getDistanciaMenor().getDistMenor() < solDer.getDistanciaMenor().getDistMenor()){
                menor = solIzq;
            }else{
                menor = solDer;
            }
            //dentro del if esta es la parte más compleja
            //xq si dividimos los puntos en 2 y la sol este en la mitad()
            //para ello trazamos una linea imaginaria y trazamos 2 linea simaginarias(uno a la izq y otro a la der)
            //descartamos los que esten fuera, por la izq, de la linea izq, y por la izq igual
            //como saber cual es la linea de la izq y de la der?
            //parte izq-> bucle de la mitad hasta 0
            //parte der-> bucle de la mitad hasta final
            
            
            //parte izq
            for(j=medio; j>=izq; j--){
                //bucle hasta encontrar la franja por la izq, si encontramos paramos
                // y nos quedamos con ese valor-> en nuestro caso es j
                if( (puntos[medio+1].getX()-puntos[j].getX()) > menor.getDistanciaMenor().getDistMenor()){
                    //j+1
                    break;
                }
            }//tenmos [j+1,m]->punto de la franja izq
            //parde der ->igual que el bucle anterior pero por la parte der
            for(i=medio+1; i<=der; i++){
                if(puntos[i].getX()-puntos[medio].getX() > menor.getDistanciaMenor().getDistMenor()){
                    //i-1
                    break;
                }
            }//tenemos [m,i-1]->punto de la franja der
            
            //mala idea si comprobamos(exhaustivo) los que estan entre j+1 e i-1
            //en vez de comproba con exh... probamos lo siguiente:
            //ATENCION->situacion donde 1 triangulo tiene 1 punto en la izq y 2 en la der
                /**/ 
                                        
                for(int p=j+1; p<=medio; p++){//1 punto de la izq //a+1 <=m
                    for(int q=p+1; q<=i-1; q++){//2º y 3er bucle pillas punto de la der
                        //m+1 b-1
                        for(int r=q+1; r<=i-1;r++){//f+1 <=b-1
                            Triangulo aux=new Triangulo(puntos[p],puntos[q],puntos[r]);
                            /*if(aux.perimetro() < trim.perimetro()){
                                trim=aux;
                            }else if( (aux.perimetro() < trim.perimetro()) && aux.area()>trim.area()){
                                trim=aux;
                            }*/
                            if(aux.getDistanciaMenor().getDistMenor() < menor.getDistanciaMenor().getDistMenor()){
                                menor = aux;
                            }
                        }
                    }
                }
            //ATENCION->situacion a la viceversa
                /**/
                //primer y segundo bucle pillas punto de la izq
                //el tercer bucle pilla uno de la der
                for(int e=j+1;e<=medio;e++){
                    for(int f=e+1;f<=medio;f++){
                        for(int g=medio+1;g<=i-1;g++){
                            //dis=distancia(t[e],t[f],t[g])
                            Triangulo aux2=new Triangulo(puntos[e],puntos[f],puntos[g]);
                            //if(dis<dmin)
                            /*if(aux2.perimetro() < trim.perimetro()){
                                trim=aux2;
                            }else if( (aux2.perimetro() < trim.perimetro()) && (aux2.area()>trim.area()) ){
                                trim=aux2;
                            }*/
                            if(aux2.getDistanciaMenor().getDistMenor() < menor.getDistanciaMenor().getDistMenor()){
                                menor = aux2;
                            }
                        }
                    }
                }
                
        }
        return menor;
    }
    
    /*public void DijKstra(Punto[] puntos, int inicio){
        Punto CO;
        int puntoInicial = inicio;
        ArrayList<Integer> distancias = new ArrayList<>(puntos.length-1);
        ArrayList<Boolean> Visitado = new ArrayList<>(puntos.length);
        distancias.add(inicio, 0);
        
        while(!Visitado.get(puntoInicial)){
            CO = getFirstCO(puntoInicial);
        }
        
    }
    
    public Punto getFirstPunto(int inicio){
        for(){
        
        }
        for(Punto p:puntos){ System.out.println(p.verCoordenadas()); }
    }
   */
    public void Dijkstra(Punto[] puntos, int inicio){
        lista = new ArrayList<>();
        int numeroPuntos = puntos.length;
        
        int[][] matrizAdyacencia = new int[puntos.length][puntos.length]; //Creo un grafo bidimensional que contenga las distancias entre los puntos
        for (int i = 0; i < puntos.length; i++) {
            for (int j = 0; j < puntos.length; j++) {
                matrizAdyacencia[i][j] = puntos[i].DistanciaDisjk(puntos[j]);
                if (i == j){
                    matrizAdyacencia[i][j] = 0;
                }
            }
        }

        int[] distancias = new int[numeroPuntos]; //Array D con la distancia minima del punto de inicio al i

        boolean[] visitado = new boolean[numeroPuntos]; //true si el punto ha sido visitado

        //Inicializamos los valores de distancia a infinito (el integer mas grande) y todos los nodos como no visitados
        for (int i = 0; i < numeroPuntos; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        distancias[inicio] = 0; //La distancia del nodo inicial a si mismo es 0

        int[] anterior = new int[numeroPuntos]; //Array que contiene el nodo anterior al nodo "i"

        anterior[inicio] = -1; //el punto inicial no tiene anterior

        for (int i = 1; i < numeroPuntos; i++) {

            int distanciaMinima = Integer.MAX_VALUE;
            int indice_min = -1; //indice del punto con la distancia mas corta al inicio del conjunto de vertices no visitados

            for (int j = 0; j < numeroPuntos; j++) {
                if (distancias[j] < distanciaMinima && !visitado[j]) {
                    distanciaMinima = distancias[j];
                    indice_min = j;
                }
            }

            visitado[indice_min] = true; //marcamos ese punto como visitado
            
            for (int j = 0; j < numeroPuntos; j++) {

                if (matrizAdyacencia[indice_min][j] > 0 && ((distanciaMinima + matrizAdyacencia[indice_min][j]) < distancias[j])) {

                    distancias[j] = distanciaMinima + matrizAdyacencia[indice_min][j];
                    anterior[j] = indice_min;
                }
            }
            
        }

        int total = 0;
        for (int j = 0; j < distancias.length; j++) {
            total = total + distancias[j];
        }
        
        
        /* LO SIGUIENTE SE PUEDE TACHAR */
        System.out.println();
        System.out.print("Viaje\t\t Distancia\tCamino");

        for (int i = 0; i < numeroPuntos; i++) {
            if (i != inicio) {
                System.out.print("\n" + inicio + " -> ");
                if (i < 10) { //Condicion estetica
                    System.out.print(i + " \t\t ");
                } else {
                    System.out.print(i + " \t ");
                }
                System.out.print(distancias[i] + "\t\t");
                muestraCamino(i, anterior);

            }
        }
        System.out.println();
        System.out.println("Distancia total: " + total);
        g = new guardarSolucion(distancias, anterior, inicio);
    }
    
    public void muestraCamino(int actual, int[] anterior){
        if (actual != -1){
            muestraCamino(anterior[actual], anterior);
            System.out.print(actual + " ");
        }
    }
    
    public guardarSolucion guardarDijkstra(){
        return g;
    }
}
