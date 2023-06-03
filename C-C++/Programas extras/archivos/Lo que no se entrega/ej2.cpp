#include <pthread.h>
#include <cstdio>
#include <iostream>

using namespace std;

struct char_print_parms{
	
	//El caracter a imprimir junto al número de veces que lo hará
	char caracter;
	int count;
	
};//struct

void* char_print(void* parameters){
	
	/*Convierte el puntero al tipo correcto*/
	struct char_print_parms* p = (struct char_print_parms*) parameters;
	
	for(int i = 0; i < p->count;++i){
		
		cout<<p->caracter;
		
	}//for
	
	return NULL;
	
}//char_print

int main(){
	
	/*Creación de los hilos*/
	pthread_t thread_id[3];
	
	/*pthread_t thread1_id;
	pthread_t thread2_id;
	pthread_t thread3_id;
	*/
	
	
	/*Declaración de los tipos de estructuras*/
	struct char_print_parms thread_args[3];
	
	/*
	struct char_print_parms thread1_args;
	struct char_print_parms thread2_args;
	struct char_print_parms thread3_args;
	*/
	
	/*
	Hilo uno: Imprime 10,000 "x"
	Hilo dos: Imprime 10,000 "o"
	Hilo tres: Imprime 10,000 "y"
	*/
	
	thread_args[0].caracter = 'x';
	thread_args[1].caracter = 'o';
	thread_args[2].caracter = 'y';
	
	for(int i = 0; i < 3; i++){
	
		thread_args[i].count = 10000;
		pthread_create (&thread_id[i], NULL, &char_print, &thread_args[i]);
	
	}//for
	
	/*
	thread_args[0].caracter = 'x';
	thread_args[0].count = 10000;
	pthread_create (&thread_id[0], NULL, &char_print, &thread_args[0]);
	*/
	
	
	/*
	thread_args[1].caracter = 'o';
	thread_args[1].count = 10000;
	pthread_create (&thread_id[1], NULL, &char_print, &thread_args[1]);
	*/
	
	
	/*
	thread_args[2].caracter = 'y';
	thread_args[2].count = 10000;
	pthread_create (&thread_id[2], NULL, &char_print, &thread_args[2]);
	*/
	
	/*
	pthread_join(thread_id[0], NULL);
	pthread_join(thread_id[1], NULL);
	pthread_join(thread_id[2], NULL);
	*/
	
	for(int i = 0; i < 3; i++){
		
		pthread_join(thread_id[i], NULL);
		
	}//for
	
	pthread_exit(NULL);
	
	return 0;
}//main
