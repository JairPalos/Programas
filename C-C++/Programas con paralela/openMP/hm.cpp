#include <iostream>
#include <omp.h>

using namespace std;

int main(int argc, char *argv[]){
#pragma omp parallel
	for (int i = 0; i < 5; i++)
	{
		cout<<"Hola mundo omp"<<endl;
	}
	return 0;
}