package Ventas;// se pone el paquete donde estan los archivos
import java.util.*;

public class Cliente extends Persona{

  public String RFC;// se crea el tipo de dato string rfc
  public double credito;//se crea el tipo de double cretido

  public  String  getRFC (){// se crea el metodo getRFC
     return RFC;//segresa el Rfc
  }
  public  void setRFC(String RFC ){// se crea ek metodo setRFC

     this.RFC=RFC;//si RFC es igual RFC
  }

  public  double  getCredito (){//se crea el metodo getCredito
     return credito;// regresa el credito
  }
  public void setCredito(double credito ){// se crea el metodo setCredito
     this.credito=credito;//si el credito es igual a credito
  }


}
