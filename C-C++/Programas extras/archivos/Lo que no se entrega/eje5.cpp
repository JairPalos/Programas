/*
SE NECESITAN DOS ARCHIVOS Y LOS VALORES QUE SE TOMARÁN EN LA EJECUCIÓN
Hola.txt Hola1.txt 100
*/

#include <mutex>
#include <iostream>
#include <fstream>
#include <thread>
#include <cstdlib>
#include <cstdio>

using namespace std;

void lee_vect(char *,float *, int );
void vect_dot(float*,float*,float*,int);

float *V,*W,S,*P;

int main(int argc,char*argv[]){

	system("clear");

	char * nom_arc1 , * nom_arc2;

	int n;
	S=0.0;
	P=&S;
	n=atoi (argv[3]);


	V=new float[n];
	W=new float[n];

	nom_arc1= argv[1];
	nom_arc2= argv[2];
	
	thread t1(lee_vect,nom_arc1,V,n);
	thread t2(lee_vect,nom_arc2,W,n);
	t1.join();
	t2.join();

	thread t3(vect_dot,V,W,P,n);
	t3.join();
	cout <<"El resultado es: "<< S <<endl;

	return 0;
	
}//main

void lee_vect(char *nom_arc,float *X, int n){
	fstream fd;
	fd.open(nom_arc,ios::in);
	while(!fd.eof()){
		for(int i=0;i<n;i++){
			fd>>X[i];
		}
	}

	fd.close();
	cout<<"Vector leido..."<<endl;

}//lee_vect

void vect_dot(float*X,float*Y,float*Z,int n){

	cout<<"VAMOS A HACER EL PRODUCTO "<<endl;
	float s=0;
	mutex mtx;

	for (int i=0;i<n;i++){
		mtx.lock();
		s +=X[i]*Y[i];
		mtx.unlock();

	}

	*Z = s;

}//vect_dot
