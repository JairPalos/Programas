package Ventas; // se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{//se crea la clase Principal

  public static void main(String [] Args){

      Empleado e1= new Empleado();//se cre un objeto llamado Empleado
      e1.setNombreCompleto("Jair Antonio Palos Hernandez");//se utiliza el metodo setNombreCompleto de la clase  padre
      e1.setFechaNacimiento("01-01-1999");//se utiliza el metodo setFechaNacimiento de la clase  padre
      e1.setNumeroTelefonico("5536564289");//se utiliza el metodo setNumeroTelefonico de la clase  padre
      e1.setEmail("palosjair@gmail.com");//se utiliza el metodo setEmail de la clase  padre
      e1.setIdEmpleado("556465456");//se utiliza el metodo setIdEmpleado de si mismo
      e1.setSueldo(15.5);//se utilixa el metodo setSueldo  de si mismo

      System.out.println("Datos de Empleado \n");
      System.out.println("El nombre  Es:  "+ e1.getNombreCompleto());// Se imprime el dato guardado
      System.out.println("El Sueldo Es:  "+ e1.getSueldo());// Se imprime el dato guardado

      Cliente c1= new Cliente();
      c1.setNombreCompleto("Marcelo Edwin");//se utiliza el metodo setNombreCompleto de la clase  padre
      c1.setNumeroTelefonico("484564549");//se utiliza el metodo setNumeroTelefonico de la clase  padre
      c1.setFechaNacimiento("02-03-1999");//se utiliza el metodo setFechaNacimiento de la clase  padre
      c1.setEmail("marcelo@gmail.com");//se utiliza el metodo setEmail de la clase  padre
      c1.setRFC("55646545645445");//se utiliza el metodo setRFC de la clase
      c1.setCredito(156454.5);//se utiliza el metodo setCredito de la clase


      System.out.println("\n Datos del Cliente \n");
      System.out.println("El nombre  Es:  "+ c1.getNombreCompleto());// Se imprime el dato guardado
      System.out.println("El credito que tiene  Es:  "+ c1.getCredito());// Se imprime el dato guardado






  }


}
