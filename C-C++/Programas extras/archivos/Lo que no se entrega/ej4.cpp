#include <iostream>
#include <thread>

using namespace std;

void imp_ch(char, int);


int main(int argc, char *argv[]){
	
	char c = 'x';
	int k = 500;
	
	//thread t(imp_ch, c, k);
	std::thread t(imp_ch, c, k);
	t.join();
	return 0;
	
}//main

void imp_ch(char c, int n){
	
	for(int i = 0; i < n; i++){
		
		cout<<c;
		
	}//for
	
}//imp_ch
