
package kmeans;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Jair Hernandez
 *         José Francisco Sandoval
 */
public class Ventana extends javax.swing.JFrame {
    int clases,objetos;
    int aux=0;
    boolean  v= false;
    
    
    int [] objx= null;
    int [] objy= null;
    
    int [] axc= null;
    int [] ayc= null;
    
    int [] r = null;
    int [] g = null;
    int [] b = null;
    
    int [] cr = null;
    int [] cg = null;
    int [] cb = null;
 
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 723, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
        );

        jButton1.setText("Clases");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Objetos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("OK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(41, 41, 41)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

        if(aux<clases){
            int h=evt.getX()+12;
            int w=evt.getY()+55;
            axc[aux]=h;
            ayc[aux]=w;
            r[aux] = (int) Math.floor(Math.random()*(255-0+1)+0);
            g[aux] = (int) Math.floor(Math.random()*(255-0+1)+0);
            b[aux] = (int) Math.floor(Math.random()*(255-0+1)+0);
            aux++;
            repaint();
        }else{
            JOptionPane.showMessageDialog(null,"Ya ingresaste todas las clases");
        }
        
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        clases = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el número de  clases ",JOptionPane.QUESTION_MESSAGE));
        axc = new int [clases];
        ayc = new int [clases];
        r = new int [clases];
        g = new int [clases];
        b = new int [clases];
        if(clases>objetos){
             clases = Integer.parseInt(JOptionPane.showInputDialog(null,"No puede haber más clases que objetos ",JOptionPane.QUESTION_MESSAGE));
        }
        if(clases>10){
        for (int i=0;i<clases;i++){
            axc [i]= (int) Math.floor(Math.random()*(727-15+1)+15);
            ayc [i]= (int) Math.floor(Math.random()*(525-60+1)+60);
            r[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            g[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            b[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
        }
        repaint();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        objetos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de  objetos ",JOptionPane.QUESTION_MESSAGE));
        objx=new int [objetos];
        objy=new int [objetos];
        cr=new int [objetos];
        cg=new int [objetos];
        cb=new int [objetos];
        for (int i=0;i<objetos;i++){
            objx [i] = (int) Math.floor(Math.random()*(727-15+1)+15);
            objy [i] = (int) Math.floor(Math.random()*(525-57+1)+57);
            cr[i]=255;
            cg[i]=0;
            cb[i]=255;
        }
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clases=0;
        objetos=0;
        jPanel1.removeAll();
        jPanel1.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
          distancia();
          repaint();
       /* while(!v){
             distancia();
             
             System.out.print(v);
             try {
                 Thread.sleep(1000);
                 repaint();
                 
             } catch (InterruptedException ex) {
                 Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
             }          
         }*/
    }//GEN-LAST:event_jButton4ActionPerformed

    public  void distancia(){
         
        double centroide = 0;
        double puntoActual = 0;
        int [] color = new int[3];
        boolean comparar = true;
        
        
        for(int i=0;i<objetos;i++){
            color[0]= cr[i];
            color[1]= cg[i];
            color[2]= cb[i];
       
            centroide = Math.sqrt( Math.pow(objx[i]-axc[0],2)+ Math.pow(objy[i]-ayc[0],2));
            cr[i]=r[0];
            cg[i]=g[0];
            cb[i]=b[0];
    
              for(int j=1;j<axc.length;j++){
                   puntoActual =Math.sqrt( Math.pow(objx[i]-axc[j],2)+ Math.pow(objy[i]-ayc[j],2));
                   
                   if(centroide>=puntoActual){
                       centroide=puntoActual;
                       cr[i]=r[j];
                       cg[i]=g[j];
                       cb[i]=b[j];   
                   }          
              }
              
               if(!(color[0]==cr[i] && color[1]==cg[i] &&color[2]==cb[i])){
                    comparar=false;
                    
                    
                }
               
        }
         
        centroides();
        if(comparar){
            JOptionPane.showMessageDialog(null,"Última iteración alcanzada");
            v = true;
        }else{
            v = comparar;
        }
      
    }
    
    public void centroides ()  {
        int sumaTotal=0;
        int totalX=0;
        int totalY=0;
        
        for(int i=0;i<axc.length;i++){
            for(int j=0;j<objx.length;j++){
                if(r[i]==cr[j] && g[i]==cg[j] && b[i]==cb[j]){
                    totalX += objx[j];
                    totalY += objy[j];
                    sumaTotal ++;  
                }
            }
            if(sumaTotal !=0){
                totalX=(int)(totalX/sumaTotal);
                totalY=(int)(totalY/sumaTotal);
                axc[i]=totalX;
                ayc[i]=totalY;
               
                    
            }
            totalX=0;
            totalY=0;
            sumaTotal=0;
            
           
        }
        
        
    }
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    public void paint(Graphics g){
        super.paint(g);
        
        if(objetos!= 0){
            for(int i =0; i<objx.length;i++){
                g.setColor(new Color(cr[i],cg[i],cb[i]));
                g.fillRect(objx[i],objy[i],10,10);                
            }   
        }
        if(clases!=0){
            for(int i =0; i<axc.length;i++){
                g.setColor(Color.BLACK);
                g.fillOval(axc[i],ayc[i],7,7);  
            }   
        }
       
        
         
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
 
}
