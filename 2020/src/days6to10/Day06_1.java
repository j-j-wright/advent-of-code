package days6to10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day06_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day06_input"));
		String str = "";
		String temp = "";
		while (in.hasNext()) {
			temp = in.nextLine();
			if (temp.equals("")) {
				str += "$"; // Separate groups with $ to be split upon later
			}else {
				str += temp;
			}
		}
		
		// Compute the sum
		int sum = 0;
		String[] answers = str.split("\\$"); // Split groups on $
		for (String i : answers) {
			String foo = "";
			for (int j = 0; j < i.length(); j++) {
				if (!foo.contains(i.substring(j, j+1))) foo += i.substring(j, j+1);
			}
			sum += foo.length();
		}
		
		System.out.println(sum);
	}
}
