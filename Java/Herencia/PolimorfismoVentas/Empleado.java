package PolimorfismoVentas;// se pone el aquete donde estan los archivos
import java.util.*;

public class Empleado  extends Persona{// se crea la clase persona hija Empleado de Persona

  private String idEmpleado;// Se crea el tipo de dato publico String
  private double sueldo;// se crea el tipo de dato publico double


  public Empleado (String idEmpleado,double sueldo,String nombreCompleto,String fechaDeNacimiento,String numTelefonico,String email ){// se crea el contructir
        super(nombreCompleto,fechaDeNacimiento,numTelefonico,email);// se dice que el valor de la variable es el mismo
        this.sueldo=sueldo;// se dice que el valor de la variable es el mismo
        this.idEmpleado=idEmpleado;// se dice que el valor de la variable es el mismo

  }

  public  String  getIdEmpleado (){// se crea el metodo getIdEmpleado
     return idEmpleado;// REGRESA EL idEmpleado
  }
  
  public  double  getSueldo (){//se crea el metodo getSueldo
     return sueldo;// regresa el Sueldo
  }

  @Override
  public String mostrarDatos(){// se crea el metodo para imprimir os datos

    return "\n Id Empleado: "+idEmpleado+"\n Sueldo: "+ sueldo+"\n Nombre: "+nombreCompleto+"\n Fecha de fechaNacimineto: "+fechaDeNacimiento+"\n Numero Telefonico: "+numTelefonico+"\n Email: "+email;//se  regresan los datos
 }
}
