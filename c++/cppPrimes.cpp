#include<iostream> // library for basic input/output functions
#include<cmath> // library for using math functions
#include <chrono>
 
using namespace std;
using namespace std::chrono;
 
int main()
{
   int n, status = 1, num = 3, count, c;
   n = 1000000;
 
   // input is valid display first prime number
   
      cout << 2 << endl;
   
	high_resolution_clock::time_point t1 = high_resolution_clock::now();

   for ( count = 2 ; count <=n ;  ) //loop that will iterate through n numbers
   {
      for ( c = 2 ; c <= (int)sqrt(num) ; c++ )// for each element check whether it is prime or not
      {
        //if number is completely divisible by a number other than 1 and itselft,then number is not prime
         if ( num%c == 0 ) 
         {
            status = 0;
            break;
         }
      }
      //if it is a prime number, print it
      if ( status != 0 )
      {
         cout << num << endl;
         count++;
      }
      status = 1;
      num++;
   }     

	high_resolution_clock::time_point t2 = high_resolution_clock::now();    
	auto duration = duration_cast<nanoseconds>( t2 - t1 ).count();
	cout << duration << " nanoseconds";
 
   return 0;
}
