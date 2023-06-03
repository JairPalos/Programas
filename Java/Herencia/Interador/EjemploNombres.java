import java.util.*;

public class EjemploNombres{
    public static void main(String [] Args){
      ArrayList<String>Nombres= new ArrayList<String>();
      Nombres.add("June");
      Nombres.add("Irving");
      Nombres.add("Victor");
      Nombres.add("Bryan");
      Nombres.add("Luis");

      Iterator<String> i = Nombres.iterator();
      while(i.hasNext()){
        System.out.print("Los Nombres son: " + i.next()+"\n");

      }
    }
}
