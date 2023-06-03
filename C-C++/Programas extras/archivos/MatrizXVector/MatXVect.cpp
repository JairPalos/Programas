/*
Compilación: 
	g++ MatXVect.cpp funciones.cpp -o MatXVect -std=c++14 -pthread
*/

#include "funciones.h"

using namespace std;

float *V, **M, *W;
char *nom_arc1, *nom_arc2;

int main(int argc, char *argv[]){

	system("clear");
	
	int m, n;
	m = atoi(argv[3]);
	n = atoi(argv[4]);
	
	nom_arc1 = argv[1];
	nom_arc2 = argv[2];

	V = new float[n];
	W = new float[m];
	M = new float*[m];
	
	M =  asigna_mem(m,n);
	lee_vect(argv[2], V, n);
	M = lee_mat(argv[1], m, n);
	
	/*Creamos los 4 hilos que nos ayudarán a que se puedan realizar las
	operaciones correspondientes*/
	thread t[4];
	int h;

	/*Creamos un for que irá hasta el 100, esto con la finalidad de que
	pueda revisar todo el contenido de ambos archivos y comprobar que
	todo es correcto*/
	for (int i = 0; i < m; i++){
		
		h = i % 4;

		/*Si el resultado del modulo es 0, el hilo "0" trabaja*/
		if(h == 0){

			t[h] = thread(vect_dot, V, M[i], W, i, n);	
			t[h].join();

		}//if

		/*Si el resultado del modulo es 1, el hilo "1" trabaja*/
		if(h == 1){

			t[h] = thread(vect_dot, V, M[i], W, i, n);	
			t[h].join();
			
		}//if

		/*Si el resultado del modulo es 2, el hilo "2" trabaja*/
		if(h == 2){

			t[h] = thread(vect_dot, V, M[i], W, i, n);	
			t[h].join();
			
		}//if

		/*Si el resultado del modulo es 3, el hilo "3" trabaja*/
		if(h == 3){
			
			t[h] = thread(vect_dot, V, M[i], W, i, n);	
			t[h].join();

		}//if

	}//for

	/*Finalmente, iprimimos el vector y termina la ejecución*/
	imp_vect(W, m);
	cout<<endl;
	return 0;

}//main