import java.util.*;

public class Bbinaria {

    public static int Busqueda(int array[], int dato){
      int c,p,u,valorCentro;
      p=0;
      u=array.length-1;
      while(p<=u){
        c=(p+u)/2;
        valorCentro=array[c];
        System.out.print(" comparando a: "+dato+" con "+array[c]+ " en la posicion "+c);
        System.out.print(" \n");
        if(dato== valorCentro)
            return c;

        else if (dato<array[c]){
            u=c-1;
        }else{
            p=c+1;
        }
      }
        return -1;
    }

    public static void main(String [] Args){
      int array []={2,4,6,8,10,11,13,17,20,30,55};
      int dato=55;
      int x=Busqueda(array,dato);
      System.out.println("\n Dato encontrado en posicion: "+x);
    }


}
