/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author jesus
 */
public class Ventana extends JPanel {
    Laberinto laberinto = new Laberinto();
    Usuario personaje = new Usuario();
    
    public Ventana(){
        addKeyListener(new KeyListener(){
        public void KeyTyped(KeyEevent e){   
        }
       @Override
       public void keyPressed(KeyEvent e){
            personaje.teclaPresionada(e);
        }
       @Override
       public void keyReleased(KeyEvent e){
        }

            @Override
            public void keyTyped(KeyEvent ke) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
    });
    setFocusable(true);
    }//aqui termina el constructor
    @Override
    public void paint(Graphics grafico){
        laberinto.paint(grafico);
        personaje.paint(grafico);
    }
    public static void main(String[]args){
        JFrame miVentana = new JFrame ("Mi laberinto");
        Ventana game = new Ventana();
        miVentana.add(game);
        miVentana.setSize(937,557);
        miVentana.setVisible(true);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            
           try {
           Thread.sleep(10);
               
           }catch(InterruptedException ex){
               Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE,null,ex);  
           }
           game.repaint();
    }
        
    }

    private static class KeyEevent {

        public KeyEevent() {
        }
    }
        
}