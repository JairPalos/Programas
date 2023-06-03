package Aduana; // se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{//se crea la clase Principal

  public static void main(String [] Args){

    Scanner x=new Scanner (System.in);//se usa el scanner para guardar
    String a,b,c,d,e;
    boolean salir = false;
    int opcion; //Guardaremos la opcion del usuario

    System.out.println("\n---------------Datos del Vehiculo---------");
    System.out.println("Ingresa la placa:");
    a= x.nextLine();//se guarda la placa
    System.out.println("Ingresa el origen:");
    b= x.nextLine();//se guarda el origne
    System.out.println("Ingresa el color:");
    c= x.nextLine();// guarda el color
    System.out.println("Ingresa el Marca:");
    d= x.nextLine();//se guarda la marca
    System.out.println("Ingresa el Numero de Serie:");
    e= x.nextLine();



       while (!salir) {
           System.out.println("\nElije el Vehiculo");
           System.out.println("1. Auto Compacto");
           System.out.println("2. Auto Familiar");
           System.out.println("3. Suv");
           System.out.println("4. Pickup");
           System.out.println("5. Autobus Publico");
           System.out.println("6. Autobus Privado Turismo");
            System.out.println("7. Camiones");
           System.out.println("8. Salir");

           try {

               System.out.println("Escribe una de las opciones");
               opcion = x.nextInt();

               switch (opcion) {
                   case 1:
                      System.out.println("\n---------------Datos del Auto Compacto---------");
                      vCompactos com= new vCompactos(a,b,c,d,e);
                      System.out.println(com.mostrarDatos()+"\n");
                       break;
                   case 2:
                      System.out.println("---------------Datos del Auto Familiar---------");
                      Familiares fam= new Familiares(a,b,c,d,e);
                      System.out.println(fam.mostrarDatos()+"\n");
                       break;
                   case 3:
                      System.out.println("---------------Datos de la Suv---------");
                      Suv su= new Suv(a,b,c,d,e);
                      System.out.println(su.mostrarDatos()+"\n");
                       break;
                   case 4:
                      System.out.println("\n---------------Datos de la Pickup---------");
                      Pickup pi= new Pickup(a,b,c,d,e);
                      System.out.println(pi.mostrarDatos()+"\n");

                        break;
                   case 5:
                      System.out.println("---------------Datos del Autobos Publico---------");
                      AutobusP aup= new AutobusP(a,b,c,d,e);
                      System.out.println(aup.mostrarDatos()+"\n");

                        break;
                   case 6:
                      System.out.println("---------------Datos del Autobus Pirvado de Turismo---------");
                      AutobusT aut= new AutobusT(a,b,c,d,e);
                      System.out.println(aut.mostrarDatos()+"\n");

                        break;
                   case 7:
                      System.out.println("---------------Datos del Camion---------");
                      Camiones cam= new Camiones(a,b,c,d,e);
                      System.out.println(cam.mostrarDatos()+"\n");
                        break;

                   case 8:
                       salir = true;
                       break;
                   default:
                       System.out.println("Solo números entre 1 y 8");
               }
           } catch (InputMismatchException es) {
               System.out.println("Debes insertar un número");
               x.next();
           }
       }

   }
}
