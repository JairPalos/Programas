package Transporte;// se pone el paquete donde estan los archivos
import java.util.*;

public class TerceraEdad extends Persona{

    private  String noDeFolio;

    public TerceraEdad (String noDeFolio, String nombre,double costo,String fecha,String hora ){// SE crea el contructor
          super(nombre,costo,fecha,hora);
          this.noDeFolio =noDeFolio;
        }
    public  String  getNoDeFolio (){// se crea el metodo getNombreCompleto
      return noDeFolio;//Regrea el nombreCompleto
    }

    public double generarPago(){

      return(costo -(costo *0.50));
    }

    public String mostrarDatos(){
      return " No.Folio: "+noDeFolio+"\n Nombre: "+nombre+"\n Cosoto: "+costo+"\n Fecha: "+fecha+"\n Hora: "+hora+"\n Total a pagar:"+generarPago();
    }

}
