#include <iostream>
#include <vector>
#include <fstream>
#include <iterator>

using namespace std;
vector <int> ifstream_lines(ifstream& fs)
{

	vector<int> out;
	int temp,i;
	while(fs>>temp)
	{
		out.push_back(temp);
	}
	return out;
}

int main(int argc,char *argv[]){
	std::vector<int> V;
	std::ifstream fs(argv[1]);
	V=ifstream_lines(fs);
	int i;
	for(i=0;i<V.size();++i){
	 cout<<V[i]<<" , "<<endl;
	}
	return 0;



}
