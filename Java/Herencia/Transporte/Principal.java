package Transporte; // se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{//se crea la clase Principal

  public static void main(String [] Args){
    Scanner x=new Scanner (System.in);//se usa el scanner para guardar
    String a,b,d,e,f;
    double c;
    boolean salir = false;
    int opcion;
    System.out.println("\n---------------Datos de la persona---------");

    System.out.println("Ingresa el  Nombre:");
    b= x.nextLine();//se guarda el origne
    System.out.println("Ingresa el Costo:");
    c= x.nextDouble();// guarda el color
    System.out.println("Ingresa el Fecha:");
    d= x.nextLine();//se guarda la marca
    d= x.nextLine();//se guarda la marca
    System.out.println("Ingresa el Hora:");
    e= x.nextLine();
    System.out.println("Ingresa la Numero de Folio:");
    a= x.nextLine();//se guarda la placa
    System.out.println("Ingresa la Vigencia:");
    f= x.nextLine();//se guarda la placa




    while (!salir) {
        System.out.println("\nElije el Vehiculo");
        System.out.println("1. Tercera Edad");
        System.out.println("2. Profesor");
        System.out.println("3. Estuduante");
        System.out.println("4. Salir");


        try {

            System.out.println("Escribe una de las opciones");
            opcion = x.nextInt();

            switch (opcion) {
                case 1:
                  System.out.println("\n---------------Datos de la Perosna de Tercera Edad---------");
                  TerceraEdad ter = new TerceraEdad(a,b,c,d,e);
                  System.out.println(ter.mostrarDatos()+"\n");

                    break;
                case 2:
                  System.out.println("---------------Datos del Profesor---------");
                  Profesor pro = new Profesor(a,f,b,c,d,e);
                  System.out.println(pro.mostrarDatos()+"\n");
                    break;
                case 3:
                  System.out.println("---------------Datos del Estudiante---------");
                  Estudiante es = new Estudiante(a,f,b,c,d,e);
                  System.out.println(es.mostrarDatos()+"\n");
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        } catch (InputMismatchException es) {
            System.out.println("Debes insertar un número");
            x.next();
        }
      }
    }
  }
