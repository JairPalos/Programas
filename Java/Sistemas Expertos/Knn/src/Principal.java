
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    int k,clases,numeroObjetos,uno,dos;
    int [] classx=null;
    int [] classy=null;
    int [] array=null;
    
    int [] d1=null;
    int [] d2=null;
    int [] d3=null;
    int [] d4=null;
    int [] d5=null;
    
    public class  Dibujo2D extends JPanel{
    public Dibujo2D(){

     }
     @Override
     protected void paintComponent(Graphics g){
         g.setColor(Color.black);
         g.drawLine(0, 150, 600, 150);
         g.setColor(Color.black);
         g.drawLine(270,0, 270, 400);
         if(clases>=1){
         clase1(g);}
         if(clases>=2){
         clase2(g);}
         if(clases>=3){
         clase3(g);}
         if(clases>=4){
         clase4(g);}
         if(clases==5){
         clase5(g);}
         pun(g);
         knn();
         pintarNuevoColor(g);

    }
     private void clase1(Graphics g){

         classx=new int[numeroObjetos*clases];
         classy=new int[numeroObjetos*clases];
         for(int i=0; i<numeroObjetos;i++){
                int x = (int) Math.floor(Math.random()*(549-0+1)+0);
                int y = (int) Math.floor(Math.random()*(293-0+1)+0);
                classx[i]=x;
                classy[i]=y;
                g.setColor(Color.red);
                g.fillOval(x,y,10,10);

         }

     }
     private void clase2(Graphics g){
         for(int i=numeroObjetos; i<numeroObjetos*2;i++){
            int x = (int) Math.floor(Math.random()*(549-0+1)+0);
            int y = (int) Math.floor(Math.random()*(293-0+1)+0);
            classx[i]=x;
            classy[i]=y;
            g.setColor(Color.blue);
            g.fillOval(x,y,10,10);


         }

     }

     private void clase3(Graphics g){

         for(int i=numeroObjetos*2; i<numeroObjetos*3;i++){
            int x = (int) Math.floor(Math.random()*(549-0+1)+0);
            int y = (int) Math.floor(Math.random()*(293-0+1)+0);
            classx[i]=x;
            classy[i]=y;
            g.setColor(Color.yellow);
            g.fillOval(x,y,10,10);
         }

     }

    private void clase4(Graphics g){

         for(int i=numeroObjetos*3; i<numeroObjetos*4;i++){
            int x = (int) Math.floor(Math.random()*(549-0+1)+0);
            int y = (int) Math.floor(Math.random()*(293-0+1)+0);
            classx[i]=x;
            classy[i]=y;
            g.setColor(Color.pink);
            g.fillOval(x,y,10,10);
         }

     }

    private void clase5(Graphics g){
         for(int i=numeroObjetos*4; i<numeroObjetos*5;i++){
            int x = (int) Math.floor(Math.random()*(549-0+1)+0);
            int y = (int) Math.floor(Math.random()*(293-0+1)+0);
            classx[i]=x;
            classy[i]=y;
            g.setColor(Color.green);
            g.fillOval(x,y,10,10);
         }

     }
    private void pun(Graphics g){
         g.setColor(Color.black);
         g.fillOval(uno,dos,10,10);

     }

    }

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KNN");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("k");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Numeros de clases");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Numero de Objetos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Punto a Buscar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel1.setText("Clase 1  -> Rojo ");

        jLabel2.setText("Clase 5 -> Verde");

        jLabel3.setText("Clase 2 -> Azul");

        jLabel4.setText("Clase 3 -> Amarrilo");

        jLabel5.setText("Clase 4 -> Rosa");

        jButton6.setText("Limpiar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(670, 670, 670))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButton3)
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31)
                        .addComponent(jButton5)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)))
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       if(evt.getSource() == jButton4){
        numeroObjetos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de Objetos ",JOptionPane.QUESTION_MESSAGE));
        if(numeroObjetos>100)
        numeroObjetos = Integer.parseInt(JOptionPane.showInputDialog(null,"El numero de objetos debe ser menor o igual a 100 ",JOptionPane.ERROR_MESSAGE));
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource() == jButton3){
        clases = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de  Clases ",JOptionPane.QUESTION_MESSAGE));
        if(clases>5)
          clases = Integer.parseInt(JOptionPane.showInputDialog(null,"El numero de clases debe ser menor o igual a 5 ",JOptionPane.ERROR_MESSAGE));
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      if(evt.getSource() == jButton2) {
          k = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de  K ",JOptionPane.QUESTION_MESSAGE));
          if(k>6 || k>numeroObjetos)
          k = Integer.parseInt(JOptionPane.showInputDialog(null,"El numero de k no aceptado, vuelva a ingresarla ",JOptionPane.ERROR_MESSAGE));

      }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(evt.getSource() == jButton1) {
          dibujar();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          if(evt.getSource() == jButton5) {
          uno = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la coordenada en  x maximo(549) ",JOptionPane.QUESTION_MESSAGE));
          dos = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa la coordenada en  y maximo(293) ",JOptionPane.QUESTION_MESSAGE));

          }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(evt.getSource() == jButton6) {
        jPanel1.removeAll();
        jPanel1.repaint();
        clases=0;
        numeroObjetos=0;
        k=0;
        }
    }//GEN-LAST:event_jButton6ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    public void dibujar (){
        Principal.Dibujo2D plano=new  Principal.Dibujo2D();
        plano.setBounds(0,0,1000,1000);
        plano.setOpaque(false);
        jPanel1.add(plano);
        jPanel1.repaint();

    }

    public void knn(){
        array =new int[classx.length];
        d1=new int[numeroObjetos];
        d2=new int[numeroObjetos];
        d3=new int[numeroObjetos];
        d4=new int[numeroObjetos];
        d5=new int[numeroObjetos];
        double d;
        int aux= 0;
        int aux1= 0;
        int aux2= 0;
        int aux3= 0;
        int aux4= 0;

        for(int i=0;i<classx.length;i++){
        d =(float) Math.sqrt( Math.pow(classx[i]-uno,2)+ Math.pow(classy[i]-dos,2));
        if(i<numeroObjetos){
            d1[i]=(int)d;
        }
        else if(i>=numeroObjetos && i<(numeroObjetos*2) && i<numeroObjetos*3 && i<numeroObjetos*4 && i<numeroObjetos*5){
            d2[aux]=(int)d;
            aux++;
        }
        else if(i>numeroObjetos &&i>= numeroObjetos*2 && i<numeroObjetos*3 && i<numeroObjetos*4 && i<numeroObjetos*5){
            d3[aux2]=(int)d;
            aux2++;
        }
        else if(i>numeroObjetos && i> numeroObjetos*2 && i>=numeroObjetos*3 && i<numeroObjetos*4 && i<numeroObjetos*5 ){
            d4[aux3]=(int)d;
            aux3++;
        }
        else if(i>numeroObjetos && i> numeroObjetos*2 && i>numeroObjetos*3 && i>=numeroObjetos*4 && i<numeroObjetos*5){
            d5[aux4]=(int)d;
            aux4++;
        }

        array[i]=(int)d;

        }


        array=seleccion(array);


    }

    public int[] seleccion(int A[]) {
          int i, j, menor, pos, tmp;
          for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
                menor = A[i];                       // de los elementos que quedan por ordenar
                pos = i;                            // y guardamos su posición
                for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                      if (A[j] < menor) {           // del array algún elemento
                          menor = A[j];             // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){                      // si hay alguno menor se intercambia
                    tmp = A[i];
                    A[i] = A[pos];
                    A[pos] = tmp;
                }
          }

       return A;
}

    public void pintarNuevoColor(Graphics g){
        int [] cercano=new int[k];
        d1=seleccion(d1);
        d2=seleccion(d2);
        d3=seleccion(d3);
        d4=seleccion(d4);
        d5=seleccion(d5);

        cercano = new int[k];
        for(int i=0;i<k;i++){
           cercano[i]=array[i];
           System.out.println("Puntos a evaluar");
           System.out.println(cercano[i]);
           System.out.println("___________________________________________________");
         }
        for(int i=0;i<k;i++){
           System.out.println("rojo");
           System.out.println(d1[i]+d1.length);

         }
        for(int i=0;i<k;i++){
           System.out.println("azul");
           System.out.println(d2[i]+d2.length);

         }
        for(int i=0;i<k;i++){
           System.out.println("amarrilo");
           System.out.println(d3[i]+d3.length);

         }
        for(int i=0;i<k;i++){
           System.out.println("rosa");
           System.out.println(d4[i]+d4.length);

         }
        for(int i=0;i<k;i++){
           System.out.println("verde");
           System.out.println(d5[i]+d5.length);

         }
            if(k==1){
            if(d1[0]==cercano[0]){
               g.setColor(Color.red);
               g.fillOval(uno-1,dos-1,15,15);

            }
            else if(d2[0]==cercano[0]){
               g.setColor(Color.blue);
               g.fillOval(uno-1,dos-1,15,15);

            }
            else if(d3[0]==cercano[0]){
               g.setColor(Color.yellow);
               g.fillOval(uno-1,dos-1,15,15);

            }
            else  if(d4[0]==cercano[0]){
               g.setColor(Color.pink);
               g.fillOval(uno-1,dos-1,15,15);

            }
            else  if(d5[0]==cercano[0]){
               g.setColor(Color.green);
               g.fillOval(uno-1,dos-1,15,15);

            }
           }else if(k>=2){

            for(int i = 0 ; i<k;i++){
                if(d1[i]==cercano[i]){
                    g.setColor(Color.red);
                    g.fillOval(uno-1,dos-1,15,15);
                }
                else if(d2[i]==cercano[i]){
                    g.setColor(Color.blue);
                    g.fillOval(uno-1,dos-1,15,15);

                }
                else if(d3[i]==cercano[i]){
                    g.setColor(Color.yellow);
                    g.fillOval(uno-1,dos-1,15,15);

                }
                else  if(d4[i]==cercano[i]){
                    g.setColor(Color.pink);
                    g.fillOval(uno-1,dos-1,15,15);

                }
                else  if(d5[i]==cercano[i]){
                    g.setColor(Color.green);
                    g.fillOval(uno-1,dos-1,15,15);

                }

            }



           }



        }

}
