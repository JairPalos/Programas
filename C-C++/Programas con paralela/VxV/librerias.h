#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>

float* crea_vect(int);
float **crea_matriz(int, int );
float **lee_mat(char *, int, int);
float* lee_vect(char *,int);
void muestra_vect(float* ,int);
int muestra_mat(float **, int , int );
void lee_datos(char *,char *,int,int,int);
void resultado();
float VxV(int, float* ,float* );
void MxV(int);