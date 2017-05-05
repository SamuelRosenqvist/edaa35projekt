class PrimeNumberDemo
{
   public static void main(String args[])
   {
	int n = 1000000;
	int status = 1;
	int num = 3;
	double startTime;
	double endTime;

      if (n >= 1)
      {
         System.out.println("First "+n+" prime numbers are:");
         //2 is a known prime number
         System.out.println(2);
      }

	startTime = System.nanoTime();

      for ( int i = 2 ; i <=n ;  )
      {
         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
         {
            if ( num%j == 0 )
            {
               status = 0;
               break;
            }
         }
         if ( status != 0 )
         {
            System.out.println(num);
            i++;
         }
         status = 1;
         num++;
      } 

	endTime = System.nanoTime();
	double totalTime = endTime - startTime;
    System.out.println(totalTime + " ns");
   }
}
