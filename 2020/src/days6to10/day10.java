package days6to10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class day10 {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day10_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		while(in.hasNext()) {
			nums.add(in.nextInt());
		}
		
		System.out.println(partOne(nums));
		System.out.println(partTwo(nums));

	}
	
	public static int partOne(ArrayList<Integer> nums) {
		int numOneDiff = 0;
		int numThreeDiff = 0;
		Collections.sort(nums);
		System.out.println(nums);
		int prior = 0;
		for (int i = 0; i < nums.size(); i++) {
			switch (nums.get(i) - prior) {
			case 1:
				numOneDiff++;
				break;
			case 3:
				numThreeDiff++;
				break;
			}
			prior = nums.get(i);
		}
		numThreeDiff++;
		
		return numOneDiff * numThreeDiff;
	}
	
	public static long partTwo(ArrayList<Integer> nums) {
		ArrayList<Integer> diffs = new ArrayList<Integer>();
		nums.add(0, 0);
		for(int i = 0; i < nums.size() - 1; i++) {
			diffs.add(nums.get(i + 1) - nums.get(i));
		}
		diffs.add(3);
		System.out.println(diffs);
		
		// the max number of ones in a row is 4
		
		long numOrderings = 1;
		int numOnes = 0;
		for (int i = 0; i < diffs.size(); i++) {
			switch (diffs.get(i)) {
			case 1:
				numOnes++;
				break;
			case 3:
				switch (numOnes) {
				case 2:
					numOrderings *= 2;
					break;
				case 3:
					numOrderings *= 4;
					break;
				case 4:
					numOrderings *= 7;
					break;
				}
				numOnes = 0;
				break;
			}
		}
		
		return numOrderings;
	}

}
