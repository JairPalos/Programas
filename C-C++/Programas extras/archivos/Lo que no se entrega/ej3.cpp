#include <iostream>
#include <thread>

using namespace std;

void imp_chr(void *S);

struct para{
	
	char ch;
	int n;
	
};//struct

int main(int argc, char *argv[]){
	
	struct para parms[2];
	
	parms[0].ch = 'x';
	parms[0].n = 500;
	
	parms[1].ch = 'o';
	parms[1].n = 600;
	
	thread th1(imp_chr, parms[0]);
	thread th2(imp_chr, parms[1]);
	
	th1.join();
	th2.join();
	
}//main
