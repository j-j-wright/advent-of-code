package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day03_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day03_input"));
		ArrayList<String> input = new ArrayList<String>();
		// read input
		while (in.hasNext()) {
			input.add(in.nextLine());
		}
		
		System.out.println(getNumTrees(1, 1, input) * getNumTrees(3, 1, input)
				* getNumTrees(5, 1, input) * getNumTrees(7, 1, input) 
				* getNumTrees(1, 2, input));
		
		in.close();
	}
	
	/**
	 * getNumTrees calculates the # of trees hit
	 * @param over: # of spaces to travel over
	 * @param down: # of spaces to travel down
	 * @param in: contains the locations of the trees
	 * @return the number of trees hit
	 */
	public static long getNumTrees(int over, int down, ArrayList<String> in) {
		int index = 0;
		long treeCounter = 0;
		for (int i = 0; i < in.size(); i+= down) {
			String s = in.get(i);
			if (s.charAt(index)=='#') treeCounter++;
			
			index = (index+over)%s.length();
		}
		return treeCounter;
	}

}
