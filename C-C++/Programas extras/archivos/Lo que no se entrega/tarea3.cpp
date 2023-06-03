#include <mutex>
#include <iostream>
#include <fstream>
#include <thread>
#include <cstdlib>
#include <cstdio>

using namespace std;

void vect_dot(float*, float*, float*, int, int);
void lee_vect(char*, float*, int);
float** lee_mat(char* , int, int);
void imp_vect(float*, int);
void imp_mat(float**, int, int);
float** asigna_mem(int, int);
float *V, **M, *W;
char *nom_arc1, *nom_arc2;

int main(int argc, char *argv[]){

	system("clear");
	
	char *nom_arc1, *nom_arc2;
	int m, n;
	m = atoi(argv[3]);
	n = atoi(argv[4]);
	
	nom_arc1 = argv[1];
	nom_arc2 = argv[2];

	V = new float[n];
	W = new float[m];
	M = new float*[m];
	
	M =  asigna_mem(m,n);
	lee_vect(argv[2], V, n);
	M = lee_mat(argv[1], m, n);
	
	thread t[4];
	
	for (int i = 0; i < 100; i++){
		
		if(i <= 25){

			t[0] = thread(vect_dot, V, M[0], W, i, n);
			t[0].join();
		
		}
		/
		if(i > 25 && i <= 50){

			t[1] = thread(vect_dot, V, M[0], W, i, n);
			t[1].join();
			cout<<"Hilo 2 trabajando..."<<endl;

		}

		if(i > 50 && i <= 75){

			t[2] = thread(vect_dot, V, M[0], W, i, n);
			t[2].join();
			cout<<"Hilo 3 trabajando..."<<endl;

		}

		if(i > 75 && i <= 100){

			t[3] = thread(vect_dot, V, M[0], W, i, n);
			t[3].join();
			cout<<"Hilo 4 trabajando..."<<endl;

		}

	}

	imp_vect(W, m);
	return 0;

}//main

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
	fd.open(nom_arc,ios::in);
	while(!fd.eof()){
		for(int i=0;i<n;i++){
			fd>>X[i];
		}
	}

	fd.close();
	cout<<"Vector leido..."<<endl;

}//lee_vect

float **lee_mat(char *n_arc, int r, int c){

	float **Y;
	Y = asigna_mem(r,c);
	fstream f1;
	f1.open(n_arc, ios::in);

	while(!f1.eof()){
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
			f1>>Y[i][j];
			}//for
		}//for
	}//while

	f1.close();
	cout<<"Matriz leida"<<endl;
	return Y;
	
}//lee_mat

void imp_mat(float **X, int m, int n){

	for(int i=0; i<m; i++){
		for(int j=0; j<n; j++){
			cout<<X[i][j]<<",";
		}//for
	}//for

}//imp_mat

void imp_vect(float *X, int m){

	for(int i=0; i<m; i++){

		if(i<m-1)
		cout<<X[i]<<",";

		else
			cout<<X[i]<<endl;
	}//for

}//imp_mat

float **asigna_mem(int r, int c){

	float **X;
	X = new float *[r];
	for(int i=0; i<r; i++){
		X[i]=new float[c];
	}//for
	
	cout<<"Se asignó memoria a la matriz..."<<endl;
	return X;
	
}//asigna_mem
