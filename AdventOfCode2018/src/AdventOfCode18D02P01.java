import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AdventOfCode18D02P01 {
	static Scanner scanner;
	private static BufferedReader br;
	
	public static void main(String[] args) throws IOException {

		try {
			br = new BufferedReader(new FileReader("C:\\Users\\skwir\\eclipse-workspace-java\\Advent of Code\\src\\input2.txt"));
		} catch (FileNotFoundException e){
			e.printStackTrace();	
		}
		
			char[] linearr = new char[26];

			int twos = 0; 
			int tris = 0;
			
		try {	
			for (String line; (line = br.readLine()) != null;){
				boolean twosflag = false;
				boolean trisflag = false;
				linearr = line.toCharArray();
				Arrays.sort(linearr, 0, linearr.length);
				
				for (int x = 0; x < linearr.length; x++) {
					int count = 0; 
					System.out.println("\n" + linearr[x]);
					for (int n = x + 1; n < linearr.length; n++) {
						System.out.print(linearr[n]);
						if (linearr[n] == linearr[x]) {
							count++;
							System.out.print(" <+1> ");
						}
					}
					if (count == 1 && twosflag == false) {
						twos++;
						twosflag = true;
						x++;
					}
					if (count == 2 && trisflag == false) {
						tris++;
						trisflag = true;
						x += 2;
					}

				}
			}

		} catch (FileNotFoundException e){
			e.printStackTrace();	
		}
		int checksum = twos * tris; 
		System.out.println(checksum);
	}
}
