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
public class guardarSolucion {
     private int[] distancias;
    private int[] anterior;
    private int inicio;

    public guardarSolucion(int[] distancias, int[] anterior, int inicio) {
        this.distancias = distancias;
        this.anterior = anterior;
        this.inicio = inicio;
    }

    public int[] getDistancias() {
        return distancias;
    }

    public int[] getAnterior() {
        return anterior;
    }

    public int getInicio() {
        return inicio;
    }
}
