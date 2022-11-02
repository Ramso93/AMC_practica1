package Codigo;
public class Algoritmo {
    /* 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 */
    /**/
    /** ALG EXHAUSTIVO  */
    private static Triangulo exhaustivo(Punto[] puntos){
         return exhaustivo(puntos, 0, puntos.length);
    }
    private static Triangulo exhaustivo (Punto[] puntos, int i, int d){
        dmin=distancia(puntos[i],puntos[i+1],puntos[i+2]);
        for(int a=i;a<=d;a++){
            for(int b=a+1; b<=d;b++){
                for(int c=b+1;c<=d;c++){
                    //distancia o triangulo
                }
            }
        }
        return null;
    }

    /** ALG DYV */
}
