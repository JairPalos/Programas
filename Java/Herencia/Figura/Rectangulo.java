package Figura;// se pone el paquete donde estan los archivos
import java.util.*;

public class Rectangulo extends Poligono{// Se crea la clase Rectangulo a partir  de  Poligo como padre
  public double getPerimetro(){// se crea el get perimetro que tendra el resultado
    return (getLadoA()*2 + getLadoB()*2);//regresa el resultado  que seria el Perimetro
  }//llave del perimetro

}//llave de la clase
