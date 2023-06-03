import java.util.*;
public class Ruleta{// se crea un clase
   public static void main(String [] args){// Se crea el main
     Scanner x=new Scanner (System.in);
    double promedio,num=0, suma=0,cont=0, mayor=0, menor=0;//SE inicializan las variables
     do{//empieza el ciclo for
        System.out.println("Ingresa el numero");//se pide un numero al usuario
        num= x.nextDouble();//se guarda un Numero
        suma=suma+num;//se guarda el valor de num e suma
        if (num > mayor) {//si el numero es mayor a numero que este en la variable mayor
				mayor = num; // se guarda el valor de num en mayor
			   }
         if (menor ==0 ) {// si el numero valor es igual a cero
 				 menor= num;// se guarda el valor de num en menor
       }else  if(num < menor && num != 0){//si el numero que esta en la variable menor el menor y diferente de cero
            menor= num;//se guarda el valor de num en menor
 			   }
        cont=cont+1;// se hace un contador
     }while(num!=0);// El ciclo continua ya que son diferentes a 0 y termina hasta que sea cero
     System.out.println("La suma es:"+ suma);// se imprime suma
     System.out.println("Cantidad de Numero: "+ (cont-1));// se imprime el contador
     promedio = suma/(cont-1);// se hace la operacion de promerio entre suma y contador
     System.out.println("El promedio es:"+ promedio);//se muestra el pro,promedio
     System.out.println("El mayor es:"+ mayor);//se muestra el numero mayi
     System.out.println("El menor es:"+ menor);//se muestra el numero menor
   }

}
