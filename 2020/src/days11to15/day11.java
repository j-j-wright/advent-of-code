package days11to15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day11 {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day11_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// 0 floor, 1 unoccupied, 2 occupied
		
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		while (in.hasNext()) {
			String s = in.nextLine();
			ArrayList<Integer> r = new ArrayList<Integer>();
			for(int i = 0; i < s.length(); i++) {
				if (s.substring(i, i + 1).equals(".")) {
					r.add(0);
				} else {
					r.add(1);
				}
			}
			l.add(r);
		}
		
		System.out.println(p1(l));
		System.out.println(p2(l));

	}
	public static int p1(ArrayList<ArrayList<Integer>> l) {
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> curr = l;
		while(!prev.equals(curr)) {
			prev = curr;
			curr = move(curr);
		}
		return countOccupied(curr);
	}
		
	private static ArrayList<ArrayList<Integer>> move(ArrayList<ArrayList<Integer>> l) {
		ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
		for (int c = 0; c < l.size(); c++) {
			ArrayList<Integer> newR = new ArrayList<Integer>();
			for (int r = 0; r < l.get(0).size(); r++) {
				if (l.get(c).get(r) == 1 && countAdjOcc(l, c, r) == 0) {
					newR.add(2);
				} else if (l.get(c).get(r) == 2 && countAdjOcc(l, c, r) >= 4) {
					newR.add(1);
				} else {
					newR.add(l.get(c).get(r));
				}
			}
			n.add(newR);
		}
		return n;
	}
	
	private static int countAdjOcc(ArrayList<ArrayList<Integer>> l, int c, int r) {
		int no = 0;
		try {
			if (l.get(c - 1).get(r - 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c - 1).get(r) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c - 1).get(r + 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c).get(r - 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c).get(r + 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c + 1).get(r - 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c + 1).get(r) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		try {
			if (l.get(c + 1).get(r + 1) == 2) { no++;}
		} catch(IndexOutOfBoundsException e) {}
		
		return no;
	}
	
	public static int p2(ArrayList<ArrayList<Integer>> l) {
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> curr = l;
		while(!prev.equals(curr)) {
			prev = curr;
			curr = move2(curr);
		}
		return countOccupied(curr);
	}
	
	private static ArrayList<ArrayList<Integer>> move2(ArrayList<ArrayList<Integer>> l) {
		ArrayList<ArrayList<Integer>> n = new ArrayList<ArrayList<Integer>>();
		for (int c = 0; c < l.size(); c++) {
			ArrayList<Integer> newR = new ArrayList<Integer>();
			for (int r = 0; r < l.get(0).size(); r++) {
				if (l.get(c).get(r) == 1 && countAdjOcc2(l, c, r) == 0) {
					newR.add(2);
				} else if (l.get(c).get(r) == 2 && countAdjOcc2(l, c, r) >= 5) {
					newR.add(1);
				} else {
					newR.add(l.get(c).get(r));
				}
			}
			n.add(newR);
		}
		return n;
	}
	
	private static int countAdjOcc2(ArrayList<ArrayList<Integer>> l, int c, int r) {
		return aux(l, c, r, -1, -1) + aux(l, c, r, -1, 0) + aux(l, c, r, -1, 1)	
		+ aux(l, c, r, 0, -1) + aux(l, c, r, 0, 1)	
		+ aux(l, c, r, 1, -1) + aux(l, c, r, 1, 0) + aux(l, c, r, 1, 1);
	}
	
	private static int aux(ArrayList<ArrayList<Integer>> l, int c, int r, int cInc, int rInc) {
		c += cInc;
		r += rInc;
		if (c < 0 || c >= l.size() || r < 0 || r >= l.get(0).size()){
			return 0;
		} else if (l.get(c).get(r) == 1) {
			return 0;
		} else if (l.get(c).get(r) == 2) {
			return 1;
		} else { // Must be floor
			return aux(l, c, r, cInc, rInc);
		}
	}

	/**
	 * countOccupied counts the number of occupied seats
	 * @param l: 2D ArrayList of the seat layout
	 * @return: the number of occupied seats
	 */
	private static int countOccupied(ArrayList<ArrayList<Integer>> l) {
		int count = 0;
		for (ArrayList<Integer> a : l) {
			for(int b : a) {
				if (b == 2) {
					count++;
				}
			}
		}
		return count;
	}
	
	/**
	 * out converts l back into the format of the input. Useful for debugging
	 * @param l: seat layout
	 */
	private static void out(ArrayList<ArrayList<Integer>> l) {
		for (ArrayList<Integer> i : l) {
			for (int j : i) {
				switch (j) {
				case 0:
					System.out.print(".");
					break;
				case 1: 
					System.out.print("L");
					break;
				case 2:
					System.out.print("#");
					break;
				}
			}
			System.out.println();
		}
	}
}
