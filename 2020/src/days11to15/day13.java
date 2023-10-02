package days11to15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class day13 {
	
	// NOTE: part two is incomplete

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day13_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int time = in.nextInt();
		int w = Integer.MAX_VALUE; // lowest time waiting so far
		int n = -1; // bus number for lowest time waiting
		String[] arr = in.next().split(",");
		for (String s : arr) {
			if (!s.equals("x")) {
				int i = Integer.parseInt(s);
				if ((i - time % i) < w) {
					w = i - time % i;
					n = i;
				}
			}
		}
		System.out.println("part one: " + w * n);
		
		
		
//		boolean found = false;
////		long t = (long) (19 * 1e12);
//		long t = 0;
//		while (!found) {
//			found = true;
//			for (int i = 0; i < arr.length; i++) {
//				if (!arr[i].equals("x")) {
//					int o = Integer.parseInt(arr[i]);
//					if ((o - t % o) != i) {
//						found = false;
//						break;
//					}
//				}
//			}
////			t+= 19;
//			t++;
//			if (t > 1068781) {
//				break;
//			}
//		}
//		System.out.println(t);
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		ArrayList<Integer> offsets = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!arr[i].equals("x")) {
				nums.add(Integer.parseInt(arr[i]));
				offsets.add(i);
			}
		}
		
		TreeMap<Long, Long> tm = new TreeMap<Long, Long>();
		for (int i = 0; i < nums.size(); i++) {
			tm.put((long) nums.get(i), (long) offsets.get(i));
		}
		
		long mult = tm.descendingKeySet().first();
		long tim = (long) (mult * 1e11 - tm.get(mult));
		tm.remove(mult);
		for (long v : tm.descendingKeySet()) {
			System.out.println(v);
			mult *= v;
			while ((tim + tm.get(v)) % v != 0) {
				tim += mult;
			}
			if (tim < 0) {
				break;
			}
		}
		
		System.out.println(tim);
		
		/*
		 * start with the largest two bus numbers, find a time that satisfies both of them
		 * find multiples of said time until one satisfies the third-largest number as well
		 * take the next-largest number
		 */
		
		/*
		 * not optimized approach:
		 * start at t = 0
		 * increment t by the first bus number
		 * check if everything lines up
		 */

	}

}
