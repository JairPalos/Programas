#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>
#include "funciones.h"
//suma de vectores
using namespace std;
float **X, **Y;
int i;
int main(int argc, char *argv[]){
	int i,fila,columna ;
	float t0,tf;
	columna=atoi(argv[3]);
	fila=atof(argv[4]);
	t0=omp_get_wtime(); 
	#pragma omp single nowait
	{
		#pragma omp task	
		{
		X=crea_mat(columna,fila);
		X=lee_mat(argv[1],columna,fila);
		//muestra_mat(X, columna, fila);
		}
		#pragma omp tasks
		{
		Y=crea_mat(columna,fila);
		Y=lee_mat(argv[2],columna,fila);
		//muestra_mat(Y, columna, fila);
		}
	}
	
	tf=omp_get_wtime();
	cout<<"Tiempo de computo: " <<tf-t0<<endl;
	
	cout<<endl;
	cout<<endl;
	cout<<Y[2][1];
	
	return 0;
}

