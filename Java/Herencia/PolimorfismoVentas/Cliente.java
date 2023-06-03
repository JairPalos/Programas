package PolimorfismoVentas;// se pone el paquete donde estan los archivos
import java.util.*;

public class Cliente extends Persona{

 


  private String RFC;// se crea el tipo de dato string rfc
  private double credito;//se crea el tipo de double cretido

 
  public Cliente (String RFC, double credito, String nombreCompleto,String fechaDeNacimiento,String numTelefonico,String email ){
        
        super(nombreCompleto,fechaDeNacimiento,numTelefonico,email);
        this.RFC=RFC;
        this.credito=credito;

  }


  public  String  getRFC (){// se crea el metodo getRFC
     return RFC;//segresa el Rfc
  }
 
  public  double  getCredito (){//se crea el metodo getCredito
     return credito;// regresa el credito
  }

  @Override
  public String mostrarDatos(){

    return "\n RFC: "+RFC+"\n Credito: "+ credito+"\n Nombre: "+nombreCompleto+"\n Fecha de fechaNacimineto: "+fechaDeNacimiento+"\n Numero Telefonico: "+numTelefonico+"\n Email: "+email;
 }
 

}
