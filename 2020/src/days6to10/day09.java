package days6to10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class day09 {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day09_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Long> numbers = new ArrayList<Long>();
		while (in.hasNext()) {
			numbers.add(in.nextLong());
		}
		int preamble = 25;

		System.out.println(partOne(numbers, preamble)); 
		System.out.println(partTwo(numbers, preamble, 
				partOne(numbers, preamble)));
	}
	
	public static long partOne(ArrayList<Long> list, int preamble) {
		LinkedList<Long> prior = new LinkedList<Long>();
		for (int i = 0; i < list.size(); i++) {
			if (i < preamble) {
				prior.add(list.get(i));
			} else {
				if (isSum(list.get(i), prior)) {
					prior.remove();
					prior.add(list.get(i));
				} else {
					return list.get(i);
				}
				/*
				 * if there's no sum, return list.get(i). 
				 * otherwise, remove from prior, add list.get(i)
				 */
			}
		}
		
		return 0;
	}
	
	public static boolean isSum(Long curr, LinkedList<Long> prior) {
		for (Long x : prior) {
			for (Long y : prior) {
				if (x != y && x + y == curr) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static long partTwo(ArrayList<Long> list, int preamble, long num) {
		for(int i = 0; i < list.indexOf(num); i++) {
			long sum = 0;
			for (int j = i; j < list.indexOf(num); j++) {
				sum += list.get(j);
				if (sum == num) {
					List<Long> sumList = list.subList(i, j + 1);
					Collections.sort(sumList);
					return sumList.get(0) + sumList.get(sumList.size() - 1);
				}
			}
		}
		return 0;
	}

}
