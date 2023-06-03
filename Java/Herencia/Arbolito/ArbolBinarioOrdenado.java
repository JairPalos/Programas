package Arbolito;
import java.util.*;
public class ArbolBinarioOrdenado {


      Nodo raiz;
      Nodo nuevo;

      public ArbolBinarioOrdenado() {
          raiz=null;
      }

      public void insertar (int info)
      {

          nuevo = new Nodo (info);
          nuevo.info = info;
          nuevo.izq = null;
          nuevo.der = null;
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Nodo anterior = null, reco;
              reco = raiz;
              while (reco != null)
              {
                  anterior = reco;
                  if (info < reco.info)
                      reco = reco.izq;
                  else
                      reco = reco.der;
              }
              if (info < anterior.info)
                  anterior.izq = nuevo;
              else
                  anterior.der = nuevo;
          }
      }


      public void imprimirPre (Nodo reco)
      {
          if (reco != null)
          {
              System.out.print(reco.info + " ");
              imprimirPre (reco.izq);
              imprimirPre (reco.der);
          }
      }

      public void imprimirPre ()
      {
          imprimirPre (raiz);
          System.out.println();
      }

      public void imprimirEntre (Nodo reco)
      {
          if (reco != null)
          {
              imprimirEntre (reco.izq);
              System.out.print(reco.info + " ");
              imprimirEntre (reco.der);
          }
      }

      public void imprimirEntre ()
      {
          imprimirEntre (raiz);
          System.out.println();
      }


      public void imprimirPost (Nodo reco)
      {
          if (reco != null)
          {
              imprimirPost (reco.izq);
              imprimirPost (reco.der);
              System.out.print(reco.info + " ");
          }
      }


      public void imprimirPost ()
      {
          imprimirPost (raiz);
          System.out.println();
      }

     public boolean IsVacia()// se crea unia funcion para  saber si la cola esta vacia
      {
          if(raiz == null)// si el valor de la cola esta en el incio
          {
              return true;// manda verdadero que si esta vacia
          }
          else// sino
          {
              return false;// regres falso entendnendo que tine datos
          }
      }
      public boolean borrar(int d) {
        Nodo auxiliar = raiz;
        Nodo padre=raiz;
        boolean esHijoIzq=true;
        while (auxiliar.info!=d){
          padre=auxiliar;
          if(d<auxiliar.info){
            esHijoIzq=true;
            auxiliar=auxiliar.izq;
          }else{
            esHijoIzq=false;
              auxiliar=auxiliar.der;
          }if(auxiliar ==null){
            return false;
          }
        }//fin del while
        if(auxiliar.izq==null && auxiliar.der ==null){
          if(auxiliar==raiz){
            raiz=null;
          }else if(esHijoIzq){
              padre.izq=null;
          }else{
            padre.der=null;
          }
        }else if(auxiliar.der==null){
          if(auxiliar==raiz){
            raiz=auxiliar.izq;
          }else if(esHijoIzq){
              padre.izq=auxiliar.izq;
          }else{
            padre.der=auxiliar.izq;
          }
        }else if(auxiliar.izq==null){
          if(auxiliar==raiz){
            raiz=auxiliar.der;
          }else if(esHijoIzq){
              padre.izq=auxiliar.der;
          }else{
            padre.der=auxiliar.der;
          }
        }else{
          Nodo reemplazo=obtenerNodoReemplazo(auxiliar);
          if(auxiliar==raiz){
            raiz=reemplazo;
          }else if(esHijoIzq){
            padre.izq=reemplazo;
          }else{
            padre.der=reemplazo;
          }
          reemplazo.izq=auxiliar.izq;
        }
        return true;
    }

    //metodo encargado de devolvernos el nodo reemplazo
    public Nodo obtenerNodoReemplazo(Nodo nodoReem){
      Nodo reemplazarPadre=nodoReem;
      Nodo reemplazo=nodoReem;
      Nodo auxiliar=nodoReem.der;
      while(auxiliar!=null){
        reemplazarPadre=reemplazo;
        reemplazo=auxiliar;
        auxiliar=auxiliar.izq;
      }
      if(reemplazo!=nodoReem.der){
        reemplazarPadre.izq=reemplazo.der;
        reemplazo.der=nodoReem.der;
      }
      System.out.println("El nodo reemplazo es:"+reemplazo);
      return reemplazo;
    }
}
