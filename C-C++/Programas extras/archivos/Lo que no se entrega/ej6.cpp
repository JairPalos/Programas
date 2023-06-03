#include <mutex>
#include <iostream>
#include <fstream>
#include <thread>
#include <cstdlib>
#include <cstdio>

using namespace std;

void vect_dot(float*, float*, float*, int);
void lee_vect(char*, float*, int);
void lee_mat(char* n_arc, float** X, int);
void imp_vect(float*, int);
void imp_mat(float**, int, int);
float *V, **M, *W;
char *nom_arc1, *nom_arc2;

int main(int argc, char const *argv[]){

	system("clear");

	int m, n;
	m = atoi(argv[3]);
	n = atoi(argv[4]);

	V = new float[n];
	W = new float[m];
	M = new float*[m];

	for (int i = 0; i < m; i++){
		
		M[i] = new float[n];

	}//for

	nom_arc1 = argv[1];
	nom_arc2 = argv[2];

	thread t1(lee_mat, nom_arc1, M, m, n);
	thread t2(lee_vect, nom_arc2, V, n);
	t1.join();
	t2.join();

	for (int i = 0; i < m; i++){
		
		thread t3(vect_dot, V, M[i], W, i);
		t3.join();

	}//for

	imp_vect(W, m);
	return 0;

}//main

void vect_dot(float *X, float *Y, float *Z, int r, int n){

	float s = 0;
	float *A;
	A = new float[n];
	mutex mtx;

	for (int i = 0; i < n; i++){

		mtx.lock();
		s += X[i]*Y[i];
		mtx.unlock();

	}//for

	Z[r] = s;

}//vect_dot
