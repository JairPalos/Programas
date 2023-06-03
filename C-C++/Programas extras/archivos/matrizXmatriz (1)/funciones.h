#ifndef FUNCIONES
#define FUNCIONES

#include <mutex>
#include <iostream>
#include <fstream>
#include <thread>
#include <cstdlib>
#include <cstdio>

void mat_dot(float**, float**, float**, int, int, int);
void lee_vect(char*, float*, int);
float** lee_mat(char* , int, int);
void imp_vect(float*, int);
void imp_mat(float**, int, int);
float** asigna_mem(int, int);

#endif