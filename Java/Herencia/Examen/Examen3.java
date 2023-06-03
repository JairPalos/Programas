import java.util.*;

public class Examen3{

    public static void main(String [] args){
    int A []= {3,13,8,25,45,23,98,58};

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
       int p=0;
       for (int j = 2; j < array.length; j++) {
           int current = array[j];
           int i = j-1;
           p=p+1;
           while ((i > -1) && (array[i] > current)) {
               array[i+1] = array[i];
               i--;
           }
           array[i+1] = current;

            System.out.println("\nPasada " +p+" :");
           for(int k=0;k<array.length;k++){
           System.out.print(" " + array[k]);
             System.out.print(" " );
           }
       }
   }

}
