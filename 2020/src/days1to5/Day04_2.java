package days1to5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Day04_2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("res/day04_input"));
		String str = "";
		String temp = "";
		while (in.hasNext()) {
			temp = in.nextLine();
			if (temp.equals("")) {
				str += "$";
			} else {
				str += temp + " ";
			}
		}

		String[] passports = str.split(" \\$");
		int validCount = 0;
		
		for (String s : passports) {
			String[] cats = s.split(" ");
			boolean isValid = true;
			if (!(s.contains("byr")&&s.contains("iyr")&&s.contains("eyr")&&s.contains("hgt")&&s.contains("hcl")&&s.contains("ecl")&&s.contains("pid"))) isValid = false;
			for (String i : cats) {
				if (i.substring(0, 3).equals("byr") && (Integer.parseInt(i.substring(4, i.length())) < 1920 || Integer.parseInt(i.substring(4, i.length())) > 2002) ) isValid = false;
				if (i.substring(0, 3).equals("iyr") && (Integer.parseInt(i.substring(4, i.length())) < 2010 || Integer.parseInt(i.substring(4, i.length())) > 2020) ) isValid = false;
				if (i.substring(0, 3).equals("eyr") && (Integer.parseInt(i.substring(4, i.length())) < 2020 || Integer.parseInt(i.substring(4, i.length())) > 2030) ) isValid = false;
				if (i.substring(0, 3).equals("hgt")) {
					if (!Pattern.matches("cm|in", i.substring(i.length()-2, i.length()))) isValid = false;
					if (Pattern.matches("in", i.substring(i.length()-2, i.length())) && (Integer.parseInt(i.substring(4, i.length()-2)) < 59 || Integer.parseInt(i.substring(4, i.length()-2)) > 76)) isValid = false;
					if (Pattern.matches("cm", i.substring(i.length()-2, i.length())) && (Integer.parseInt(i.substring(4, i.length()-2)) < 150 || Integer.parseInt(i.substring(4, i.length()-2)) > 193)) isValid = false;
				}
				if (i.substring(0, 3).equals("hcl") && (i.charAt(4)!='#' || !Pattern.matches("([0-9]|[abcdef]){6}", i.substring(5, i.length())))) isValid = false;
				if (i.substring(0, 3).equals("ecl") && !Pattern.matches("amb|blu|brn|gry|grn|hzl|oth", i.substring(4, 7))) isValid = false;
				if (i.substring(0, 3).equals("pid") && !Pattern.matches("[0-9]{9}", i.substring(4, i.length()))) isValid = false;
			}
			if (isValid == true) {
				validCount++;
			}
		}
		
		System.out.println(validCount);

		in.close();
	}

}
