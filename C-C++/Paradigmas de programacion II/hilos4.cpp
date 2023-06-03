#include <iostream>
#include <pthread.h>
#include <cstdlib>
#include <fstream>
#include <time.h>

using namespace std;

struct parms{
int id;
string ruta="hilo2.txt";
int maximo=5;
int a=2345;
int b=34245324;
 };

void* caracteres(void* parametros){
	int id;
	int n = 0;
	 struct parms* p = (struct parms*)parametros;
	srand(time(0));

	for(int i = 1; i < 5; i++){
	
		n = 33 + rand() % (126 - 33);
		cout<<"Hilo 1: "<<(char)n<<" "<<endl;
	
	}//for
	return NULL;

}//caracteres

void* archivo(void* parametros){

	struct parms* p = (struct parms*)parametros;
	string filename=p->ruta;
    ifstream archivo(filename); // Abre el archivo
    if (!archivo.is_open()) { // Verifica que el archivo se haya abierto correctamente
        cout << "No se pudo abrir el archivo" << endl;
        
    }
    string linea;
    while (getline(archivo, linea)) { // Lee cada línea del archivo
        cout <<"hilo 2: "<< linea << endl;
    }

    archivo.close(); // Cierra el archivo
  
	return NULL;

}//archivo

void* vector(void* parametros){

	struct parms* p = (struct parms*)parametros;
	int tam = 0;
	int vector[4]={1,2,3,4};

	cout<<"Hilo 3: [";

	/*Creamos el for para la impresión de nuestro vector*/
	for (int i = 0; i < p->maximo; ++i){
		
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

	
	return NULL;

}//vector

void* suma(void* parametros){
	struct parms* p = (struct parms*)parametros;
	
	int resultado;
	resultado=p->a+p->b;

	cout<<"Hilo 4: El resultado es: "<<resultado<<endl;
	return NULL;
}



int main(){

	pthread_t hilos[4];
	
	struct parms estructura[4];
	


	pthread_create (&hilos[0], NULL, &caracteres, &estructura[0]);
	pthread_create (&hilos[1], NULL, &archivo, &estructura[1]);
	pthread_create (&hilos[2], NULL, &vector, &estructura[2]);
	pthread_create (&hilos[3], NULL, &suma, &estructura[3]);
	





	pthread_join (hilos[0],NULL);
	pthread_join (hilos[1], NULL);
	pthread_join (hilos[2], NULL);
	pthread_join (hilos[3], NULL);
	return 0;
	
}//main
