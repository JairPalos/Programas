#include <iostream>
#include <fstream>
#include "libreriaF.h"
#include <omp.h>
#include <iomanip>
#include <cstdlib>
#include <cstdio>

using namespace std;

float **M, *V, *W;
int main(int argc, char *argv[]){
	int reg,colm,num_procs,i;
	reg=atoi(argv[3]);
	colm=atoi(argv[4]);
	num_procs=4;
	omp_set_num_threads(num_procs);
	#pragma omp parallel sections
	{
		#pragma omp section
		{
		M=crea_mat(reg,colm);
		M=lee_mat(argv[1],reg,colm);
		}

		#pragma omp section
		{
		V=crea_vect(colm);
		V=lee_vect(argv[2],colm);
		}
		#pragma omp section
		{
		W=crea_vect(reg);
		}
	}
	#pragma omp for private(i)
	for (i = 0; i <reg; i++){
		W[i]=vecxvec(M[i],V,colm);
	}
	muestra_vect(W,colm);
}
