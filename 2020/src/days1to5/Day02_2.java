package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02_2 {

	public static void main(String[] args) throws FileNotFoundException {
		int validCount = 0;
		Scanner in = new Scanner(new File("res/day02_input"));
		ArrayList<String> input = new ArrayList<String>();
		while (in.hasNext()) {
			input.add(in.nextLine());
		}
		
		for (int i = 0; i < input.size(); i++) {
			String s = input.get(i);
			
			int i1 = Integer.parseInt(s.substring(0, s.indexOf("-"))); //index1
			String s1 = s.substring(s.lastIndexOf(" ")+i1, s.lastIndexOf(" ")+i1+1); //character at index 1
			
			int i2 = Integer.parseInt(s.substring(s.indexOf("-")+1, s.indexOf(" "))); //index2
			String s2 = s.substring(s.lastIndexOf(" ")+i2, s.lastIndexOf(" ")+i2+1); //character at index 2
			
			String c = s.substring(s.lastIndexOf(":")-1, s.lastIndexOf(":")); //char of interest
			
			if (!s1.equals(s2) && (s1.equals(c) || s2.equals(c))) validCount++;
		}
		System.out.println(validCount);
		
		in.close();

	}

}
