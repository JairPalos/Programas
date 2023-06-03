#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>
#include "libreriaF.h"
using namespace std;
//crea un vector(tamanovector)
float * crea_vect(int sz){
	float *X;
	X=new float[sz];
	cout<<"Vector Creado."<<endl;
	return X;
}

/*void ini_vect(float *,int sz){
	for (int i = 0; i < sz;i++){
		X[i]=0;
	}
}*/
//lee un vector(vectortipoCHAR *nombrevector,tamanovector)
float * lee_vect(char *n_arch,int sz){
	float *X,y;
	X=crea_vect(sz);
	ifstream f(n_arch);
	int i=0;
	y=0;
	cout<<"Leyendo Vector en: "<<n_arch<<endl;
	while(f>>y){
		X[i]=y;
		i++;
		y=0;
	}
	/7cout<<"Vector leido."<<endl;
	f.close();
	return X;
}
// imprime un vector(vectortipofloat *nombrevetor,tamanovector)
void muestra_vect(float* X,int sz){
	int i;
	for (i=0;i<sz;i++)	{
		cout<<X[i]<<","<<endl;
	}
}
//crea matriz(filas,columnas)
float** crea_mat(int f,int c){
	float **M;
	M=new float*[f];
	for (int i = 0;i<f;i++){
		M[i]=new float[c];
	}
	//cout<<"Matriz Creado."<<endl;
	return M;
}
//lee matriz(nombrematrizCHAR *nombre,int filas, int columnas)
float** lee_mat(char *nom_arch, int f, int c){
	int i,j;
	float **MM, num;
	MM = crea_mat(f,c);
	fstream fd1;
	cout.precision(15);
	fd1.open(nom_arch,ios::in);
	for(i = 0; i < f; i++){
		for(j = 0; j < c; j++){
			fd1>>num;
			MM[i][j] = num;
		}
	}
	fd1.close();
	cout <<"Matriz leida" << endl;
	return MM;
}
void muestra_mat(float **M,int f,int c){
	int i,j;
	for (i=0;i<f;i++){
		for (j=0;i<c;i++){
			cout<<M[i][j]<<" , ";
		}
		cout<<endl;
	}
}

float** mat_trans(float **X,int f,int c){
	int i,j;
	float **Y;
	Y=crea_mat(c,f);
	for (i=0;i<f;i++){
		for (j=0;j<c;j++){
			Y[j][i]=X[i][j];
		}
	}
	return Y;
}

float vecxvec(float* X,float* Y,int c){
	int prod=0;
	for (int o = 0; o <c ; o++){
		#pragma omp critical
		prod+=X[o]*Y[o];
	}
	//cout<<endl<<prod<<endl;
	return prod;
}
