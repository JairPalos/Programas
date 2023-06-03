#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>
#include "funciones1.h"

using namespace std;
float** crea_mat(int m, int n){
	int j;
	float **M;
	M = new float*[m];
	for(j = 0; j < m; j++){
		M[j] = new float[n];
	}
	return M;
}

float** lee_mat(char *nom_arch, int m, int n){
	int i,j;
	float **MM, num;
	MM = crea_mat(m,n);
	fstream fd1;
	cout.precision(15);
	fd1.open(nom_arch,ios::in);
	for(i = 0; i < m; i++){
		for(j = 0; j < n; j++){
			fd1>>num;
			MM[i][j] = num;
		}
	}
	fd1.close();
	cout <<"Matriz leida " << endl;
	return MM;
}

void muestra_mat(float **M, int m, int n){
	int i,j;
	for(i=0; i < m; i++){
		for(j = 0; j < m; j++){
			cout << M[i][j] << ",";
		}
		cout << endl;
	}

}