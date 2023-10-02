package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Day05_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day05_input"));
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		while (in.hasNext()) {
			String input = in.nextLine().replaceAll("F|L", "0").replaceAll("B|R", "1");
			rows.add(Integer.parseInt(input.substring(0, 7), 2));
			cols.add(Integer.parseInt(input.substring(7, 10), 2));
		}
		
		// Compute all the IDs
		ArrayList<Integer> IDs = new ArrayList<Integer>();
		for (int i = 0; i < rows.size(); i++) {
			IDs.add(rows.get(i) * 8 + cols.get(i));
		}
				
		for (int i = 0; i < 120*8; i++) {
			if (!IDs.contains(i) && IDs.contains(i-1) && IDs.contains(i+1)) {
				System.out.println(i);
				break;
			}
		}
		
		in.close();
		//answer: Seat ID 527
	}

}
