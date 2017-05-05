#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <chrono>
using namespace std;
using namespace std::chrono;

struct myclass {
  bool operator() (int i,int j) { return (i<j);}
} myobject;

int main() {

    vector<int> numbers;
    ifstream in("data1.txt",ios::in);

    int number;

    while (in >> number) {
        numbers.push_back(number);
    }

    in.close();

    // skapar en utfil
    ofstream myfile;
    myfile.open ("standardMain.txt");
	myfile << "itr," << " time in nanosec \n";
	

    for(int i = 0; i < 600; i++){
	
	vector<int> nbrcopy = numbers;	

        high_resolution_clock::time_point t1 = high_resolution_clock::now();

            std::sort (nbrcopy.begin(), nbrcopy.end(), myobject);

        high_resolution_clock::time_point t2 = high_resolution_clock::now();

        auto duration = duration_cast<nanoseconds>( t2 - t1 ).count();

        // skriver till utfilen
        myfile << (i+1) << ", " << duration << "\n";
    }

    //stänger utfilen
    myfile.close();
    return 0;
}
