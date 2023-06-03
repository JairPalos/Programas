package Arbolito;
public class Nodo
  {
    int info;
    Nodo izq, der;

  	public Nodo(int in){// se crea el constructor
  		info=in;// el dato lo para a la variable datos
  		izq=null;//la variable siguiente lo limpia
      der=null;
  	}// fin del constructor
  }
