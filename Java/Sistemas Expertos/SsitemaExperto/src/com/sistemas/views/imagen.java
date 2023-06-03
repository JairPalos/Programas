//Jair Antonio Palos Hernandez
//Jose Francisco Sandoval Rodriguez
package com.sistemas.views;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class imagen extends javax.swing.JPanel {
    int x, y, aux, aux2;

    public imagen(JPanel jPanel1) {
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
        this.aux=aux;
         this.aux2=aux2;
    }

    @Override
    public void paint(Graphics g) {
        
        ImageIcon Img = new ImageIcon(getClass().getResource("/imagen/10.png"));
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
        
    }    

}
