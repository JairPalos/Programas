
import java.awt.Graphics;
import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Laberinto {
    
    private int fila = 0;
    private int columna = 0;
    private final int numeroFilas = 13;
    private final int numeroColumnas = 23;
    private final int anchoBloque = 40;
    private final int altoBloque = 40;
    
    public void paint(Graphics grafico){
        int[][]laberinto = obtenerLaberinto();
        
        for(fila = 0;fila<numeroFilas;fila++){
            for(columna = 0;columna<numeroColumnas;columna++){
                
                if(laberinto[fila][columna]==0){
                    grafico.setColor(Color.WHITE);
                    grafico.fillRect(columna*40,fila*40,anchoBloque, altoBloque);
                    
                }else if(laberinto[fila][columna]==1){
                    grafico.setColor(Color.PINK);
                    grafico.fillRect(columna*40,fila*40,anchoBloque, altoBloque);
                    grafico.setColor(Color.BLACK);
                     grafico.fillRect(columna*40,fila*40,anchoBloque, altoBloque);
                }
            }
        }
    }
    public int[][]obtenerLaberinto(){
        int lab[][]= {//°1=pared 0°=camino
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//1
            {1,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},//2
            {1,1,0,1,0,1,0,1,0,0,0,0,0,1,1,0,0,0,0,1,1,0,1},//3
            {1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,0,1,1,0,1,1,0,1},//4
            {1,1,0,0,0,1,0,1,0,1,1,1,0,1,1,0,1,0,0,1,1,0,1},//5
            {1,1,1,1,1,1,0,1,0,1,1,1,0,1,0,0,1,0,1,1,1,0,1},//6
            {1,1,0,0,0,0,0,1,0,1,1,1,0,1,0,1,1,0,0,1,1,0,1},//7
            {1,1,0,1,1,1,1,1,0,1,0,0,0,1,0,1,1,1,0,1,1,0,1},//8
            {1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1},//9
            {1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1},//10
            {1,1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,0,1,1,0,1},//11
            {1,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,0,0,0,0,1},//12
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//13
        };
        return lab;
        }

    
}
    