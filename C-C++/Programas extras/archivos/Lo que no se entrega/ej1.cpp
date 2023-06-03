#include <iostream>
#include <pthread.h>
#include <cstdlib>

using namespace std;

void* print_xs(void* unused){

	while(1){
	
		cout<<"x";
	
	}//while
	
	return NULL;

}//print_xs


int main(){

	pthread_t th_id;
	pthread_create (&th_id, NULL, &print_xs, NULL);
	
	while(1){

		cout<<"o";

	}//while

	return 0;
	
}//main
