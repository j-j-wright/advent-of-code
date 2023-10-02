package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day04_1 {

	public static void main(String[] args) throws FileNotFoundException {
		// Read in input
		Scanner in = new Scanner(new File("res/day04_input"));
		String str = "";
		String temp = "";
		while (in.hasNext()) {
			temp = in.nextLine();
			if (temp.equals("")) {
				str += "$";
			} else {
				str += temp + " ";
			}
		}
		
		String[] passports = str.split(" \\$");
		int validCount = 0;
		
		// Check whether each passport is valid, and count up the valid ones
		for (String s:passports) {
			if (s.contains("byr") && s.contains("iyr") && s.contains("eyr") 
					&& s.contains("hgt") && s.contains("hcl") 
					&& s.contains("ecl") && s.contains("pid")) validCount++;
		}
		
		System.out.println(validCount);
		
		in.close();
	}

}
