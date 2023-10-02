package days11to15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day12 {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day12_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<String> c = new ArrayList<String>();
		while (in.hasNext()) {
			c.add(in.nextLine());
		}

		System.out.println(p1(c));
		System.out.println(p2(c));
		}

	private static int p1(ArrayList<String> c) {
		int x = 0;
		int y = 0;
		int h = 0; // starts on +x axis
		for (String s : c) {
			if (s.substring(0, 1).equals("N")) {
				y += Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("S")) {
				y -= Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("E")) {
				x += Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("W")) {
				x -= Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("R")) {
				h -= Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("L")) {
				h += Integer.parseInt(s.substring(1));
			} else if (s.substring(0, 1).equals("F")) {
				if (Math.floorMod(h, 360) == 0) {
					x += Integer.parseInt(s.substring(1));
				} else if (Math.floorMod(h, 360) == 90) {
					y += Integer.parseInt(s.substring(1));
				} else if (Math.floorMod(h, 360) == 180) {
					x -= Integer.parseInt(s.substring(1));
				} else {
					y -= Integer.parseInt(s.substring(1));
				}
			}
		}
		return Math.abs(x) + Math.abs(y);
	}

	private static int p2(ArrayList<String> c) {
		int x = 0;
		int y = 0;
		int wx = 10; // relative distance from ship to waypoint
		int wy = 1;

		for (String s : c) {
			String o = s.substring(0, 1);
			int d = Integer.parseInt(s.substring(1));
			if (o.equals("N")) {
				wy += d;
			} else if (o.equals("S")) {
				wy -= d;
			} else if (o.equals("E")) {
				wx += d;
			} else if (o.equals("W")) {
				wx -= d;
			} else if (o.equals("R")) {
				int wxo = wx;
				int wyo = wy;
				wx = (int) (wxo * Math.round(Math.cos(Math.toRadians(-d))) - wyo * Math.round(Math.sin(Math.toRadians(-d))));
				wy = (int) (wxo * Math.round(Math.sin(Math.toRadians(-d))) + wyo * Math.round(Math.cos(Math.toRadians(-d))));
			} else if (o.equals("L")) {
				int wxo = wx;
				int wyo = wy;
				wx = (int) (wxo * Math.round(Math.cos(Math.toRadians(d))) - wyo * Math.round(Math.sin(Math.toRadians(d))));
				wy = (int) (wxo * Math.round(Math.sin(Math.toRadians(d))) + wyo * Math.round(Math.cos(Math.toRadians(d))));
			} else if (o.equals("F")) {
				x += d * wx;
				y += d * wy;
			}
		}

		return Math.abs(x) + Math.abs(y);
	}

}
