package PolimorfismoVentas; // se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{//se crea la clase Principal

  public static void main(String [] Args){

      Persona personas [ ]=new Persona[3];// se crea un arrego de 3
      personas[0]=new Persona("Juan Perez Lopez","01/04/1999","5536564289","juan.perez17@gmail.com");// se ,eten los datos en la clase
      personas[1]=new Cliente("AAGB030407LMS",1000,"Alvarez Garcia Benardo","03/04/1998","1234567895","Alvarez.17@hotmail.com");// se ,eten los datos en la clase
      personas[2]=new Empleado("123455",3000,"Arturo Francisco Gomez Juarez","09/231995","76543214","Gomez_Artu@hormail.com");// se ,eten los datos en la clase

      for(Persona miPerso:personas){// se hace el for recorriendo el arreglo de 3
            System.out.println(miPerso.mostrarDatos());//se mestran los datos
            System.out.println("");//se hace los satos de linea
      }


  }


}
