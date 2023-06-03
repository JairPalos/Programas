#include <iostream>
#include <fstream>
#include "librerias.h"
#include <omp.h>
using namespace std;
int main(int argc, char *argv[]){
	int tm,tv,num_procs;
	tm=atoi(argv[3]);
	tm=atoi(argv[4]);
	num_procs=5;
	lee_datos(argv[1],argv[2],tm,tv,num_procs);
	return 0;
}
	
