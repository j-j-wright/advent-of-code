package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day01_input"));
		ArrayList<Integer> input = new ArrayList<Integer>();
		while (in.hasNext()) {
			input.add(in.nextInt());
		}
		
		boolean isFound = false;

		for (int i = 0; i < 2020; i++) {
			if (input.contains(i)) {
				for (int j = 0; j < 2020; j++) {
					if (input.contains(j)) {
						for (int k = 0; k < 2020; k++) {
							if (input.contains(k) && i + j + k == 2020) {
								System.out.println(i + " " + j + " " + k + " " + (i * j * k));
								isFound = true;
							}
						}
						if (isFound == true) break;
					}
				}
			}
			if (isFound == true) break;
		}

	}

}
