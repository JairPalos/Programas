import java.util.*;// Bibliotecas a utilizar

public class Examen2{// se crea la clase Examen2


public static void main(String[] args){// se crea el main
		String arraycar[]={"6","9","13","6","11","7","13","9","5","7"};// se crea el arreglo
		System.out.println("   Arreglo Incial   \n");
    for(int l=0;l<arraycar.length;l++){// for sirve para recorrer el arreglo
      System.out.print(arraycar[l]+" ");// imprime los datos del arreglo
    }//cierra el for
		for(int i=0;i<arraycar.length;i++){//recorrer el arreglo
			for(int j=0;j<arraycar.length-1;j++){//
				if(i!=j){// si son direfentes
					if(arraycar[i]==arraycar[j]){// si son iguales
						arraycar[i]="";// elimina el sobrante
					}
				}
			}
		}
      System.out.print("\n ");//impime un salto de linea
		// mostramos unicamente los que tienen valor
		int n=arraycar.length;//le damos el valor del tamaño del arreglo
		System.out.println("  Arreglo Corregido   \n");//imprimimos
		for (int k=0;k<=n-1;k++){//se recorre el arreglo
			if(arraycar[k]!=""){//la comparatica si el diferente a nulo
				System.out.print(arraycar[k]+" ");//que imprima
			}
		}
	}
}
