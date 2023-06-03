package Aduana;// se pone el paquete donde estan los archivos
import java.util.*;

public  abstract class Vehiculo{

    protected String placas;// se crea el tipo de dato protegidoString
    protected String origen;//se crea el tipo de dato protegido String
    protected String color;//se crea el tipo de dato protegido String
    protected String modelo;//se crea el tipo de dato protegido String
    protected String noSerie;//se crea el tipo de dato protegido String


    public Vehiculo (String placas,String origen,String color,String modelo,String noSerie){// SE crea el contructor
        this.placas=placas;// se dice que el valor de la variable es el mismo
        this.origen=origen;// se dice que el valor de la variable es el mismo
        this.color=color;// se dice que el valor de la variable es el mismo
        this.modelo=modelo;// se dice que el valor de la variable es el mismo
        this.noSerie=noSerie;// se dice que el valor de la variable es el mismo
    }

    public  String  getPlacas (){// se crea el metodo getPlacas
      return placas;//Regrea la placas
    }

    public  String  getOrigen (){//se crea el getOrigen
      return origen;//regresa origen
    }
    public  String  getColor(){//se crea getColor
      return color;// regresa el Color
    }
    public  String  getModelo (){//se crea el getModelo
      return modelo;//regresa modelo
    }
    public  String  getNoSerie(){//se crea getNoSerie
      return noSerie;// regresa el noSerie
    }
    public abstract  double totalPago();
}
