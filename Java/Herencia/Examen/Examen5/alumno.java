package Examen5;// el paquete de las clases
public class alumno {// se crea la clase alumno
    private String nombre;// se crea una variable de tipo String
    private double programacionII;// se crea una variable de tipo double
    private double algoritmoGenetico;// se crea una variable de tipo double
    private double sistemasDigitales;// se crea una variable de tipo double
    private double procesamiento;// se crea una variable de tipo double
    private double arquitectura;// se crea una variable de tipo double

    public String getNombre() {// inicia del get
        return nombre;//regresa la variable
    }//cierra
    public void setNombre(String nombre) {//inicia el set
        this.nombre = nombre;//varibale es iagual a si misma
    }//cierra

    public double getProgramacionII() {// inicia del get
        return programacionII;//regresa la variable
    }//cierra

    public void setProgramacionII(double programacionII) {//inicia el set
        this.programacionII = programacionII;//varibale es iagual a si misma
    }//cierra


    public double getAlgoritmosGeneticos() {// inicia del get
        return algoritmoGenetico;//regresa la variable
    }//cierra

    public void setAlgoritmosGeneticos(double algoritmoGenetico) {//inicia el set
        this.algoritmoGenetico = algoritmoGenetico;//varibale es iagual a si misma
    }//cierra
    public double getSistemasDigitales() {// inicia del get
        return sistemasDigitales;//regresa la variable
    }//cierra

    public void setSistemasDigitales(double sistemasDigitales) {//inicia el set
        this.sistemasDigitales = sistemasDigitales;//varibale es iagual a si misma
    }//cierra
    public double getProcesamiento() {// inicia del get
        return procesamiento;//regresa la variable
      }//cierra

    public void setProcesamiento(double procesamiento) {//inicia el set
        this.procesamiento = procesamiento;//varibale es iagual a si misma
    }//cierra
    public double getArquitectura() {// inicia del get
        return arquitectura;//regresa la variable
    }//cierra

    public void setArquitectura(double arquitectura) {//inicia el set
        this.arquitectura = arquitectura;//varibale es iagual a si misma
    }//cierra

    public double mediaDelAlumno(){//inicia el metodo para clacular la media
      double media=0;// se  crean la variable de media
      double suma=0;// se  crean la variable de suma
      suma=programacionII+algoritmoGenetico+sistemasDigitales+procesamiento+arquitectura;// se suman todas la materias
      media=suma/5;// sabiendo que son 5 materias se realiza la media
      return media;// regresa la media
    }//cierra
    @Override//sobre escribir
    public String toString() {// se crea el metodo para mostrar los datos
        StringBuilder sb = new StringBuilder();// se crea un StringBuilder
        sb.append("\nNombre: ");//imprime
        sb.append(nombre);// se guarda
        sb.append("\nProgramacion II: ");//imprime
        sb.append(programacionII);// se guarda
        sb.append("\nAlgoritmos Geneticos: ");//imprime
        sb.append(algoritmoGenetico);// se guarda
        sb.append("\nSistemas Digitales: ");//imprime
        sb.append(sistemasDigitales);
        sb.append("\nProcesamiento de Imagenes: ");//imprime
        sb.append(procesamiento);// se guarda
        sb.append("\nArquitecturas de Computadoras: ");//imprime
        sb.append(arquitectura);// se guarda
        sb.append("\nMedia del Alumno: ");//imprime
        sb.append(mediaDelAlumno());// se guarda
        return sb.toString();//retona la cadena
    }//cierra
}//cierra
