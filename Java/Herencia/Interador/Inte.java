import java.util.*;

public class Inte{
    public static void main(String [] Args){
      ArrayList<Integer>a= new ArrayList<String>();
      a.add(25);
      a.add(23);
      a.add(24);
      a.add(26);
      a.add(24);
      a.remove(1);
      Iterator<String> j = a.iterator();
      while(j.hasNext()){
        System.out.print("Los Nombres son: " + j.next()+"\n");

      }
    }
}
