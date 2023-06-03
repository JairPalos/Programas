#include <iostream>
#include <omp.h>

using namespace std;

int main (int argc, char *argv[]){
	int i;
	#pragma omp parallel for private(i)
		for (i=0; i<5;i++)
		cout<<"Hola mundo des OpenMp"<<endl;
	return 0;
}