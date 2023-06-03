package Ventas;// se pone el paquete donde estan los archivos
import java.util.*;

public class Empleado  extends Persona{

  public String idEmpleado;// Se crea el tipo de dato publico String
  public double sueldo;// se crea el tipo de dato publico double

  public  String  getIdEmpleado (){// se crea el metodo getIdEmpleado
     return idEmpleado;// REGRESA EL idEmpleado
  }
  public  void setIdEmpleado(String idEmpleado ){//  se crea el metodo setIdEmpleado

     this.idEmpleado=idEmpleado;//el idEmpleado es igual a idEmpleado
  }

  public  double  getSueldo (){//se crea el metodo getSueldo
     return sueldo;// regresa el Sueldo
  }
  public void setSueldo(double sueldo ){// se crea el metrodo setSueldo
     this.sueldo=sueldo;//el sueldo es igual a sueldo
  }

}
