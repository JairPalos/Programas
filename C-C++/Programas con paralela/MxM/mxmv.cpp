#include <iostream>
#include <cstdlib>
#include <cstdio>
#include <omp.h>
#include "libreriaF.h"
using namespace std;
float **M,**N,**O,**T;
int main(int argc, char *argv[]){
	int i,j,k,m,n,q;
	float t0,tf;
	t0=tf=0;
	m=atoi(argv[3]);
	n=atoi(argv[4]);
	q=atoi(argv[5]);
	omp_set_num_threads(4);
	//omp_set_nested(true);
	t0=omp_get_wtime();
	#pragma omp sections
	{
		#pragma omp section
		{
			M=crea_mat(m,n);
			M=lee_mat(argv[1],m,n);
		}
		#pragma omp section
		{
			N=crea_mat(n,q);
			N=lee_mat(argv[2],n,q);
		}
		#pragma omp section
		{
			O=crea_mat(m,q);
		}
	}
	#pragma omp sections
	{
		#pragma omp section
		{
			T=crea_mat(q,n);
			T=mat_trans(N,n,q);
		}
	}
	#pragma omp parallel for collapse(2)
	for (i=0;i<m;i++){
		for (j=0;j<q;j++){
			O[i][j]+=vecxvec(M[i],T[j],q);
		}
	}
	tf=omp_get_wtime();
	//muestra_mat(O,m,q);
	cout<<"Tiempo ejecucion: "<<tf-t0<<endl;
	return 0;
}
