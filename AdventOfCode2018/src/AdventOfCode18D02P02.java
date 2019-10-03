import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class AdventOfCode18D02P02 {
	private static LineNumberReader lr;
	private static LineNumberReader lr2;
	
	static char[] compareArrays(char[] arr_1, char[] arr_2) {
		
		char[] finalArray = new char[(arr_1.length)];
		int n=0;
		
		for(int i = 0; i < arr_1.length; i++) {
			if(arr_1[i] == arr_2[i]) {
				finalArray[i] = arr_1[i];
				n++;
			}else {
				finalArray[i] = '_';
			}
		}
		if (n == 25) {
			return finalArray;			
		}else {
			return null;
			
		}
	}
	
	public static void main(String[] args) throws IOException {
		try {
			lr = new LineNumberReader(new FileReader("C:\\Users\\skwir\\eclipse-workspace-java\\Advent of Code\\src\\input2.txt"));
		} catch (FileNotFoundException e){
			e.printStackTrace();	
		}
		
		/*try {
			br2 = new BufferedReader(new FileReader("C:\\Users\\skwir\\eclipse-workspace-java\\Advent of Code\\src\\input2.txt"));
		} catch (FileNotFoundException e){
			e.printStackTrace();	
		}*/
		
		char[] arr1 = new char[26];
		char[] arr2 = new char[26];
		char[] result = new char[26];
		
		try {	
			for (String line; (line = lr.readLine()) != null;){
				//System.out.println("first arr line: " + lr.getLineNumber());

				arr1 = line.toCharArray();
				try {
					lr2 = new LineNumberReader(new FileReader("C:\\Users\\skwir\\eclipse-workspace-java\\Advent of Code\\src\\input2.txt"));
				} catch (FileNotFoundException e){
					e.printStackTrace();	
				}
				for (String line2; (line2 = lr2.readLine()) != null;){
					//System.out.println("second line no:" + lr2.getLineNumber());
					arr2 = line2.toCharArray();
					if(compareArrays(arr1,arr2) != null) {
						System.out.println("Line: " + lr.getLineNumber() + " & line: " + lr2.getLineNumber());	
						result = compareArrays(arr1,arr2);
						for(int i = 0; i < 26; i++) {
							System.out.print(result[i]);
						}
						System.out.println("");
					}
				}
				lr2.close();
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
}