import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AdventofCode18D01P02 {
	
	static int flag = -1;
	static int ln = 0;
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader br;


		
		//Find number of lines in a file to determine the length of array
		try {
			br = new BufferedReader(new FileReader("C:\\Code\\input.txt"));
			while (br.readLine() != null) {
				ln++;
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();	
		}
		
		//create arrays
		int [] tempArray = new int[ln];
		int [] suma = new int [tempArray.length];
		int k = 0;
		
		//read values from a file to an array
		try {
			int i = 0;
			br = new BufferedReader(new FileReader("C:\\Code\\input.txt"));
			
			for (String line; (line = br.readLine()) != null;){
				tempArray [i] = Integer.parseInt(line);
				//System.out.println(tempArray[i]);
				i++;
			}
		}catch (FileNotFoundException e){
			e.printStackTrace();	
		}

		int l = 0; 
		// sum the changes from the org array to a new array
		while (flag == -1) {
			l++;
			for (int i = 0; i < tempArray.length; i++) {
				if (i<1) {
					suma[k] += tempArray[0];
				}
				if(k>0) {
					suma[k] = suma[k-1] + tempArray[i];
				}
				k++;
			}
		
		//call a method to find a recurrence and print value
			flag = findRecurrence(suma, tempArray.length);
			suma = Arrays.copyOf(suma, ((suma.length)+(tempArray.length)));
		}
		System.out.println("Suma zmian: " + suma[tempArray.length - 1]);
		System.out.print("Wynik: " + suma[flag]);
		System.out.println(" @ index: " + flag + ", has taken: " + l + " loops");
	}
	
	//Returns an index of the first repeated value in an array
	public static int findRecurrence(int[] arr, int leng) {	
		int n = 0;
		int m = 0;
		int lastm = arr.length;
		int idx = -1;
		
		for(n = 0; n < leng; n++) {
			for(m = 0; m < arr.length; m++){
				if (arr[n] == arr[m] && n != m) {
					if (m <= lastm) {
						lastm = m;
						idx = m;
					}
				}
            }
        }
		return idx;
	}
}
	
