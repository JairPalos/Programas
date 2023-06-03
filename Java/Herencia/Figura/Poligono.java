package Figura;// se pone el paquete donde estan los archivos
import java.util.*;

public class Poligono{// Se  crea la clase poligono como padre

    private int numLados;// se crea el tipo de dato privado int
    private double ladoA;//se crea el tipo de dato privado  double
    private double ladoB;//se crea el tipo de dato privado  double
    public double area;
 public  int  getNumLados (){// se crea el metodo getNumLados
    return numLados;//Regrea el nombreCompleto
 }
 public void setNumLados(int nombreCompleto ){//se crea el setNumLados

    this.numLados=numLados;//el numLado es igual al numLado
 }

 public  double getLadoA (){//se crea el getLadoA
    return ladoA;//regresa ladoA
 }
 public void setLadoA(double ladoA){// se crea setLadoA
    this.ladoA=ladoA;//ladoA es igual a ladoA
 }
  public  double getLadoB (){//se crea el getLadoB
     return ladoB;//regresa ladoB
  }
  public void setLadoB(double ladoB){// se crea setLadoB
     this.ladoB=ladoB;//ladoB es igual a ladoB
  }
  public double getArea(){// se crea el get que tendra el resultado de area que regresara un double
   return (getLadoA()*getLadoB());//regresa el resultado de la operacion puesta que seria el area

  }

}
