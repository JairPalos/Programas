
#include "librerias.h"
using namespace std;

float *V, **W, prod=0,prod2=0,*final;
//crea un vector(tamanovector)
float * crea_vect(int sz){
	float *X;
	X=new float[sz];
	cout<<"Vector Creado."<<endl;
	return X;
}

float** crea_matriz(int m,int n)
{ int j;
    float **M;
    M=new float*[m];
    for (j=0;j<m;j++){
    M[j]=new float[n];}
    return M;}


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

float** lee_mat(char *nom_arch,int m,int n)
{ int i,j;
 cout<<"Matriz leyendo en; "<<nom_arch<<endl;
float **MM,num;
    MM=crea_matriz(m,n);
    fstream fd1;
    std::cout.precision(15);
    fd1.open(nom_arch,ios::in);
            for (i=0;i<m;i++)
                {for (j=0;j<n;j++)
                { fd1>>num;
                MM[i][j]=num;}}
    fd1.close();
    cout<<"Matriz leida"<<endl;
return MM;}


// imprime un vector(vectortipofloat *nombrevetor,tamanovector)
void muestra_vect(float* X,int sz){
	int i;
	for (i=0;i<sz;i++)	{
		cout<<X[i]<<","<<endl;
	}
}
int muestra_mat(float **M,int m,int n)
{ int i,j;
    for (i=0;i<m;i++)
        {for (j=0;j<m;j++)
                { cout<<M[i][j]<<","; }
            cout<<endl;}
    return 0;}



void lee_datos(char *n_arch1,char *n_arch2,int tm,int tv, int np){
	
	final=crea_vect(1000);
	omp_set_num_threads(np);
	#pragma omp parallel sections
	{
		#pragma omp section
		{
			W=crea_matriz(tm,tm);
			W=lee_mat(n_arch1,tm,tm);
			//muestra_mat(W, tm, tm);
		}
		#pragma omp section
		{
			V=crea_vect(tv);
			V=lee_vect(n_arch2,tm);
			//muestra_vect(V,tm);
		}

	}
	MxV( tm);
}

float VxV(int tm, float* v,float* w){
	float prod2;	
	int k;
	#pragma omp for private(i) reduction(+:prod)
	for(k=0; k <tm; k++){
		#pragma omp critical
		prod2 +=v[k]*w[k];
		
	}
	
	return prod2;
}



void MxV(int tm){
	int i,j;
	for(i=0; i <tm; i++){
		#pragma omp critical
		final[i]=VxV(tm,W[i],V);
		}
	
	resultado();
}

void resultado(){
	cout<<"Vector final es:"<<endl;
	for(int k=0;k<1000;k++){
		cout<<final[k]<<",";
	}
}