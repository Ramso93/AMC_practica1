/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafica;

import Codigo.Punto;
import Codigo.Triangulo;
import Codigo.Arista;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Ramso
 */
public class canvasSolucion extends Canvas{
    private Punto[] puntos;
    private Triangulo tri;
    private int x;
    private String s;
    private ArrayList<Arista> aris;

    private boolean grafo=false;
    /*Constructor para triangulo*/
    canvasSolucion(Punto[] puntos, Triangulo tri, String f){
        this.puntos=puntos;
        this.tri=tri;
        this.s=f;
        if(f.equals("d493.tsp") || f.equals("d657.tsp") || f.equals("burma14.tsp")){
            this.x=6;
        }else{
            this.x=2;
        }
        grafo=false;
        repaint();
    }
    /*contructor para grafo*/
    canvasSolucion(Punto[] puntos, ArrayList<Arista> a, String f){
        this.puntos=puntos;
        this.aris=a;
        this.s=f;
        if(f.equals("d493.tsp") || f.equals("d657.tsp")){
            this.x=6;
        }else if(f.equals("burma14.tsp")){
            this.x=3;
        }else{
            this.x=2;
        }
        this.grafo=true;
    }
    public void paint(Graphics g){
        Image offscreen = createImage(getWidth(), getHeight());
        Graphics og = offscreen.getGraphics();
        Font f1 = new Font("Helvetica", Font.ITALIC + Font.BOLD, 20);
        og.setFont(f1);
        og.setColor(Color.DARK_GRAY);
        if(!grafo){
            for(Punto p:puntos){
                if(p.getID()==tri.getA().getID() || p.getID()==tri.getB().getID() || p.getID()==tri.getC().getID()){
                    og.setColor(Color.RED);
                    if(this.s.equals("burma14.tsp")){
                        og.fillOval( (((int)p.getX())*this.x), (((int)p.getY())*this.x), 3, 3);
                    }else{
                        og.fillOval( (((int)p.getX())/this.x), (((int)p.getY())/this.x), 3, 3);
                    }
                }else{
                    og.setColor(Color.DARK_GRAY);
                    if(this.s.equals("burma14.tsp")){
                        og.fillOval( (((int)p.getX())*this.x), (((int)p.getY())*this.x), 3, 3);
                    }else{
                        og.fillOval( (((int)p.getX())/this.x), (((int)p.getY())/this.x), 3, 3);
                    }
                }
            }
        }
        if(grafo){
            og.setColor(Color.DARK_GRAY);
            for(Punto p:puntos){
                og.setColor(Color.DARK_GRAY);
                if(this.s.equals("burma14.tsp")){
                    og.fillOval( ((int)p.getX()*this.x), ((int)p.getY()*this.x), 3, 3);
                }else{
                    og.fillOval( ((int)p.getX()/this.x), ((int)p.getY()/this.x), 3, 3);
                }
                
            }
            og.setColor(Color.RED);
            for (int i = 0; i < aris.size(); i++) {
                double xOri, xDes, yOri, yDes;
                xOri=aris.get(i).getOrigen().getX();
                xDes=aris.get(i).getDestino().getX();
                yOri=aris.get(i).getOrigen().getY();
                yDes=aris.get(i).getDestino().getY();
                if(this.s.equals("burma14.tsp")){
                    og.drawLine( ((int)xOri*this.x), ((int)yOri*this.x), ((int)xDes*this.x), ((int)yDes*this.x));
                }else{
                    og.drawLine( ((int)xOri/this.x), ((int)yOri/this.x), ((int)xDes/this.x), ((int)yDes/this.x));
                }
                
            }
        }
        og.drawImage(offscreen, 0, 0, null);
        
        g.drawImage(offscreen, 0, 0, null);
    }
    public void update(Graphics g){
        paint(g);
    }
}
