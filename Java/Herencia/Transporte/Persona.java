package Transporte;// se pone el paquete donde estan los archivos
import java.util.*;

public  abstract class Persona{

    protected String nombre;// se crea el tipo de dato protegidoString
    protected double costo;//se crea el tipo de dato protegido String
    protected String fecha;//se crea el tipo de dato protegido String
    protected String hora;//se crea el tipo de dato protegido String


    public Persona (String nombre,double costo,String fecha,String hora ){// SE crea el contructor
        this.nombre=nombre;// se dice que el valor de la variable es el mismo
        this.costo=costo;// se dice que el valor de la variable es el mismo
        this.fecha=fecha;// se dice que el valor de la variable es el mismo
        this.hora=hora;// se dice que el valor de la variable es el mismo
    }

    public  String  getNombre (){// se crea el metodo getNombreCompleto
      return nombre;//Regrea el nombreCompleto
    }

    public  String  getFecha (){//se crea el getFechaNacimiento
      return fecha;//regresa fechaNacimineto
    }

    public  double  getCosto (){//se crea getNumeroTelefonico
      return costo;// regresa el numTelefonico
    }
    public  String  getHora (){//se crea getNumeroTelefonico
      return hora;// regresa el numTelefonico
    }

    public abstract  double generarPago();


}
