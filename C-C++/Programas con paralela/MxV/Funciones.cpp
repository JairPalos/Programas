#include <iostream>
#include <fstream>
#include "librerias.h"
#include <omp.h>
using namespace std;

float *V, *W, prod=0;
//crea un vector(tamanovector)
float * crea_vect(int sz){
	float *X;
	X=new float[sz];
	cout<<"Vector Creado."<<endl;
	return X;
}

//lee un vector(vectortipoCHAR *nombrevector,tamanovector)

float * lee_vect(char *n_arch, int sz){
	float *X,y;
	int i,j;
	X = crea_vect(sz);
	fstream fd2;
	fd2.open(n_arch,ios::in);
	cout << "Leyendo vector en el archivo: " << n_arch << endl;
	
	while(!fd2.eof())
		for(i=0;i<sz;i++){
			fd2>>y;
			X[i]=y;
		}
	
	fd2.close();
	cout << "Vector leido" << endl;
	return X;
}
// imprime un vector(vectortipofloat *nombrevetor,tamanovector)
void muestra_vect(float* X,int sz){
		int i;
		for (i=0;i<sz;i++)	{
		cout<<X[i]<<","<<endl;
	}
}


void lee_datos(char *n_arch1,char *n_arch2,int tm,int np){
	
	omp_set_num_threads(np);
	#pragma omp parallel sections
	{
		#pragma omp section
		{
		V=crea_vect(tm);
		V=lee_vect(n_arch1,tm);
		//muestra_vect(V,tm);
		}

		#pragma omp section
		{
		W=crea_vect(tm);
		W=lee_vect(n_arch2,tm);
		//muestra_vect(W,tm);
		}

	}
	VxV(tm);
}

void VxV(int tm){
	int i;

	#pragma omp for private(i) reduction(+:prod)
	for(i=0; i <tm; i++){
		#pragma omp critical
		prod +=V[i]*W[i];

		
	}
	cout<<"El producto es:"<<endl;
	cout<<endl<<prod<<endl;
	
}

