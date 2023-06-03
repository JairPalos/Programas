/*
Compilación: 
	g++ -c -o funciones.o funciones.cpp -pthread
	g++ -o matXmat.x matXmat.cpp funciones.o -pthread
*/

#include "funciones.h"

using namespace std;
//	  M1	M2  S
float **M1, **M2, **W;
char *nom_arc1, *nom_arc2;

int main(int argc, char *argv[]){

	system("clear");
	
	int m1, n1, m2, n2;

	m1 = atoi(argv[3]);
	n1 = atoi(argv[4]);
	m2 = atoi(argv[5]);
	n2 = atoi(argv[6]);
	
	nom_arc1 = argv[1];
	nom_arc2 = argv[2];
	
	if(n1 == m2){

		W = asigna_mem(m1, n2);

		M1 = lee_mat(nom_arc1, m1, n1);
		M2 = lee_mat(nom_arc2, m2, n2);
		
		int h = 4;
		thread t[h];

		for (int i = 0; i < h; i++){

			for (int j = 0; j < (n2/h); j++){

				for (int k = 0; k < m1; k++){

					t[i] = thread(mat_dot, M1, M2, W, j+(n2/h*i), k, n1);
					t[i].join();
					
				}//for

			}//for

		}//for

		imp_mat(W, m1, n2);
		cout<<endl;

	}//if

	else {

		cout<<"El tamaño de las matrices no es igual, no se puede multiplicar";

	}//else

	return 0;

}//main