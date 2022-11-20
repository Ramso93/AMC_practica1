package Codigo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Fichero {
    private Punto[] puntos;
    private BufferedReader entradaDatos;
    private String fich;
    private int ancho = 0, alto = 0;

    public Fichero(String fich) {
        this.fich = fich;
        System.out.println(fich);
        puntos = null;
    }

    public Punto[] getPuntos() {
        Punto[] puntos = null;
        int i = 0;
        try {
            String Linea;
            BufferedReader in = new BufferedReader(new FileReader("./src/data/"+this.fich));

            boolean CordSection = false;

            while ((Linea = in.readLine()) != null) {
                if (!Linea.equals("EOF") && !Linea.equals("")) {
                    if (CordSection) {
                        String[] separacion = Linea.split(" ");
                        //System.out.println(i+": "+separacion[1].trim()+" "+separacion[2].trim());
                        puntos[i] = new Punto(i, Double.parseDouble(separacion[1].trim()), Double.parseDouble(separacion[2].trim()));
                        i++;
                    } else {
                        if (Linea.equals("NODE_COORD_SECTION")) {
                            CordSection = true;
                        }else if (Linea.contains("DIMENSION")) {
                            String[] separacion = Linea.split(":");
                            //System.out.println("puntos: "+separacion[1].trim());
                            puntos = new Punto[Integer.parseInt(separacion[1].trim())];
                        }
                    }
                }
            }
            in.close();
            return puntos;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return puntos;
    }
    //public int getAncho(){return ancho;}
    //public int getAlto(){return alto;}
    
    public void Guardar(String nombre, guardarSolucion solucion){
        String nomb = nombre + ".opt.tour";
        try {
            File fichero = new File("./src/data/"+nomb);
            if (fichero.createNewFile()) {
                System.out.println("Fichero: " + fichero.getName() + " creado.");
            } else {
                System.out.println("Ya existe ese fichero.");
            }

        } catch (IOException e) {
            System.out.println("Error al crear el fichero.");
            e.printStackTrace();
        }
        try {
            BufferedWriter myWriter = new BufferedWriter(new FileWriter(nomb));
            PrintWriter printWriter = new PrintWriter(myWriter);
            printWriter.printf("NAME : %s%n", nomb);
            printWriter.printf("TYPE : TOUR%n");
            printWriter.printf("DIMENSION : %d%n", solucion.getDistancias().length);
            int coste = 0;
            for (int i = 0; i < solucion.getDistancias().length; i++) {
                coste = coste + solucion.getDistancias()[i];
            }
            printWriter.printf("SOLUTION : %d%n", coste);
            printWriter.printf("TOUR_SECTION%n");

            for (int i = 0; i < solucion.getDistancias().length; i++) {
                if (i != solucion.getInicio()) {
                    printWriter.printf("%d - ", solucion.getDistancias()[i]);
                    guardaCamino(i, solucion.getAnterior(), printWriter, i);
                    
                    printWriter.printf("%n");
                }
            }

            printWriter.printf("-1%n");
            printWriter.print("EOF");
            myWriter.close();
            System.out.println("Archivo guardado con exito.");
        } catch (IOException e) {
            System.out.println("Error al escribir");
            e.printStackTrace();
        }
    }
    private void guardaCamino(int actual, int[] anterior, PrintWriter printWriter, int i) {
        if (actual == -1) {

        } else {
            guardaCamino(anterior[actual], anterior, printWriter, i);
            if (actual == i) {
                printWriter.printf("%d", actual);
            }else{
                printWriter.printf("%d, ", actual);
            }
        }
    }
}
