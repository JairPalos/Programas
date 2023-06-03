package cola2;
public class Cola{
	int tamanio;
	NodoCola inicio, fin;
	//declaramos el constructor
	public Cola(){
		//inicializo los elementos
		inicio=fin=null;
		tamanio=0;
	}//final del constructor
	//Declarar los métodos
	//Método para saber si la cola está vacía
	public boolean estaVacia(){
		return inicio==null;
	}
	//Método para insertar datos en la cola
	public void insertar(int element){
		NodoCola nuevo = new NodoCola(element);
		if(estaVacia()){
			inicio=nuevo;
		}else{
			fin.siguiente=nuevo;
		}
		fin=nuevo;
		tamanio++;
	}
	//Método para quitar datos de la cola
	public int quitar(){
		/*crear una variable auxiliar para mover
		el puntero al siguiente elemento*/
		int auxiliar = inicio.dato;
		inicio=inicio.siguiente;
		//decremento en el tamaño de la cola
		tamanio --;
		return auxiliar;
	}
	/*Método para conocer quien está
	al inicio de la cola*/
	public int inicioCola(){
		return inicio.dato;
	}
	/*Método para conocer el tamaño de la cola*/
	public int tamanioCola(){
		return tamanio;
	}
}//Fin de la clase
