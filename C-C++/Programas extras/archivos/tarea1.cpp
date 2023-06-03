#include <iostream>
#include <pthread.h>
#include <cstdlib>
#include <fstream>
#include <time.h>

using namespace std;

void* caracteres(void* unused){

	/*Creamos las variables para que los caracteres sean aleatorios 
	cada vez que se ejecute el programa*/
	int n = 0;
	srand(time(0));

	/*Creamos un for para que se impriman SOLO 5 de los caracteres
	cuyo código en ASCII será aleatorio*/
	for(int i = 1; i < 5; i++){
	
		n = 33 + rand() % (126 - 33);
		cout<<"Hilo 1: "<<(char)n<<" ";
	
	}//for
	
	cout<<endl;
	return NULL;

}//caracteres

void* archivo(void* unused){

	/*Se abre el archivo "Hola.txt" en modo lectura*/
	ifstream archivo;
	archivo.open("Hola.txt", ios::in);
	
	string frase;

	/*Mientras no se llegue al final del archivo, se imprime la linea*/
	while(!archivo.eof()){

		getline(archivo, frase);
		cout<<"Hilo 2: "<<frase<<" "<<endl;

	}//while

	/*Cerramos el archivo*/
	archivo.close();
	return NULL;

}//archivo

void* vector(void* unused){

	/*Creamos el vector con las variables que queramos para poder
	imprimirlo en pantalla*/
	int tam = 0;
	int vector[4]={1,2,3,4};

	cout<<"Hilo 3: [";

	/*Creamos el for para la impresión de nuestro vector*/
	for (int i = 0; i < 4; ++i){
		
		/*Si el indice del vector es menor al tamaño del mismo,
		imprime una coma y un espacio*/
		if (vector[i] <= 3){
		
			cout<<vector[i]<<", ";
		
		}

		/*En caso de que el indice sea igual al tamaño, se imprime
		un corchete*/
		else{

			cout<<vector[i]<<"]"<<endl;

		}

	}//for

	//cout<<"]"<<endl;
	return NULL;

}//vector

int main(){

	pthread_t th_1, th_2, th_3;
	pthread_create (&th_1, NULL, &caracteres, NULL);
	pthread_create (&th_2, NULL, &archivo, NULL);
	pthread_create (&th_3, NULL, &vector, NULL);
	
	pthread_join (th_1, NULL);
	pthread_join (th_2, NULL);
	pthread_join (th_3, NULL);
	return 0;
	
}//main
