#include <iostream>
#include <fstream>
#include "librerias.h"
#include <omp.h>
using namespace std;
int main(int argc, char *argv[]){
	int tm,num_procs;
	tm=atoi(argv[3]);
	num_procs=4;
	lee_datos(argv[1],argv[2],tm,num_procs);
	return 0;
}
	
