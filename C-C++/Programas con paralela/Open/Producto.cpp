#include <iostream>
#include <fstream>
#include "librerias.h"
#include <omp.h>
using namespace std;

void lee_datos(char *,char *,int,int);

float *V, *W, prod=0;
int main(int argc, char *argv[]){
	int tm,num_procs;
	tm=atoi(argv[3]);
	num_procs=4;

	lee_datos(argv[1],argv[2],tm,num_procs);

	return 0;

}

void lee_datos(char *n_arch1,char *n_arch2,int tm,int np){
	int i;
	omp_set_num_threads(np);
	#pragma omp parallel sections
	{
		#pragma omp section
		{
		V=crea_vect(tm);
		V=lee_vect(n_arch1,tm);
		}

		#pragma omp section
		{
		W=crea_vect(tm);
		W=lee_vect(n_arch2,tm);
		}

	}

	#pragma omp for private(i) reduction(+:prod)
	for(i=0; i <tm; i++){

		#pragma omp critical
		prod +=V[i]*W[i];
	}
	cout<<endl<<prod<<endl;
}