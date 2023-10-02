package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day01_input"));
		ArrayList<Integer> input = new ArrayList<Integer>();
		while (in.hasNext()) {
			input.add(in.nextInt());
		}
		
		for (int i = 0; i < 1011; i++) {
			if (input.contains(i) && input.contains(2020-i)) {
				System.out.println(i*(2020-i));
				System.out.println(i);
				System.out.println(2020-i);
			}
		}

	}

}
