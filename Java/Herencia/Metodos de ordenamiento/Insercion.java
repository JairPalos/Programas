import java.util.*;

public class Insercion{

    public static void main(String [] args){
    int[] A= new int[8];
    for(int i=0;i<A.length;i++){
  			A[i] = (int) (Math.random()*20)+1;
          }
          System.out.println("\nLos numeros sin arreglo: \n");
          mostrarResultados(A);
          insertt(A);
          System.out.println("\n\n Los numeros con arreglo: \n");
          mostrarResultados(A);
    }
    public static void mostrarResultados(int [] array) {
        for(int k=0;k<array.length;k++){
        System.out.print(" " + array[k]);
        }
      }

     public static void insertt(int [] array) {
       for (int j = 1; j < array.length; j++) {
           int current = array[j];
           int i = j-1;
           while ((i > -1) && (array[i] > current)) {
               array[i+1] = array[i];
               i--;
           }
           array[i+1] = current;
            System.out.println("\nOrdenando \n" );
           for(int k=0;k<array.length;k++){
           System.out.print(" " + array[k]);
             System.out.print(" " );
           }
       }
   }

}
