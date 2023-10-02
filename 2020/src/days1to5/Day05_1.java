package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day05_1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day05_input"));
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		while (in.hasNext()) {
			String input = in.nextLine().replaceAll("F|L", "0").replaceAll("B|R", "1");
			// First 7 chars indicate row #, last 3 indicate col #
			rows.add(Integer.parseInt(input.substring(0, 7), 2));
			cols.add(Integer.parseInt(input.substring(7, 10), 2));
		}
		
		// Find the maximum ID
		int maxSeatID = Integer.MIN_VALUE;
		for (int i = 0; i < rows.size(); i++) {
			maxSeatID = Math.max(rows.get(i) * 8 + cols.get(i), maxSeatID);
		}
		
		System.out.println(maxSeatID);
		
		in.close();
	}

}
