#include "funciones.h"

using namespace std;

void vect_dot(float *X, float *Y, float *Z, int r, int n){

	float s = 0;
	mutex mtx;

	for (int i = 0; i < n; i++){

		mtx.lock();
		s += X[i] * Y[i];
		mtx.unlock();

	}//for

	Z[r] = s;

}//vect_dot

void lee_vect(char *nom_arc,float *X, int n){
	
	fstream fd;
	fd.open(nom_arc, ios::in);
	
	while(!fd.eof()){
		
		for(int i = 0; i < n; i++){
			
			fd>>X[i];
		
		}//for

	}//while

	fd.close();
	cout<<"Vector leido..."<<endl;

}//lee_vect

float **lee_mat(char *n_arc, int r, int c){

	float **Y;
	Y = asigna_mem(r,c);

	fstream f1;
	f1.open(n_arc, ios::in);

	while(!f1.eof()){

		for(int i = 0; i < r; i++){

			for(int j = 0;j < c; j++){

			f1>>Y[i][j];
			
			}//for

		}//for

	}//while

	f1.close();
	cout<<"Matriz leida"<<endl;
	return Y;
	
}//lee_mat

void imp_mat(float **X, int m, int n){

	for(int i = 0; i < m; i++){

		for(int j = 0; j < n; j++){

			cout<<X[i][j]<<",";

		}//for

	}//for

}//imp_mat

void imp_vect(float *X, int m){

	for(int i = 0; i < m; i++){

		if(i < m - 1)
		
			cout<<X[i]<<",";

		else

			cout<<X[i]<<endl;

	}//for

}//imp_mat

float **asigna_mem(int r, int c){

	float **X;
	X = new float *[r];

	for(int i = 0; i < r; i++){

		X[i]=new float[c];

	}//for
	
	cout<<"Se asignó memoria a la matriz..."<<endl;
	return X;
	
}//asigna_mem