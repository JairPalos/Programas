/*Programador: José Francisco Sandoval Rodríguez*/

#include "funciones.h"

using namespace std;

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
		
		int nh = 4;
		thread t[nh];

		int h = 0;
		
		for(int i = 0; i < n2; i++){
		
			for(int j = 0; j < m1; j++){
			
				h = i * j % 4;
				
				t[h] = thread(mat_dot, M1, M2, W, i, j, n1);
				t[h].join();
			
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
