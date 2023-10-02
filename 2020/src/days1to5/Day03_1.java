package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day03_input"));
		ArrayList<String> input = new ArrayList<String>();
		while (in.hasNext()) {
			input.add(in.nextLine());
		}
		int treeCounter = 0; // number of trees hit
		int index = 0;
		
		for (int i = 0; i < input.size(); i++) {
			String s = input.get(i);
			if (s.charAt(index)=='#') treeCounter++;
			/* shifts the index over by 3, and wraps it around to the beginning
			 * when it becomes larger than the width of the input */
			index = (index + 3) % s.length();
		}
		System.out.println(treeCounter);
		in.close();
	}

}
