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
    ifstream in("data.txt",ios::in);

    int number;
    
    while (in >> number) {
        numbers.push_back(number);
    }

    in.close();

    // skapar en utfil
    ofstream myfile;
    myfile.open ("standardMain.txt");
    
    for(int i = 0; i < 100; i++){

        high_resolution_clock::time_point t1 = high_resolution_clock::now();
        
            std::sort (numbers.begin(), numbers.end(), myobject);

        high_resolution_clock::time_point t2 = high_resolution_clock::now();

        auto duration = duration_cast<microseconds>( t2 - t1 ).count();

        // skriver till utfilen
        myfile << duration << "\n";
    }
    
    //stänger utfilen
    myfile.close();
    return 0;
}