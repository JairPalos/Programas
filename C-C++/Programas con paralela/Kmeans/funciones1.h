#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <cstdio>
#include <omp.h>

float** crea_mat(int, int);
float** lee_mat(char *, int, int);
void muestra_mat(float**, int,int);
