import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class standardMain {

	public static void main(String[] args) {
		LinkedList<Integer> intList = new LinkedList<Integer>();
		String inFile = "data1.txt";
		String outFile = "standardMain.txt";
		int itrs = 600; //Integer.parseInt(args[2]);
		
		/*
		 * Läser in talen från en fil och lägger de i en lista.
		 */
		Scanner scan = null;
		try {
			scan = new Scanner(new File(inFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scan.hasNext()){
			intList.add(scan.nextInt());
		}
		
		/*
		 * Skapar utfilen.
		 */
		PrintWriter writer = null;
		try{
			writer = new PrintWriter(outFile, "UTF-8");
			writer.println("Itr," + "time in ns");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		/*
		 * Sorterar listan n ggr.
		 */
		for(int n = 0; n < itrs; n++){
            @SuppressWarnings("unchecked")
			LinkedList<Integer> clonedList = (LinkedList<Integer>) intList.clone();
			double startTime;
			double endTime;
			startTime = System.nanoTime();
			
			clonedList.sort((x,y)->x.compareTo(y));
			
			endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			
			System.out.println(n+1 + " " + totalTime + "ns");
			
			writer.println(n+1 + "," + totalTime);
		}
        writer.close();
	}

}
