package pila;//paquete de la clase
public class Pila{//nombre de la clase
	int tamanio;//una variable entera
	NodoPila inicio, fin;//dos variadel de tipo nodoCola (que en este caso seria la pila)
	//decla0ramos el constructor
	public Pila(){//constructor de la clase
		//inicializo los elementos
		inicio=fin=null;// limpia el inicio y el final
		tamanio=0;// para poder insertar un valor de debe de inicializar en cero
	}//final del constructor
	//Declarar los métodos
	//Método para saber si la cola está vacía
	public boolean estaVacia(){// un metoso booleano
		return inicio==null;//si esta vacia regresa verdadero
	}//final del metodo booleano
	//Método para insertar datos en la cola
	public void insertar(int element){//metodo para insertar
		NodoPila nuevo = new NodoPila(element);// crea una variable del tipo nodo cola
		if(estaVacia()){// si esta vacia
			inicio=nuevo;// ingresa el valor en el inicio
		}else{//sino
			fin.siguiente=nuevo;//lo ingresa en el valor que sigue
		}//final de else
		fin=nuevo;// el nuevo valor se pone el final
		tamanio++;//desincrementa el tamaño
	}//final del metodo insertar
	//Método para quitar datos de la cola
	public int quitar(){// se crea un metodo para quitar que regresa un entero
		/*crear una variable auxiliar para mover
		el puntero al siguiente elemento*/
		int auxiliar = fin.dato;// se crea una variable auxiliar para ayudar que tendra el dato a quitar
		fin=fin.siguiente;// final de pasa a uno ultimo es decir al penultimo
		//decremento en el tamaño de la cola
		tamanio --;// se decrementa el tamaño para que el penultimo valir se convierta en el ultimo o este caso el primero
		return auxiliar;// rgresa la variable auxiliar
	}// fin del metodo quitar
	/*Método para conocer quien está
	al inicio de la cola*/
	public int inicioCola(){// metodo para mostra el inicio de la pila
		return fin.dato;// regresa el valor que esta en el inicio de la pila que seria el ultimo del arreglo
	}// fin del metodo inicioCola
	public int finalCola(){// metodo para mostra el final de la pila
		return inicio.dato;// regresa el valor que esta en el ultimo de la pila que seria el primero del arreglo
	}// fin del metodo finalCola
	/*Método para conocer el tamaño de la cola*/
	public int tamanioCola(){//metodo para saber el tamaño
		return tamanio;// regresa la variable que contiene el tamaño
	}// fin del metodo tamanioCola
}//Fin de la clase
