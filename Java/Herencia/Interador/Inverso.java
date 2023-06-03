import java.util.*;

public class Inverso{
    public static void main(String [] Args){
      LinkedList<String>a= new LinkedList<String>();
      a.add("June");
      a.add("Irving");
      a.add("Victor");
      a.add("Bryan");
      a.add("Luis");

      Iterator<String> j = a.descendingIterator();
      while(j.hasNext()){
        System.out.print("Los Nombres son: " + j.next()+"\n");

      }
    }
}
