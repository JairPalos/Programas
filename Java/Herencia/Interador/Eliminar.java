import java.util.*;

public class Eliminar{
    public static void main(String [] Args){
      ArrayList<String>a= new ArrayList<String>();
      a.add("June");
      a.add("Irving");
      a.add("Victor");
      a.add("Bryan");
      a.add("Luis");
      a.remove(1);
      Iterator<String> j = a.iterator();
      while(j.hasNext()){
        System.out.print("Los Nombres son: " + j.next()+"\n");

      }
    }
}
