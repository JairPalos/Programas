#include <iostream>
#include <tbb/tbb.h>

using namespace std;
using namespace tbb;

int main(int argc, char*argv[]){
 tbb::parallel_invoke(
 	[](){cout<<"Hello desde";},
 	[](){cout<<"tbb";},
	[](){cout<<"entre lineas";}
	);

return 0;

}

