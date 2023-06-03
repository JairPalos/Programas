package Examen4;// el paquete de las clases
public class dato {// se crea la clase alumno

    private int dia;// se crea una variable de tipo entero
    private int mes;// se crea una variable de tipo entero
    private int ano;// se crea una variable de tipo entero
    private int cuenta;// se crea una variable de tipo entero



    public int getDia() {// inicia del get
        return dia;//regresa la variable
    }//cierra

    public void setDia(int dia) {//inicia el set
        this.dia = dia;//varibale es iagual a si misma
    }//cierra
    public int getMes() {// inicia del get
        return mes;//regresa la variable
    }//cierra

    public void setMes(int mes) {//inicia el set
        this.mes = mes;//varibale es iagual a si misma
    }//cierra
    public int getAno() {// inicia del get
        return ano;//regresa la variable
    }//cierra

    public void setAno(int ano) {//inicia el set
        this.ano = ano;//varibale es iagual a si misma
    }//cierra
    public int getCuneta() {// inicia del get
        return cuenta;//regresa la variable
    }//cierra

    public void setCuenta(int cuenta) {//inicia el set
        this.cuenta = cuenta;//varibale es iagual a si misma
    }//cierra

    public int  Orde(){//inicia el metodo para clacular la media
      int suma=0;
      suma=dia+mes+ano;
      return suma;
    }//cierra
    @Override//sobre escribir
    public String toString() {// se crea el metodo para mostrar los datos
        StringBuilder sb = new StringBuilder();// se crea un StringBuilder
        sb.append("\nFecha: ");//imprime
        sb.append(dia);// se guarda
        sb.append("/");//imprime
        sb.append(mes);// se guarda
        sb.append("/");//imprime
        sb.append(ano);// se guarda
        sb.append("\nNumero de cuenta: ");//imprime
        sb.append(cuenta);// se guarda


        return sb.toString();//retona la cadena
    }//cierra
}//cierra
