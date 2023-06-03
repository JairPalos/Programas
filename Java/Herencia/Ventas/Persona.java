package Ventas;// se pone el paquete donde estan los archivos
import java.util.*;

public class Persona{

    private String nombreCompleto;// se crea el tipo de dato privado String
    private String fechaDeNacimiento;//se crea el tipo de dato privado String
    private String numTelefonico;//se crea el tipo de dato privado String
    private String email;//se crea el tipo de dato privado String

 public  String  getNombreCompleto (){// se crea el metodo getNombreCompleto
    return nombreCompleto;//Regrea el nombreCompleto
 }
 public void setNombreCompleto(String nombreCompleto ){//se crea el setNombreCompleto

    this.nombreCompleto=nombreCompleto;//el nombreCompleto es igual al nombreCompleto
 }

 public  String  getFechaNacimiento (){//se crea el getFechaNacimiento
    return fechaDeNacimiento;//regresa fechaNacimineto
 }
 public void setFechaNacimiento(String fechaNacimineto){// se crea setFechaNacimiento
    this.fechaDeNacimiento=fechaNacimineto;//la fechaNacimineto es igual a fechaNacimineto
 }

 public  String  getNumeroTelefonico (){//se crea getNumeroTelefonico
    return numTelefonico;// regresa el numTelefonico
 }
 public void setNumeroTelefonico(String numTelefonico ){//se crea setNumeroTelefonico

    this.numTelefonico=numTelefonico;//si numTelefonico es igual a numTelefonico
 }

 public  String  getEmail (){// se crea getEmail
    return email;//regresa email
 }
 public void setEmail(String email){// se crea setEmail

    this.email=email;//si email es igual a email
 }


}
