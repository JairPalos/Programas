package Transporte;// se pone el paquete donde estan los archivos
import java.util.*;

public class Estudiante extends Persona{
    private  String noDeFolio;
    private  String vigencia;

    public Estudiante (String noDeFolio,String vigencia, String nombre,double costo,String fecha,String hora ){// SE crea el contructor
        super(nombre,costo,fecha,hora);
        this.noDeFolio =noDeFolio;
        this.vigencia= vigencia;
    }
    public  String  getNoDeFolio (){// se crea el metodo getNombreCompleto
      return noDeFolio;//Regrea el nombreCompleto
    }

    public  String  getVigencia (){// se crea el metodo getNombreCompleto
      return vigencia;//Regrea el nombreCompleto
    }

    public double generarPago(){
      return(costo -(costo *0.35));
    }
    public String mostrarDatos(){
      return " No.Folio: "+noDeFolio+"\n Vigencia: "+vigencia+"\n Nombre: "+nombre+"\n Cosoto: "+costo+"\n Fecha: "+fecha+"\n Hora: "+hora+"\n Total a pagar:"+generarPago();
    }

}
