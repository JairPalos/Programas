
package kmeans;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentListener;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import org.math.plot.canvas.Plot3DCanvas;

/**
 *
 * @author Jair Hernandez
 *         José Francisco Sandoval
 */
public class Ventana extends javax.swing.JFrame {
    int clases,objetos;
    int aux=0;
    int dis=0;
    boolean  v= false;
    
    
    int [] objx= null;
    int [] objy= null;
    int [] objz= null;
    int [] axc= null;
    int [] ayc= null;
    int [] azc= null;
    
    int [] r = null;
    int [] g = null;
    int [] b = null;
    
    int [] cr = null;
    int [] cg = null;
    int [] cb = null;
 
    
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        plot3DCanvas1 = new org.math.plot.canvas.Plot3DCanvas();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout plot3DCanvas1Layout = new javax.swing.GroupLayout(plot3DCanvas1);
        plot3DCanvas1.setLayout(plot3DCanvas1Layout);
        plot3DCanvas1Layout.setHorizontalGroup(
            plot3DCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        plot3DCanvas1Layout.setVerticalGroup(
            plot3DCanvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plot3DCanvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(plot3DCanvas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Euclidiana", "Manhattan", "Minkowski", "Chebyshev" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
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
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(39, 39, 39)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
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
                    .addComponent(jButton2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

      /*  if(aux<clases){
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
        */
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        clases = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el número de  clases ",JOptionPane.QUESTION_MESSAGE));
       
        axc = new int [clases];
        ayc = new int [clases];
        azc = new int [clases];
        r = new int [clases];
        g = new int [clases];
        b = new int [clases];
        if(clases>objetos){
             clases = Integer.parseInt(JOptionPane.showInputDialog(null,"No puede haber más clases que objetos ",JOptionPane.QUESTION_MESSAGE));
        }
        
        for (int i=0;i<clases;i++){
            axc [i]= (int) Math.floor(Math.random()*(600-5+1)+5);
            ayc [i]= (int) Math.floor(Math.random()*(600-5+1)+5);
            azc [i]= (int) Math.floor(Math.random()*(600-5+1)+5);
            r[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            g[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            b[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
        }
               plot3DCanvas1.repaint();
                repaint();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        objetos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de  objetos ",JOptionPane.QUESTION_MESSAGE));
        objx=new int [objetos];
        objy=new int [objetos];
        objz=new int [objetos];
        cr=new int [objetos];
        cg=new int [objetos];
        cb=new int [objetos];
        for (int i=0;i<objetos;i++){
            objx [i] = (int) Math.floor(Math.random()*(600-5+1)+5);
            objy [i] = (int) Math.floor(Math.random()*(600-5+1)+5);
            objz [i] = (int) Math.floor(Math.random()*(600-5+1)+5);
            cr[i]=255;
            cg[i]=0;
            cb[i]=255;
        }
        plot3DCanvas1.repaint();
        repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        clases=0;
        objetos=0;
        plot3DCanvas1.removeAllPlots();
        jPanel1.repaint();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
            
            switch(dis){
                case 1:
                    distancia();
                    repaint();
                     plot3DCanvas1.plots.clear();
                break;
                case 2:
                    distanciaM();
                    repaint();
                     plot3DCanvas1.plots.clear();
                break;
                case 3:
                    distanciaMin();
                    repaint();
                     plot3DCanvas1.plots.clear();
                break;
                case 4:
                    distanciaC();
                    repaint();
                     plot3DCanvas1.plots.clear();
                break;
                
            }
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem()=="Euclidiana"){
              dis=1;
         }
         if(jComboBox1.getSelectedItem()=="Manhattan"){
              dis=2;
         }
          if(jComboBox1.getSelectedItem()=="Minkowski"){
              dis=3;
         }
           if(jComboBox1.getSelectedItem()=="Chebyshev"){
              dis=4;
         }
           
    }//GEN-LAST:event_jComboBox1ActionPerformed

    public  void distancia(){
         
        double centroide = 0;
        double puntoActual = 0;
        int [] color = new int[3];
        boolean comparar = true;
        
        
        for(int i=0;i<objetos;i++){
            color[0]= cr[i];
            color[1]= cg[i];
            color[2]= cb[i];
       
            centroide = Math.sqrt( Math.pow(objx[i]-axc[0],2)+ Math.pow(objy[i]-ayc[0],2)+ Math.pow(objz[i]-azc[0],2));
            cr[i]=r[0];
            cg[i]=g[0];
            cb[i]=b[0];
    
              for(int j=1;j<axc.length;j++){
                   puntoActual =Math.sqrt( Math.pow(objx[i]-axc[j],2)+ Math.pow(objy[i]-ayc[j],2)+ Math.pow(objz[i]-azc[j],2));
                   
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
    
    public  void distanciaM(){
         
        double centroide = 0;
        double puntoActual = 0;
        int [] color = new int[3];
        boolean comparar = true;
        
        
        for(int i=0;i<objetos;i++){
            color[0]= cr[i];
            color[1]= cg[i];
            color[2]= cb[i];
            centroide = Math.abs(axc[0]-objx[i])+Math.abs(ayc[0]-objy[i])+Math.abs(azc[0]-objz[i]);
        
            cr[i]=r[0];
            cg[i]=g[0];
            cb[i]=b[0];
    
              for(int j=1;j<axc.length;j++){
                   puntoActual = Math.abs(axc[j]-objx[i])+Math.abs(ayc[j]-objy[i])+Math.abs(azc[j]-objz[i]);
                  
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
    
    public  void distanciaMin(){
         
        double centroide = 0;
        double puntoActual = 0;
        int [] color = new int[3];
        boolean comparar = true;
        
        
        for(int i=0;i<objetos;i++){
            color[0]= cr[i];
            color[1]= cg[i];
            color[2]= cb[i];
       
            centroide = Math.cbrt(Math.abs(Math.pow(axc[0]-objx[i],3))+Math.abs(Math.pow(ayc[0]-objy[i],3))+Math.abs(Math.pow(azc[0]-objz[i],3)));
            cr[i]=r[0];
            cg[i]=g[0];
            cb[i]=b[0];
    
              for(int j=1;j<axc.length;j++){
                   puntoActual =Math.cbrt(Math.abs(Math.pow(axc[j]-objx[i],3))+Math.abs(Math.pow(ayc[j]-objy[i],3))+Math.abs(Math.pow(azc[j]-objz[i],3)));
                   
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
    
    public  void distanciaC(){
         
        double centroide = 0;
        double puntoActual = 0;
        int [] color = new int[3];
        boolean comparar = true;
        
        
        for(int i=0;i<objetos;i++){
            color[0]= cr[i];
            color[1]= cg[i];
            color[2]= cb[i];
       
            centroide = Math.max(Math.abs(objx[i]-axc[0]), Math.abs(objy[i]-ayc[0]));
            cr[i]=r[0];
            cg[i]=g[0];
            cb[i]=b[0];
    
              for(int j=1;j<axc.length;j++){
                   puntoActual = Math.max(Math.abs(objx[i]-axc[j]), Math.abs(objy[i]-ayc[j]));
                   
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
        int totalZ=0;
        
        for(int i=0;i<axc.length;i++){
            for(int j=0;j<objx.length;j++){
                if(r[i]==cr[j] && g[i]==cg[j] && b[i]==cb[j]){
                    totalX += objx[j];
                    totalY += objy[j];
                    totalZ += objz[j];
                    sumaTotal ++;  
                }
            }
            if(sumaTotal !=0){
                totalX=(int)(totalX/sumaTotal);
                totalY=(int)(totalY/sumaTotal);
                totalZ=(int)(totalZ/sumaTotal);
                axc[i]=totalX;
                ayc[i]=totalY;
                azc[i]=totalZ;
               
                    
            }
            totalX=0;
            totalY=0;
            totalZ=0;
            sumaTotal=0;
            
           
        }
        
        
    }
   
    public static void main(String args[]) {
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    public void paint(Graphics g){
        super.paint(g);
       
        double [] obx=new double[objetos];
        double [] oby=new double[objetos];
        double [] obz=new double[objetos];
        double [] ax=new double[clases];
        double [] ay=new double[clases];
        double [] az=new double[clases];
        
        if(objetos!= 0){
            for(int i =1; i<objx.length;i++){
                
                obx[0]=objx[i];
                oby[0]=objy[i];
                obz[0]=objz[i];
                  plot3DCanvas1.addScatterPlot("Objetos",new Color(cr[i],cg[i],cb[i]) , obx, oby, obz);  
                  plot3DCanvas1.repaint();
                  
            }   
            
        }
        if(clases!=0){
            
            for(int i =0; i<axc.length;i++){
                
                ax[0]=axc[i];
                ay[0]=ayc[i];
                az[0]=azc[i];
                plot3DCanvas1.addScatterPlot("Clases", Color.black, ax, ay, az);
                plot3DCanvas1.repaint();
            }   
        }
       
        
         
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private org.math.plot.canvas.Plot3DCanvas plot3DCanvas1;
    // End of variables declaration//GEN-END:variables

    private int addScatterPlot(String clases, Color black, double[] ax, double[] ay, double[] az) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
