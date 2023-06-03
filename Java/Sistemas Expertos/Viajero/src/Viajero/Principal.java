package Viajero;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jair Hernandez
 */


public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
        setLocationRelativeTo(null);
    }
    int [] coordenadasX= null;
    int [] coordenadasY= null;
    int [] cX= null;
    int [] cY= null;
    int [] r = null;
    int [] g = null;
    int [] b = null, a=null;
    int [][] valor=null;
    int aux=0 ;
    int  numeroCiudades,numero,numeroPoblacion,numeroGeneraciones;
    int [][] individuo=null;
    String[][] in=null, pobla=null,finall=null; 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel1.setText("Mapa");

        jLabel2.setText("Ciudades");

        jLabel3.setText("Resultados");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Numero de ciudades");

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
            .addGap(0, 473, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
        );

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane1.setViewportView(jTextArea3);

        jLabel5.setText("Numero de Poblacion");

        jLabel6.setText("Numero de Generaciones");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(315, 315, 315))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel3)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(107, 107, 107))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addContainerGap())
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jButton1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        numeroCiudades  = Integer.parseInt(jTextField1.getText());
        numeroPoblacion  = Integer.parseInt(jTextField2.getText());
        numeroGeneraciones=Integer.parseInt(jTextField3.getText());
        coordenadasX= new int [numeroCiudades];
        coordenadasY= new int [numeroCiudades];
        r = new int [numeroCiudades];
        g = new int [numeroCiudades];
        b = new int [numeroCiudades];
        for (int i=0;i<numeroCiudades;i++){
            coordenadasX [i]= (int) Math.floor(Math.random()*(473-15+1)+15);
            coordenadasY [i]= (int) Math.floor(Math.random()*(318-75+1)+75);
            
            r[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            g[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
            b[i] = (int) Math.floor(Math.random()*(255-0+1)+0);
        }
        repaint();
        ciudades();
        valores();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed

    }//GEN-LAST:event_jPanel1MousePressed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //removeAll();
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed
    public void ciudades(){
        cX= new int [numeroCiudades];
        cY= new int [numeroCiudades];
        for(int i=0;i<numeroCiudades;i++){
            String aux="Ciudad "+i+" : "+" \n";
            jTextArea1.append(aux);
            cX [i]=(int) (580);
            cY [i]=(int)(90+(i*16));
        }
    }
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
     public void paint(Graphics g2){
        super.paint(g2); 
        
            for(int i =0; i<numeroCiudades;i++){
                g2.setColor( new Color(r[i],g[i],b[i]));
                g2.fillRect(coordenadasX[i],coordenadasY[i],10,10);
                g2.fillOval(cX[i],cY[i],9,9);
                
            }      
                
    }
    public void valores(){
        valor=new int [numeroCiudades][numeroCiudades];
        int val=0;
         for(int i=0;i<numeroCiudades;i++){
              for(int j=0;j<numeroCiudades;j++){
                   if(i==j){
                      valor[i][j]=0;
                      jTextArea3.append(valor[i][j]+" ");
                   }else{
                       val = (int) (Math.sqrt( Math.pow(coordenadasX[i]-coordenadasX[j],2)+ Math.pow(coordenadasY[i]-coordenadasY[j],2))*0.1);
                       valor[i][j]=val;
                       jTextArea3.append(valor[i][j]+" ");
                   }
                }
            jTextArea3.append("\n");
        }
         poblacion();
    }
    
    public String[][] individuo(){
        int numeroValor=numeroCiudades-1;
        individuo=new int [numeroValor][2];
        int []a=new int[numeroValor]; 
        int aux=0;
        for(int i=0;i<numeroValor;i++){  
            boolean encontrado = false;
            int ale=(int)(Math.random()*numeroValor)+1;
               if(ale>numeroValor){
                   ale=ale-1;
               }
            for (int j=0;j<i ;j++){
                if(a[j]==ale){ 
                encontrado=true;
                }
            }
            if(!encontrado){
                individuo[i][0]=valor[aux][ale] ;
                individuo[i][1]+= ale ;
                aux=ale;
                a[i]=ale;
               
            }else{
                i--;
            }
        }
        
     return fucion();   
    }
    
    public String[][] fucion(){
        in =null;
        in=new String [2][2];
        int suma=0;
        String ciudades= "0";
         for(int i=0; i<numeroCiudades-1;i++){
             for(int j=0; j<1;j++){
             suma +=individuo[i][0];
             ciudades=ciudades+"--"+individuo[i][1];
            }
         }
         System.out.println("Suma todal: "+suma);
         System.out.println("Ciudades: "+ ciudades);
         in [0][0]=suma+"";
         in [0][1]=ciudades;
         
         return in;
    }
    
    
    public void poblacion(){
        
        for(int i=0;i<numeroGeneraciones;i++){
        String [][]aux = new String[2][2];
        pobla= new String[numeroPoblacion][2];
        for(int j=0;j<numeroPoblacion;j++){
           aux=individuo();
           pobla[j][0]=aux[0][0];
           pobla[j][1]=aux[0][1];
        }
        aptitud();
           jTextArea2.append("\n"+"El mejor de la generacion  "+i+" es : "+finall[0][0]+" La ciudades recorridas: "+finall[0][1]);
           jTextArea2.append("\n");
                
        }

    } 
    
    public void aptitud(){
         System.out.println("------------------------------------------------------------ ");
         int menor,tmp;
          int pos;
          for (int i = 0; i < numeroPoblacion - 1; i++) {      // tomamos como menor el primero
                menor = Integer.parseInt(pobla[i][0]);                       // de los elementos que quedan por ordenar
                pos =i;                            // y guardamos su posición
                for (int j = i + 1; j < numeroPoblacion; j++){ // buscamos en el resto
                      if ( Integer.parseInt(pobla[j][0])<menor ) {           // del array algún elemento
                          menor = Integer.parseInt(pobla[j][0]);             // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){                      // si hay alguno menor se intercambia
                    tmp =Integer.parseInt( pobla[i][0]);
                    pobla[i][0] =pobla[pos][0];
                    pobla[i][1] =pobla[pos][1];
                    pobla[pos][0] = tmp+"";
                    
                }
          }

        finall = Arrays.copyOf(pobla, pobla.length);
    }

    
     public void cruza(){
       int c1,c2;
       int [] nuevaPoblacion=new int[numeroPoblacion];
       int [] indicesAcruzar=new int[numeroPoblacion];
       for (int i=0;i<numeroPoblacion;i++){
             System.out.println("papa:"+pobla[ indicesAcruzar[i]]);
             System.out.println("mama:"+pobla[ indicesAcruzar[i+1]]);
              c1=hijo1(i);
              nuevaPoblacion[i]=c1;
              c2=hijo2(i);
              nuevaPoblacion[i+1]=c2;
              i++;
       }      
    }
    public int hijo1(int k){
         String [] indicesAcruzar=new String[numeroPoblacion];
         int [] pobla2=new int[numeroPoblacion];
         int valor =(jTextField1.getText().length()-1);
        
        

         return valor;
    }
    public int hijo2(int k){
        int [] indicesAcruzar=new int[numeroPoblacion];
        int valor =(jTextField1.getText().length()-1);
        System.out.println("muestra: "+valor); 
        return valor;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
