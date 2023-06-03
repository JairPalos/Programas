import java.util.*;

public class Busqueda {
public static int Busque(int array[], int dato){

  for (int i=0;i<array.length;i++){
    if(array[i]==dato)
    return i;
  }
  return -1;
}

public static void main (String [] Args){
int array []={1,2,3,4,5,6,8,7};
int dato=6;
int x=Busque(array,dato);
if (x>0)
System.out.print("El dato: "+dato+" En la posicion: "+x+"\n");
else
System.out.print("El dato no encontrado: "+x);
}


}
