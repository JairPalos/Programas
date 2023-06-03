#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>
#include "func_omp.h"
//suma de vectores
using namespace std;
float *X, *Y, *Z;
int i;

#pragma omp declare simd
float saxpy(float *X, float*Y,int i, float SA){
	float tm, *Z;
	Z=crea_vect(i);
	tm=SA*X[i]+Y[i];
	//cout << X[i] << endl;
	//cout << Z[i] << endl;
	return Z[i];
}

int main(int argc, char *argv[]){
	int i,ren;
	float mt,t0,tf;
	ren=atoi(argv[3]);
	mt=atof(argv[4]);
	Z=crea_vect(ren);
	t0=omp_get_wtime(); 
	#pragma omp single nowait
	{
		#pragma omp task	
		{
		X=crea_vect(ren);
		X=lee_vect(argv[1],ren);
		//muestra_vect(ren);
		}
		#pragma omp task
		{
		Y=crea_vect(ren);
		Y=lee_vect(argv[2],ren);
		//muestra_vect(ren);
		}
	}
	
	/*int ren;
	int i, size=10000;
	ren=atoi(argv[3]);
	
	X=crea_vect(ren);
	Y=crea_vect(ren);
	
	X=lee_vect(argv[1],ren);
	Y=lee_vect(argv[2],ren);*/
	
	#pragma omp simd
	for(i=0; i<ren;i++){
		Z[i]=saxpy(X,Y,i,ren,mt);
	}
	
	tf=omp_get_wtime();
	cout<<"Tiempo de computo: " <<tf-t0<<endl;
	muestra_vect(Z,ren);
	
	return 0;
}


