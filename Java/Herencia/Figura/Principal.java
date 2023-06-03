package Figura;// se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{
  public static void main(String [] Args){
      Scanner x=new Scanner (System.in);//se usa el scanner para guardar
      double a,b,c;// se utilizan variables para guarda el dato del usuario

      System.out.println("Ingresa el valor de lado A del Rectangulo:");
      a= x.nextDouble();//se guarda un Numero del lado A
      System.out.println("Ingresa el valor de lado B del Rectangulo:");
      b= x.nextDouble();//se guarda un Numero del lado C
      System.out.println("Ingresa el valor del los lados del cuadrado:");
      c= x.nextDouble();//Como es un cuadrado solo se pide un numero, ya que los lados son iguales y seguada en c

      Rectangulo r1= new Rectangulo();//se crea un objeto llamado Rectangulo
      r1.setLadoA(a);//se utiliza el metodo setLadoA de la clase  padre
      r1.setLadoB(b);//se utiliza el metodo setLadoB de la clase  padre
      System.out.println("Datos del Rectangulo........ \n ");
      System.out.println("El Perimetro es:  "+ r1.getPerimetro());// Se imprime el  resultado de Perimetro
      System.out.println("El Area es:  "+ r1.getArea());// Se imprime el resultado del Area


      Cuadrado c1= new Cuadrado();//se crea un objeto llamado Rectangulo
      c1.setLadoA(c);//se utiliza el metodo setLadoA de la clase  padre
      c1.setLadoB(c);//se utiliza el metodo setLadoB de la clase  padre
      System.out.println(" \nDatos del Cuadrado........  \n");
      System.out.println("El Perimetro es:  "+ c1.getPerimetro());// Se imprime el  resultado de Perimetro
      System.out.println("El Area es:  "+ c1.getArea());// Se imprime el resultado del Area

  }

}
