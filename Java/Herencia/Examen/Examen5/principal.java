package Examen5;// se crea el paquete
import java.util.*;//se utiliza todo labibliotecas
public class principal{//se crea la clase principal

  static Scanner sc = new Scanner(System.in);//se pone el scanner global

  //Se crea un ArrayList para guardar objetos de tipo alumno.
  static ArrayList<alumno> alu = new ArrayList();// se crea el arraylis global

  //método main
  public static void main(String[] args) {// se crea la clase main
      ingresarAlumno();// se ingresan los datos de los alumnos
      boolean salir = false;//se crea el boolean para el menu
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {// si es diferente de el numero para salir
            System.out.println("\n  Menu de la escuela");// imprime el menu
            System.out.println("1) Mostrar calificaciones de los alumnos con su media");//imprime
            System.out.println("2) Mostrar  media de la Clase");//imprime
            System.out.println("3) Mostrar media de cada clase");//imprime
            System.out.println("4) Ordenamieto por Shell");//imprime
            System.out.println("5) Salir");//imprime

            try {//inicio del try

                System.out.println("Escribe una de las opciones");//imprime
                opcion = sc.nextInt();//se ingresa valor
                  System.out.println("\n");//salto de linea
                switch (opcion) {//entrada al switch
                    case 1:// en el prime caso
                        System.out.println("---Calificaciones de los  alumnos---");//imprime
                        mostrarAlumnos();//llama a mostrarAlumnos
                        break;//terniam(rompe)
                    case 2://caso 2
                        System.out.println("---Media general---");//imprime
                        System.out.println("Media: "+mediaDeLaClase());//imprime llamando a mediaDeLaClase
                        break;//termina(rompe)
                    case 3://caso 3
                          System.out.println("---Media de las Materias---");//imprime
                          System.out.println("Programacion II: "+mediaDeProgramacion());//imprime llamando a mediaDeProgramacion
                          System.out.println("Algoritmos Geneticos: "+mediaDeAlgoritmos());//imprime llamando a mediaDeAlgoritmos
                          System.out.println("Sistemas Digitales: "+mediaDeSistemas());//imprime llamando a mediaDeSistemas
                          System.out.println("Procesamiento de Imagenes: "+mediaDeProcesamiento());//imprime llamando a mediaDeProcesamiento
                          System.out.println("Arquitectura de Computadoras: "+mediaDeArquitectura());//imprime llamando a mediaDeArquitectura
                        break;//termina(rompe)
                   case 4://caso 4
                          System.out.println("Ordenado por el metodo Shell");//imprime
                          shell();// llama al metod de ordenamiento shell
                          break;//termina (rompe)
                    case 5://caso 5
                        salir = true;// si es igual
                        break;//rompe
                    default://si es diferente
                        System.out.println("Solo números entre 1 y 4");//inprime
                }//cierra
            } catch (InputMismatchException e) {//termina el try y empieza el chatch
                System.out.println("Debes insertar un número");//imprime
                sc.next();//se guarda el dato
            }//cierra
        }//cieraa
  } //fin método main


  public static void ingresarAlumno(){// se crea el metodo para ingresar los datos

      String nombre;//crea un String
      double programacionII;//se crea un double
      double algoritmoGenetico;//se crea un double
      double sistemasDigitales;//se crea un double
      double procesamiento;//se crea un double
      double arquitectura;//se crea un double

      //Variable auxiliar que contendrá la referencia a cada alumno.
      alumno aux;// se crea un ¿a variable auxiliar del objeto alumno
      int i, N;// s crean variables enteras

      //se pide por teclado el número de coches a leer
      do {//empieza el do-while
          System.out.print("Numero de alumnos:  ");//imprime
          N = sc.nextInt();//se guarda el dato
      } while (N < 0);//termina el while cual variable n menor a 0
      sc.nextLine(); //limpiar el intro

      //lectura de N alumnos
      for (i = 1; i <= N; i++) {//inicia el for hasta el numero de alumnos
          System.out.println("\nNombre " );//imprime
          nombre=sc.nextLine();//se guarda el dato
          System.out.println("  ---Calificaciones de Materias--- ");//imprime
          System.out.print("Programacion II: ");//imprime
          programacionII = sc.nextDouble();//se guarda el dato
          System.out.print("Algoritmos Geneticos: ");//imprime
          algoritmoGenetico = sc.nextDouble();//se guarda el dato
          System.out.print("Sistemas Digitales: ");//imprime
          sistemasDigitales = sc.nextDouble();//se guarda el dato
          System.out.print("Procesamiento: ");//imprime
          procesamiento = sc.nextDouble();//se guarda el dato
          System.out.print("Arquitecturas de Computadoras: ");//imprime
          arquitectura = sc.nextDouble();//se guarda el dato
          sc.nextLine(); //limpiar el intro

          aux = new alumno(); //Se crea un objeto Coche y se asigna su referencia a aux

          //se asignan valores a los atributos del nuevo objeto
          aux.setNombre(nombre);//se guarda el nombre en el set
          aux.setProgramacionII(programacionII);//se guarda la calificacion de programacionII en el set
          aux.setAlgoritmosGeneticos(algoritmoGenetico);//se guarda la calificacion de algoritmoGenetico en el set
          aux.setSistemasDigitales(sistemasDigitales);//se guarda la calificacion de sistemasDigitales en el set
          aux.setProcesamiento(procesamiento);//se guarda la calificacion de procesamiento en el set
          aux.setArquitectura(arquitectura);//se guarda la calificacion de arquitectura en el set

          //se añade el objeto al final del array
          alu.add(aux);
      }//cierra
  } //fin método leerCoches()

