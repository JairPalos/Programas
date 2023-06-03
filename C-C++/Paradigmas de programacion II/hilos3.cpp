#include <pthread.h>
#include <cstdio>
#include <iostream>
using namespace std;

struct char_print_parms{

int inicio,final;
 };

int resultado;


void*suma_hilos (void* parameters) {
    struct char_print_parms* p = (struct char_print_parms*)parameters;
    int i,aux=0;
    for (i = p->inicio; i <=p->final; ++i){
        aux=aux+i;
    }
    cout<<aux<< "\n";
    resultado=resultado+aux;
    return NULL; 
}


int main (){
    pthread_t thread1_id;
    pthread_t thread2_id;
    pthread_t thread3_id;
    pthread_t thread4_id;
 
    struct char_print_parms thread1_args;
    struct char_print_parms thread2_args;
    struct char_print_parms thread3_args;
    struct char_print_parms thread4_args;

  
    thread1_args.inicio = 1;
    thread1_args.final = 2500;

    thread2_args.inicio = 2501;
    thread2_args.final = 5000;

    thread3_args.inicio = 5001;
    thread3_args.final = 7500;

    thread4_args.inicio = 7501;
    thread4_args.final= 10000;


    pthread_create (&thread1_id, NULL, &suma_hilos, &thread1_args);

    pthread_create (&thread2_id, NULL, &suma_hilos, &thread2_args);

    pthread_create (&thread3_id, NULL, &suma_hilos, &thread3_args);

    pthread_create (&thread4_id, NULL, &suma_hilos, &thread4_args);


    pthread_join (thread1_id, NULL);
    pthread_join (thread2_id, NULL);
    pthread_join (thread3_id, NULL);
    pthread_join (thread4_id, NULL);

    cout<<"Resultado: "<<resultado<<"\n"; 

	pthread_exit(NULL);
	return 0;
}




