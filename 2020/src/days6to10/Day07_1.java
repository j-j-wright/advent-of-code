package days6to10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07_1 {
	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day07_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HashMap<String, HashMap<String, Integer>> bags = new HashMap<>();
		Pattern outerPattern = Pattern.compile("^\\w+ \\w+");
		Pattern innerPattern = Pattern.compile("\\d+ \\w+ \\w+");
		while (in.hasNext()) {
			// saves the current line of the input
			String thisLn = in.nextLine();
			// gets the outer bag for this line
			Matcher outerMatch = outerPattern.matcher(thisLn);
			outerMatch.find();
			String outer = outerMatch.group();
			// gets the inner bags for this line
			HashMap<String, Integer> inner = new HashMap<String, Integer>();
			Matcher innerMatch = innerPattern.matcher(thisLn);
			while (innerMatch.find()) {
				String s = innerMatch.group();
				inner.put(s.substring(2), Integer.parseInt(s.substring(0, 1)));
			}
			// adds the outer bag and inner bag(s), if any, to the HashMap
			bags.put(outer, inner);
		}
		
		HashSet<String> bagsOfInterest = new HashSet<String>();
		bagsOfInterest.add("shiny gold");
		boolean allBagsFound = false;
		while (!allBagsFound) {
			allBagsFound = true;
			for (String outerBag : bags.keySet()) {
				for (String innerBag : bags.get(outerBag).keySet()) {
					if (bagsOfInterest.contains(innerBag) 
							&& !bagsOfInterest.contains(outerBag)) {
						bagsOfInterest.add(outerBag);
						allBagsFound = false;
					}
				}
			}
		}
		
		System.out.println("Size: " + (bagsOfInterest.size() - 1));		
	}
}
