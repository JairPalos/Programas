#include <pthread.h>
#include <cstdio>
#include <iostream>
using namespace std;

struct char_print_parms{

char caracter;
int count; };

void* char_print (void* parameters) {

struct char_print_parms* p = (struct char_print_parms*)parameters;
int i;
for (i = 0; i < p->count; ++i)
cout<< p->caracter;
return NULL; }


int main (){
 pthread_t thread1_id;
 pthread_t thread2_id;
 pthread_t thread3_id;
 pthread_t thread4_id;
 
  struct char_print_parms thread1_args;
  struct char_print_parms thread2_args;
  struct char_print_parms thread3_args;
  struct char_print_parms thread4_args;
  
thread1_args.caracter = 'x';
thread1_args.count = 10000;
pthread_create (&thread1_id, NULL, &char_print, &thread1_args);

thread2_args.caracter = 'o';
thread2_args.count = 10000;
pthread_create (&thread2_id, NULL, &char_print, &thread2_args);

thread3_args.caracter = 'y';
thread3_args.count = 10000;
pthread_create (&thread3_id, NULL, &char_print, &thread3_args);

thread4_args.caracter = '|';
thread4_args.count = 10000;
pthread_create (&thread4_id, NULL, &char_print, &thread4_args);


pthread_join (thread1_id, NULL);
pthread_join (thread2_id, NULL);
pthread_join (thread3_id, NULL);
pthread_join (thread4_id, NULL);


	pthread_exit(NULL);
	
	return 0;
}




