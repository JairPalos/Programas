import java.util.*;

public class Calcular{

    public static void main(String [] args){
      ArrayList<Integer>Numeros= new ArrayList<Integer>();
      double media=0.0,suma=0.0;
      Numeros=ingresarValores(Numeros);
      suma=realizarSuma(Numeros);
      media=realizarMedia(Numeros);
      mostrarResultados(Numeros,suma,media);
      }

    public static void mostrarResultados(ArrayList<Integer> n,double s,double m){
      Iterator<Integer> j = n.iterator();
      System.out.print("\nDatos ingresados: "+"\n");
      while(j.hasNext()){
      System.out.print(j.next()+" ");
      }
      System.out.println("\n\nLa suma es: " + s);
      System.out.println("\nLa Media es: " + m);
      System.out.println("\nNumeros mayores a la media: ");
      for (int i=0;i<n.size();i++) {
          if(n.get(i)>m){
            System.out.print(n.get(i)+" ");
          }
      }
    }

    public static  ArrayList<Integer> ingresarValores(ArrayList<Integer> n){
      Scanner x=new Scanner (System.in);//se usa el scanner para guardar
      int n1,c=0;
      do{
      c = c+1;
      System.out.println("Ingresa un numero:");
      n1=x.nextInt();
      n.add(n1);
      }while(n1!=57);
      n.remove(c-1);
      return n;
    }
    public static double realizarSuma(ArrayList<Integer> n){
      Iterator<Integer> j = n.iterator();
      double suma=0.0;
      while(j.hasNext()) {
      suma = suma + (double) j.next();
      }
      return suma;
    }

    public static double realizarMedia(ArrayList<Integer> n){
      Iterator<Integer> j = n.iterator();
      double suma=0,t=0;
      double media=0.0;
      while(j.hasNext()) {
      suma = suma + (double) j.next();
      }
      t=n.size();
      media=suma/t;
      return media;
    }
}
