
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Usuario {

    Laberinto lab = new Laberinto();
    
    private int x = 40;
    private int y = 40;
    private final int ancho = 40;
    private final int alto = 40;
    private final int movimiento = 40;
    
    public void paint(Graphics grafico){
        
        grafico.setColor(Color.RED);
        grafico.fillOval(x, y, ancho, alto);
        
        grafico.setColor(Color.BLACK);
        grafico.drawOval(x, y, ancho, alto);   
    
    }
    
    public void teclaPresionada(KeyEvent evento){
        int[][] laberinto = lab.obtenerLaberinto();
       
        if (evento.getKeyCode()==37){
            if(laberinto[y/40][(x/40)-1]!=1){
            x = x - movimiento;
        }      
    }
     if (evento.getKeyCode()==39){
            if(laberinto[y/40][(x/40)-1]!=1){
            x = x + movimiento;    
        }      
    }
     if (evento.getKeyCode()==40){
            if(laberinto[y/40][(x/40)-1]!=1){
            y = y - movimiento;
        }      
    }
     if (evento.getKeyCode()==38){
            if(laberinto[y/40][(x/40)-1]!=1){
            y = y + movimiento;
        }
     }
}
}