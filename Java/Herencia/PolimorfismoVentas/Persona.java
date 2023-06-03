package PolimorfismoVentas;// se pone el paquete donde estan los archivos
import java.util.*;

public class Persona{

    protected String nombreCompleto;// se crea el tipo de dato protegidoString
    protected String fechaDeNacimiento;//se crea el tipo de dato protegido String
    protected String numTelefonico;//se crea el tipo de dato protegido String
    protected String email;//se crea el tipo de dato protegido String


 public Persona (String nombreCompleto,String fechaDeNacimiento,String numTelefonico,String email ){// SE crea el contructor
        this.nombreCompleto=nombreCompleto;// se dice que el valor de la variable es el mismo
        this.fechaDeNacimiento=fechaDeNacimiento;// se dice que el valor de la variable es el mismo
        this.numTelefonico=numTelefonico;// se dice que el valor de la variable es el mismo
        this.email=email;// se dice que el valor de la variable es el mismo
  }


 public  String  getNombreCompleto (){// se crea el metodo getNombreCompleto
    return nombreCompleto;//Regrea el nombreCompleto
 }
 
 public  String  getFechaNacimiento (){//se crea el getFechaNacimiento
    return fechaDeNacimiento;//regresa fechaNacimineto
 }
 
 public  String  getNumeroTelefonico (){//se crea getNumeroTelefonico
    return numTelefonico;// regresa el numTelefonico
 }

 public  String  getEmail (){// se crea getEmail
    return email;//regresa email
 }

 public String mostrarDatos(){// SE crea el metodo crear datos para imprimir los valors

    return " Nombre: "+nombreCompleto+"\n Fecha de fechaNacimineto: "+fechaDeNacimiento+"\n Numero Telefonico: "+numTelefonico+"\n Email: "+email;//se  regresan los datos
 } 

}
