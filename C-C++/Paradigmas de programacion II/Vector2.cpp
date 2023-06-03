#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cstdio>
#include <iomanip> 
#include <string>
using namespace std;


float* crea_vect(int);
float* lee_vect(char *,int);
void muestra_vect(float*,int);
static float *V;
static float *W;
int main(int argc, char * argv[]){
    int i,tm;
    tm= atoi(argv[3]);
    cout<<tm<<endl;
    V=crea_vect(tm);
    V=lee_vect(argv[1],tm);
    muestra_vect(V,tm);
    W=crea_vect(tm);
    W=lee_vect(argv[2],tm);
    muestra_vect(W,tm);
    delete(V);
    delete(W);
    return 0;
}

float * crea_vect(int sz){
    float *X;
    X=new float[sz];
    cout<<"Vector creado"<< endl;
    return X; } 

float * lee_vect(char *n_arch,int sz){
    float *X,y;
    X=crea_vect(sz);
    ifstream in (n_arch,ios::in);
    int i=0;
    y=0;
    cout<<"leyendo vector en "<<n_arch<<endl;
    while(in>>y){
        X[i] = y;
        i++;
        y=0;
    }
    cout<<"vector leido"<<endl;
    in.close();
    return X;
}

void muestra_vect(float* X,int sz){
    int i;
    cout<<" oooo, "<<endl;
    for(i=0; i<sz; i++){
        cout<< setprecision(5)<< X[i] <<" , "<<endl;
        }
    }