  public static void mostrarAlumnos(){// se crea el metodo para mostrar a los alumnos
      for(int i = 0; i< alu.size(); i++)// recorre el for con el tamaño del arreglo
          System.out.println(alu.get(i));  //se invoca el método toString de la clase Coche
  }//cierra

  public static double mediaDeLaClase(){// se crea el metodo para la media general
      double suma = 0;// se crea la variable suma que es double
      double media=0;// se crea la variable media que es double
      for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
              suma = suma + alu.get(i).mediaDelAlumno();//suma todas las media de los alumnos
      }// cierra
      media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
      return media;//regresa la media
    }//cierra
    public static double mediaDeProgramacion(){// se crea el metodo para la media de programacionII
        double suma = 0;// se crea la variable suma que es double
        double media=0;// se crea la variable media que es double
        for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
                suma = suma + alu.get(i).getProgramacionII();//suma todas las media de la clase
        }//cierra
        media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
        return media;//regresa la media
      }
    public static double mediaDeAlgoritmos(){// se crea el metodo para la media de Algoritmos
          double suma = 0;// se crea la variable suma que es double
          double media=0;// se crea la variable media que es double
          for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
                  suma = suma + alu.get(i).getAlgoritmosGeneticos();//suma todas las media de la clase
          }//cierra
          media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
          return media;//regresa la media
    }// cierra

    public static double mediaDeSistemas(){// se crea el metodo para la media de Sistemas
          double suma = 0;// se crea la variable suma que es double
          double media=0;// se crea la variable media que es double
          for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
                  suma = suma + alu.get(i).getSistemasDigitales();//suma todas las media de la clase
          }//cierra
          media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
          return media;//regresa la media
   }//cierra

   public static double mediaDeProcesamiento(){// se crea el metodo para la media de procesamiento
         double suma = 0;// se crea la variable suma que es double
         double media=0;// se crea la variable media que es double
         for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
                 suma = suma + alu.get(i).getProcesamiento();//suma todas las media de la clase
         }//cierra
         media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
         return media;//regresa la media
  }//cierra
  public static double mediaDeArquitectura(){// se crea el metodo para la media de procesamiento
        double suma = 0;// se crea la variable suma que es double
        double media=0;// se crea la variable media que es double
        for(int i = 0; i < alu.size(); i++){//recorre el arreglo del tamaño
                suma = suma + alu.get(i).getArquitectura();//suma todas las media de la clase
        }//cierra
        media= suma/alu.size();// de la suma lo divides con el tamaño del arreglo
        return media;//regresa la media
 }//cierra

 public static void shell(){// se crea el metodo shell
   final int N = alu.size();// seinicializa una variable

     int incremento = N;// se crea una variabke incremento entera
     do {//inicio del dowhile
         incremento = incremento / 2;// vadiviendo el tamaño del arreglo en 2
         for (int k = 0; k < incremento; k++) {// recorre el arreglo
             for (int i = incremento + k; i < N; i += incremento) {//lo vuelve a recorrer pero desde el incremento
                int j = i;// pasa el valor de i a j
                 double x=alu.get(j).mediaDelAlumno();// cremos variables con el numero de la media
                 double y=alu.get(j - incremento).mediaDelAlumno();//se crea ptra variable con valores diferentes

                 while (j - incremento >= 0 && x< y) {//con el while vamos a ir pasando valores

                     double tmp = x;// lo que esta en x pasa al temp
                     x= y;//lo que esta en x pasa a y
                     y= tmp;// lo que oasa a y pasa a tem
                     j -= incremento;// decremente a  j
                 }//cierra
             }//cierra
         }//cierra
     } while (incremento > 1);//si el mayor a 1 continua
     mostrarAlumnos();//llama al metodo motrar a los alumnos ya ordenados
 }//cierra

}//cierra
