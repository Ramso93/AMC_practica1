package Codigo;
public class Algoritmo {
    /* Algoritmo de Ordenación */
    public Punto[] ordenarPuntosQuickSort(Punto[] puntos){
        return ordenarPuntosQuickSort(puntos, 0, puntos.length-1);
    }
    public Punto[] ordenarPuntosQuickSort(Punto[] puntos, int i, int f)
    {
        Punto[] p = puntos;
        Punto piv = p[izq], aux; // elemento pivote=primer elemento array
        int i= izq, j=f;//i busquesa izq. a der. y j viceversa
        while(i<j){
            while(p[i].getX() <= piv.getX() && i<j){
                i++;
            }
            while(p[j].getX() > piv.getX()){
                j--;
            }
            if(i<j){
                aux=p[i];
                p[i]=p[j];
                p[j]=aux;
            }
        }
        p[izq]=p[j];
        p[j]=piv;
        if(izq < j-1 ){
            ordenarPuntosQuickSort(p, izq, j-1);
        }
        if( j+1 < f){
            ordenarPuntosQuickSort(p,+1,f);
        }
        return p;
    }
    /** ALG EXHAUSTIVO  */
    private static Triangulo exhaustivo(Punto[] puntos){
         return exhaustivo(puntos, 0, puntos.length);
    }
    private static Triangulo exhaustivo (Punto[] puntos, int i, int d){
        //dmin=distancia(puntos[i],puntos[i+1],puntos[i+2]);
        Triangulo min = new Triangulo(puntos[0], puntos[1], puntos[2]);
        for(int a=i;a<=d;a++){//a<=d
            for(int b=a+1; b<=d;b++){//b<=d
                for(int c=b+1;c<=d;c++){//c<=d
                    //distancia o triangulo
                    Triangulo aux = new Triangulo(puntos[a], puntos[b], puntos[c]);
                    if(aux.perimetro() < min.perimetro())
                    {
                        min=aux;
                    }
                    else if((aux.perimetro()==min.perimetro()) && (aux.area()>min.area()))
                    {
                        min = aux;
                    }
                }
            }
        }
        return min;
    }

    /** ALG DYV */
}
