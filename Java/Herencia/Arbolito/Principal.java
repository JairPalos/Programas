package Arbolito;// se pone el paquete donde estan los archivos
import java.util.*;

public class Principal{
  public static void main (String [] ar)
  {
      boolean salir = false;
      int opcion,a,n; //Guardaremos la opcion del usuario

      ArbolBinarioOrdenado abo = new ArbolBinarioOrdenado ();
      Scanner x=new Scanner (System.in);//se usa el scanner para guardar


      while (!salir) {
          System.out.println("\nArbolito");
          System.out.println("1. Ingresar dato al arbol");
          System.out.println("2. Por pre-orden");
          System.out.println("3. Por int-orden");
          System.out.println("4. Por post-orden");
          System.out.println("5. Esta vacio el arbol");
          System.out.println("6. Eliminar un nodo");
          System.out.println("7. Salir");
          try {
            System.out.println("Escribe una de las opciones");
            opcion = x.nextInt();

          switch (opcion) {
                case 1:
                    System.out.println("Ingresar Valor del nodo:");
                    a= x.nextInt();//se guarda un Numero del lado A
                    abo.insertar (a);
                    break;
                case 2:
                  System.out.println ("Impresion pre-orden: ");
                  abo.imprimirPre ();
                  break;
                case 3:
                  System.out.println ("Impresion in-orden: ");
                  abo.imprimirEntre ();
                  break;
                case 4:
                  System.out.println ("Impresion post-orden: ");
                  abo.imprimirPost ();
                  break;
                case 5:
                  if(!abo.IsVacia()){
                      System.out.println ("El arbol no esta vacio ");
                    }else{
                      System.out.println ("El arbol  esta vacio ");
                    }
                    break;
                case 6:
                    System.out.println("Ingresar el nodo a eliminar:");
                    n= x.nextInt();//se guarda un Numero del lado A
                    if(abo.borrar(n)==false){
                        System.out.println("El nodo no se encuentra en el arbol");
                    }else{
                      System.out.println("El nodo ha sido eliminado del arbol");
                    }
                    break;
                case 7:
                      salir = true;
                      break;
                  default:
                      System.out.println("Solo números entre 1 y 7");
              }
          } catch (InputMismatchException es) {
              System.out.println("Debes insertar un número");
              x.next();
            }
          }
        }


}
