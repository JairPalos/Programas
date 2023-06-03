#include <iostream>
#include <fstream>
#include <vector>
#include <iterator>
#include <thread>
#include <algorithm>
using namespace std;

void impl_elm(vector<int> X, int r){
	int i;
	cout<<X.size()<<"Dimension"<<endl;
	for(i=0;i<r;i++)
		cout<<X.at(i)<<","<<endl;
}

int main(int argc,char * argv[]){
	int rn,i,x,y,it;
	rn=atoi(argv[3]);
	vector<int> V;
	vector<int> W;
	fstream f1,f2;
	f1.open(argv[1],ios::in);
	f2.open(argv[2],ios::in);


	for(i=0;i<rn;i++)
	{f1>> x;
	V.push_back(x);}

	for(i=0;i<rn;i++)
	{f2>> y;
	W.push_back(y);}

	thread t1(&impl_elm,V,200);
	thread t2(&impl_elm,W,200);

	t1.join();
	t2.join();

return 0;
	}










