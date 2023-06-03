#include <iostream>
#include <fstream>
#include "librerias.h"
using namespace std;
//crea un vector(tamanovector)
float * crea_vect(int sz){
	float *X;
	X=new float[sz];
	cout<<"Vector Creado."<<endl;
	return X;
}

/*void ini_vect(float *,int sz){
	for (int i = 0; i < sz;i++){
		X[i]=0;
	}
}*/
//lee un vector(vectortipoCHAR *nombrevector,tamanovector)
float * lee_vect(char *n_arch,int sz){
	float *X,y;
	X=crea_vect(sz);
	ifstream f(n_arch);
	int i=0;
	y=0;
	cout<<"Leyendo Vector en: "<<n_arch<<endl;
	while(f>>y){
		X[i]=y;
		i++;
		y=0;
	}
	cout<<"Vector leido."<<endl;
	f.close();
	return X;
}
// imprime un vector(vectortipofloat *nombrevetor,tamanovector)
void muestra_vect(float* X,int sz){
	int i;
	for (i=0;i<sz;i++)	{
		cout<<X[i]<<","<<endl;
	}
}