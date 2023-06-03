import java.util.*;


public class ICM{// se crea un clase
   public static void main(String [] args){
     Scanner x=new Scanner (System.in);
     double p,e,icm;// se declaran la variables p=peso, e?estatuta Y IMC

     System.out.println("Ingresa el peso (Kg): ");// se le pide al usuario el peso
     p= x.nextDouble();// se guarda en la variable p
     System.out.println("Ingresa el estatura (m):");// se pide  al usuario la estatura
     e= x.nextDouble();// se guarda en la variable e

     icm= p/(e*e);// en IMC se guarna la operacion entre peso y estatura

      System.out.println("El ICM es :"+ icm);//se Muesa el resultado en IMC

      if(icm<= 18.5){// si el resultado el menor de 18.5
        System.out.println("Bajo peso");// Muestra que es Bajo pedo
      }
      else if  (icm > 18.5 && icm <= 24.99){//Si es mayor a 18.5 y mayor o igual a 24.9
        System.out.println("Normal");// Muestra que es normal
      }
      else if  (icm>= 25 && icm <= 29.99){//Si es mayor a 25 y mayor o igual a 29.9
        System.out.println("Sobre peso");// Muestra que es sobre peso
      }
      else if (icm>= 30){// Si es mayor o igual a 30
        System.out.println("Obesidad");//,uestra que es Obseidad
      }
   }


}
