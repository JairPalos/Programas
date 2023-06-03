import java.util.*;
public class MediaClase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numAlum, i;
        double suma = 0, media;

        //Lectura del número de alumnos.
        System.out.print("Número de alumnos de la clase: ");
        numAlum = sc.nextInt();
        
        // array calificaciones calculo
        double[] calculo = new double[numAlum];
        // lee la nota de cada alumno y se guarda en el array
        System.out.println("\t ---> Calificaciones calculo <---\n");
        for (i = 0; i < calculo.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final calculo: ");
            calculo[i] = sc.nextDouble();
        }
        // array calificaciones fisica
        double[] fisica = new double[numAlum];
        // lee la nota de cada alumno y se guarda en el array
        System.out.println("\t ---> Calificaciones fisica <---\n");
        for (i = 0; i < fisica.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final fisica: ");
            fisica[i] = sc.nextDouble();
        }
        // array calificaciones algebra
        double[] algebra = new double[numAlum];
        // lee la nota de cada alumno y se guarda en el array
        System.out.println("\t ---> Calificaciones algebra <---\n");
        for (i = 0; i < algebra.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final algebra: ");
            algebra[i] = sc.nextDouble();
        }
        // array calificaciones estadistica
        double[] estadistica = new double[numAlum];
        // lee la nota de cada alumno y se guarda en el array
        System.out.println("\t ---> Calificaciones estadistica <---\n");
        for (i = 0; i < estadistica.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final estadistica: ");
            estadistica[i] = sc.nextDouble();
        }
        // array calificaciones protocolos
        double[] protocolos = new double[numAlum];
        // lee la nota de cada alumno y se guarda en el array
        System.out.println("\t ---> Calificaciones protocolos <---\n");
        for (i = 0; i < protocolos.length; i++) {
            System.out.print("Alumno " + (i + 1) + " Nota final protocolos: ");
            protocolos[i] = sc.nextDouble();
        }

        //se crea un array llamado notas de numAlumn elementos de tipo double
        double[] notas = new double[numAlum]; 
        
        //Lee la nota de cada alummo en cada materia y se guarda
        for (i = 0; i < notas.length; i++) {
            
            notas[i] =(protocolos[i] + calculo[i] + estadistica[i] + algebra[i] + fisica[i]); 
        }

        // Sumar todas las notas
        for (i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
         // Calcular la media
        media = suma / notas.length;

        // Mostrar la media
        System.out.printf("\n\tNota media del curso: %.2f %n", media);

        // Mostrar los valores superiores a la media
        System.out.println("\tListado de notas superiores a la media: ");
        for (i = 0; i < notas.length; i++) {
            if (notas[i] > media) {
                System.out.println("Alumno numero " + (i + 1)+ " Nota final: " + notas[i]);
            }
        }
        System.out.println("\n\t Ordenamiento de los alumnos por orden decreciente de notas medias individuales: ");
        int salto = 0;
        double temp = 0;
        boolean cambio;
        for(salto = (notas.length/2); salto!=0; salto/=2){
            cambio = true;
            while(cambio){
                cambio = false;
                for(i=salto;i<notas.length;i++){
                    if(notas[i-salto]>notas[i]){
                        temp = notas[i];
                        notas[i] = notas[i - salto];
                        notas[i - salto ] = temp;
                        cambio= true; 
                    }
                }
            }
        }
        for(i = 0; i<notas.length;i++){
            System.out.println(notas[i]);
        }
    }
}