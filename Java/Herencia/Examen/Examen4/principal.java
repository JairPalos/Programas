package Examen4;// se crea el paquete
import java.util.*;//se utiliza todo labibliotecas
public class principal{//se crea la clase principal

  static Scanner sc = new Scanner(System.in);//se pone el scanner global
  static int conta=0;
  //Se crea un ArrayList para guardar objetos de tipo alumno.
  static ArrayList<dato> fech = new ArrayList();// se crea el arraylis global

  //método main
  public static void main(String[] args) {// se crea la clase main
      ingresarDatos();// se ingresan los datos de los alumnos
      System.out.println("------------------");
      mostrarDatos();
      System.out.println("------------------");
      eliminarIguales();
      System.out.println("------------------");
      mostrarDatos();

  } //fin método main

  public static void ingresarDatos(){// se crea el metodo para ingresar los datos
      int dia;//se crea una variable de tipo int
      int mes;//se crea una variable de tipo int
      int ano;//se crea una variable de tipo int
      int cuenta;//se crea una variable de tipo int

      //Variable auxiliar que contendrá la referencia a cada alumno.
      dato aux;// se crea un ¿a variable auxiliar del objeto alumno
      int i, N;// s crean variables enteras

      //se pide por teclado el número de coches a leer
      do {//empieza el do-while
          System.out.print("Numero de datos a introducir:  ");//imprime
          N = sc.nextInt();//se guarda el dato
      } while (N < 0);//termina el while cual variable n menor a 0
      sc.nextLine(); //limpiar el intro

      //lectura de N alumnos
      for (i = 1; i <= N; i++) {//inicia el for hasta el numero de alumnos
          System.out.print("Ano: ");//imprime
          ano = sc.nextInt();//se guarda el dato
          System.out.print("Mes: ");//imprime
          mes = sc.nextInt();//se guarda el dato
          System.out.println("Dia: " );//imprime
          dia=sc.nextInt();//se guarda el dato
          System.out.print("Numero de Cuneta: ");//imprime
          cuenta = sc.nextInt();//se guarda el dato
          sc.nextLine(); //limpiar el intro

          aux = new dato(); //Se crea un objeto Coche y se asigna su referencia a aux
          conta=conta+1;
          //se asignan valores a los atributos del nuevo objeto
          aux.setAno(ano);//se guarda el año en el set
          aux.setCuenta(cuenta);//se guarda el numero de cuenta en el set
          if(mes>0 && mes<=12){
          aux.setMes(mes);//se guarda el mes en el set
          }
          else{
            System.out.println("\nEl mes es incorrecto. " );//imprime
            System.out.println("\nIngrese bien el mes. " );//imprime
            mes=sc.nextInt();//se guarda el dato
            aux.setMes(mes);//se guarda el dia en el set
          }
          if(dia>0 && dia<=31){
          aux.setDia(dia);//se guarda el dia en el set
          }
          else{
            System.out.println("\nEl dia es incorrecto. " );//imprime
            System.out.println("\nIngrese bien el dia. " );//imprime
            dia=sc.nextInt();//se guarda el dato
            aux.setDia(dia);//se guarda el dia en el set
          }
          //se añade el objeto al final del array
          fech.add(aux);
      }//cierra
  } //fin método leerCoches()

  public static void mostrarDatos(){// se crea el metodo para mostrar a los alumnos
      System.out.println("Se muestran los datos: ");
      for(int i = 0; i< fech.size(); i++)// recorre el for con el tamaño del arreglo
          System.out.println(fech.get(i));  //se invoca el método toString de la clase Coche
  }//cierra
  public static void eliminarIguales(){// se crea el metodo para elimimar los numero de cuenta repetidos
      System.out.println("Revisando si hay datos repetidos");//imprime
      dato igual = fech.get(0);//toma como referencia el primer dato
      for(int i = 1; i < fech.size(); i++){//recorre el arreglo
          if(fech.get(i).getCuneta() == igual.getCuneta()){//compara los numeros
            System.out.println("Hay numeros de cuentas repetidos, se procede a eliminar uno");//imprime
            fech.remove(i);//elimina
          }//cierra
      }//cierra
        System.out.println("Ya no hay datos repetidos");//imprime
  }//cierra

/*  public static void quicksort(ArrayList<dato> fech, int izq, int der) {

    int pivote=fech.get(0).Orde(); // tomamos primer elemento como pivote
    int i=izq;         // i realiza la búsqueda de izquierda a derecha
    int j=der;         // j realiza la búsqueda de derecha a izquierda
    int aux,x,y,z;
    x=fech.get(i).Orde();
    y=fech.get(j).Orde();
    z=fech.get(izq).Orde();
    while(i < j){                          // mientras no se crucen las búsquedas
       while(x <= pivote && i < j) i++; // busca elemento mayor que pivote
       while(y > pivote) j--;           // busca elemento menor que pivote
       if (i < j) {                        // si no se han cruzado
           aux= x;                      // los intercambia
           x=y;
           y=aux;
       }
     }

     z=y;      // se coloca el pivote en su lugar de forma que tendremos
     y=pivote;      // los menores a su izquierda y los mayores a su derecha

     if(izq < j-1)
        quicksort(fech,izq,j-1);          // ordenamos subarray izquierdo
     if(j+1 < der)
        quicksort(fech,j+1,der);          // ordenamos subarray derecho

  }
*/


}//cierra
