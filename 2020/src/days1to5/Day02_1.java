package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02_1 {

	public static void main(String[] args) throws FileNotFoundException {
		int validCount = 0;
		String s = "";
		int ltrCount = 0;
		Scanner in = new Scanner(new File("res/day02_input"));
		ArrayList<String> input = new ArrayList<String>();
		while (in.hasNext()) {
			input.add(in.nextLine());
		}
		
		for (int i = 0; i < input.size(); i++) {
			s = input.get(i);
			ltrCount = 0;
			//counts the # of policy chars in the password
			for (int j = 1; j < s.substring(s.lastIndexOf(" "), s.length()).length(); j++) {
				if (s.substring(s.lastIndexOf(" ") + j, s.lastIndexOf(" ") + j + 1).equals(s.substring(s.indexOf(":")-1, s.indexOf(":")))) {
					ltrCount++;
				}
			}
			//adds to validCount if the ltrCount fits within the policy range
			//rangeLower
			int rL = Integer.parseInt(s.substring(0, s.indexOf("-")));
			//rangeUpper
			int rU = Integer.parseInt(s.substring(s.indexOf("-")+1, s.indexOf(" ")));
			if (ltrCount >= rL && ltrCount <= rU) {
				validCount++;
			}
		}
		System.out.println(validCount);
		
		in.close();
	}

}
