import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AdventofCode18D01P01 {
	private static Scanner s;
	private static BufferedReader br;
	static char sign = '0';
	static int sum = 0;
	static int tmp = 0;
	
	public static void main (String[] args) throws IOException {
		
		try {
			br = new BufferedReader(new FileReader("C:\\Code\\input.txt"));
			for (String line; (line = br.readLine()) != null;){
				
				s = new Scanner(line);
				sign = s.next().charAt(0);
				//System.out.println(sign);
				tmp = Integer.parseInt(line);
				//System.out.println(tmp);
				
				switch (sign) {
				case '+':
					//System.out.print(sum + "+" + tmp);
					sum += tmp;
					break;
				case '-':
					//System.out.print(sum +""+ tmp);
					sum += tmp;
					break;
				}
				//System.out.println(" = " + sum);
			}
			System.out.println("Wynik to: " + sum);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}finally {
			s.close();
			br.close();
		}
		
		
	}
	
}
