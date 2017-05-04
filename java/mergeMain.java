import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class mergeMain {
/*
run with arguments: input file(1) - output file (2) - iterations (3)
*/
	public static void main(String[] args) {
		LinkedList<Integer> intList = new LinkedList<Integer>();
		String inFile = args[0];
		String outFile = args[1];
		int itrs = Integer.parseInt(args[2]);
		
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

			Mergesort sorter = new Mergesort();

			startTime = System.nanoTime();
			
			sorter.sort(clonedList);
			
			endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			
			System.out.println(n+1 + " " + totalTime + "ns");
			
			writer.println(n+1 + "," + totalTime);
		}
        writer.close();
	}

	public static class Mergesort {
			private int[] numbers;
			private int[] helper;

			private int number;

			public void sort(int[] values) {
					this.numbers = values;
					number = values.length;
					this.helper = new int[number];
					mergesort(0, number - 1);
			}

			private void mergesort(int low, int high) {
					// check if low is smaller than high, if not then the array is sorted
					if (low < high) {
							// Get the index of the element which is in the middle
							int middle = low + (high - low) / 2;
							// Sort the left side of the array
							mergesort(low, middle);
							// Sort the right side of the array
							mergesort(middle + 1, high);
							// Combine them both
							merge(low, middle, high);
					}
			}

			private void merge(int low, int middle, int high) {

					// Copy both parts into the helper array
					for (int i = low; i <= high; i++) {
							helper[i] = numbers[i];
					}

					int i = low;
					int j = middle + 1;
					int k = low;
					// Copy the smallest values from either the left or the right side back
					// to the original array
					while (i <= middle && j <= high) {
							if (helper[i] <= helper[j]) {
									numbers[k] = helper[i];
									i++;
							} else {
									numbers[k] = helper[j];
									j++;
							}
							k++;
					}
					// Copy the rest of the left side of the array into the target array
					while (i <= middle) {
							numbers[k] = helper[i];
							k++;
							i++;
					}

			}
	}
}
