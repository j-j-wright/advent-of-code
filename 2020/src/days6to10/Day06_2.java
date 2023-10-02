package days6to10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Day06_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day06_input"));
		String str = "";
		String temp = "";
		ArrayList<Integer> peopleCounter = new ArrayList<Integer>();
		for (int i = 0; i < 2167; i++) {
			peopleCounter.add(0);
		}
		
		int groupIndex = 0;
		while (in.hasNext()) {
			temp = in.nextLine();
			if (temp.equals("")) {
				str += "$";
				groupIndex++;
			} else {
				str += temp;
				peopleCounter.set(groupIndex, peopleCounter.get(groupIndex) + 1);
			}
		}
		
		ArrayList<Integer> pC = new ArrayList<Integer>();
		for (int i : peopleCounter) {
			if (i > 0) {
				pC.add(i);
			} else {
				break;
			}
		}

		int sum = 0;
		int ansCount = 0;
		String[] answers = str.split("\\$");
		for (int i = 0; i < answers.length; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				for (int k = 0; k < answers[i].length(); k++) {
					if (answers[i].charAt(k) == j)
						ansCount++;
				}
				if (ansCount == pC.get(i)) {
					sum++;
				}
				ansCount = 0;
			}
		}

		System.out.println(sum);
	}

}
