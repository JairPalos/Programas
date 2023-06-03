import java.util.*;
public class metodos{

public static void main(String [] Args){
  Scanner x=new Scanner (System.in);//se usa el scanner para guardar
  boolean salir = false;
  int opcion;

while (!salir) {
    System.out.println("\nElige un valor para encontrar el valor en el arreglo");
    System.out.println("1. Busqueda Lineal");
    System.out.println("2. Busqueda Binaria");
    System.out.println("3. Salir");
    try {

        System.out.println("");
        opcion = x.nextInt();

        switch (opcion) {
            case 1:
            int dato;
            int[] array=pedirDatos();
            System.out.println("Introduce el dato a buscar: ");
            dato=x.nextInt();
            mostrar(array);
            System.out.println("\n");
            int b=BusqueL(array,dato);
            if (b>0)
            System.out.print("El dato: "+dato+" En la posicion: "+b+"\n");
            else
            System.out.print("El dato no encontrado: "+b);
                break;
            case 2:
            boolean salir1 = false;
            int opcion1;
            while (!salir1) {
                System.out.println("\nElige la opcion para ordenar el arreglo");
                System.out.println("1. Ordenamiento por insercion");
                System.out.println("2. Ordenamiento por burbuja");
                System.out.println("3. Ordenamiento por seleccion");
                System.out.println("4. Salir");
                try {

                    System.out.println("");
                    opcion1 = x.nextInt();

                    switch (opcion1) {
                        case 1:
                        int[] array1=pedirDatos();
                        System.out.println("Introduce el dato a buscar: ");
                        int dato1=x.nextInt();
                        mostrar(array1);
                        int [] newa= insert(array1);
                        System.out.println("Datos Ordenados: ");
                        mostrar(newa);
                        int b1=BusqueB(newa,dato1);
                        System.out.println("\n Dato encontrado en posicion: "+b1);
                        break;
                        case 2:
                        int[] array2=pedirDatos();
                        System.out.println("Introduce el dato a buscar: ");
                        int dato2=x.nextInt();
                        mostrar(array2);
                        int [] newa1=burbuja(array2) ;
                        System.out.println("Datos Ordenados: ");
                        mostrar(newa1);
                        int b2=BusqueB(newa1,dato2);
                        System.out.println("\n Dato encontrado en posicion: "+b2);
                        break;
                        case 3:
                        int[] array3=pedirDatos();
                        System.out.println("Introduce el dato a buscar: ");
                        int dato3=x.nextInt();
                        mostrar(array3);
                        int [] newa2=seleccion(array3);
                        System.out.println("Datos Ordenados: ");
                        mostrar(newa2);
                        int b3=BusqueB(newa2,dato3);
                        System.out.println("\n Dato encontrado en posicion: "+b3);
                        break;
                        case 4:
                            salir1 = true;
                        break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                } catch (InputMismatchException es) {
                    System.out.println("Debes insertar un número");
                    x.next();
                  }
                }

            case 3:
                salir = true;
                break;
            default:
                System.out.println("Solo números entre 1 y 3");
        }
    } catch (InputMismatchException es) {
        System.out.println("Debes insertar un número");
        x.next();
      }
    }
  }

  public static int BusqueL(int array[], int dato){

    for (int i=0;i<array.length;i++){
      if(array[i]==dato)
      return i;
    }
    return -1;
  }
  public static int BusqueB(int array[], int dato){
    int c,p,u,valorCentro;
    p=0;
    u=array.length-1;
    while(p<=u){
      c=(p+u)/2;
      valorCentro=array[c];
      System.out.print(" comparando a: "+dato+" con "+array[c]+ " en la posicion "+c);
      System.out.print(" \n");
      if(dato== valorCentro)
          return c;

      else if (dato<array[c]){
          u=c-1;
      }else{
          p=c+1;
      }
    }
      return -1;
  }

  public static int[] pedirDatos(){
    Scanner x=new Scanner (System.in);//se usa el scanner para guardar
    int a,e=0;
    System.out.println("Introduce la cantidad de enteros que tendra tu arreglo");
    a=x.nextInt();
    int[] A= new int[a];
    for(int i=0;i<A.length;i++){
      System.out.println("Ingresa el entero");
      e=x.nextInt();
  			A[i] = e;

    }
     return A;
  }

  public static int[] insert(int [] array) {
    for (int j = 1; j < array.length; j++) {
        int current = array[j];
        int i = j-1;
        while ((i > -1) && (array[i] > current)) {
            array[i+1] = array[i];
            i--;
        }
        array[i+1] = current;

      }
        return array;
  }
  private static int[] burbuja(int[] arreglo) {
      for (int x = 0; x < arreglo.length; x++) {
          for (int y = 0; y < arreglo.length - 1; y++) {
              int elementoActual = arreglo[y],
                      elementoSiguiente = arreglo[y + 1];
              if (elementoActual > elementoSiguiente) {
                  // Intercambiar
                  arreglo[y] = elementoSiguiente;
                  arreglo[y + 1] = elementoActual;
              }
          }
      }
      return arreglo;
  }
  public static int [] seleccion(int A[]) {
          int i, j, menor, pos, tmp;
          for (i = 0; i < A.length - 1; i++) {      // tomamos como menor el primero
                menor = A[i];                       // de los elementos que quedan por ordenar
                pos = i;                            // y guardamos su posición
                for (j = i + 1; j < A.length; j++){ // buscamos en el resto
                      if (A[j] < menor) {           // del array algún elemento
                          menor = A[j];             // menor que el actual
                          pos = j;
                      }
                }
                if (pos != i){                      // si hay alguno menor se intercambia
                    tmp = A[i];
                    A[i] = A[pos];
                    A[pos] = tmp;
                }
          }
          return A;
}
  public static void mostrar(int [] array){
    System.out.println("\nLectura de los elementos del arreglo");
    for(int k=0;k<array.length;k++){
    System.out.println("numeros["+k+"]: "+ array[k]);
    }
  }

}
