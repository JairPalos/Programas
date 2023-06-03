package Aduana;// se pone el paquete donde estan los archivos
import java.util.*;

public class Camiones extends Vehiculo{

    public Camiones (String placas,String origen,String color,String modelo,String noSerie){// SE crea el contructor
        super(placas,origen,color,modelo,noSerie);
    }

    public double totalPago(){//se crea el metodo
      String mexico =new String("Mexico");// se crea una cadena de caracteres
      if (mexico.equals(origen)){// se compara mexico com origen
        return 80.0;//regresa 80
      }
      else{//sino
      return(80 +(80 *0.15));// regresa el valor siguiente
      }
    }
    public String mostrarDatos(){//se crea un metodo
      return " Placas: "+placas+"\n origen: "+origen+"\n Color: "+color+"\n Modelo: "+modelo+"\n Numero de Serie: "+noSerie+"\n Total a pagar:"+totalPago();
    }// se muetsra los datos

}
