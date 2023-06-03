#include <iostream>
#include <omp.h>

using namespace std

int main(int argc, char *argv[]){
#pragma omp parallel
	{
		cout<<"Hola mundo omp"<<endl;
	}
	return 0;
}