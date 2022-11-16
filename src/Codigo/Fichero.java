package Codigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        int i = 0;
        try {
            System.out.println(fich);
            entradaDatos = new BufferedReader(new FileReader("./src/data/" + fich));
            String Linea;
            boolean CordSection = false;
            while ((Linea = entradaDatos.readLine()) != null) {
                if (!Linea.equals("EOF") && !Linea.equals("")) {
                    if (CordSection) {
                        int a = -1, b = -1, c = -1, o = -1;
                        String[] parts = Linea.split(" ");
                        while (o<parts.length) {
                            if (!parts[o].isEmpty()) {
                                if (a==-1) {
                                    a=o;
                                }
                                else if (b==-1) {
                                    b=o;
                                }
                                else if(c==-1){
                                    c=o;
                                }
                            }
                            o++;
                        }
                        if (ancho<Double.parseDouble(parts[b].trim())) {
                            ancho = (int) Double.parseDouble(parts[b].trim());  
                        }
                        if (alto<Double.parseDouble(parts[c].trim())) {
                            alto= (int) Double.parseDouble(parts[c].trim());
                        }
                        puntos[i++] = new Punto(Integer.parseInt(parts[a].trim()),Double.parseDouble(parts[b].trim()),Double.parseDouble(parts[c].trim()));
                    }
                    else{
                        if (Linea.equals("NODE_COORD_SECTION")) {
                            CordSection =true;
                        }
                        else if (Linea.contains("DIMENSION")) {
                            String[] parts = Linea.split(" ");
                            puntos = new Punto[Integer.parseInt(parts[1].trim())];
                        }
                    }
                }
            }
            entradaDatos.close();
        } catch (IOException e) {
            System.out.println("Error al leeer el fichero");
        }
        return puntos;
    }
    public int getAncho(){return ancho;}
    public int getAlto(){return alto;}
}
