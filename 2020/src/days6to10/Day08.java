package days6to10;

import java.io.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Day08 {

	public static void main(String[] args) {
		Scanner in = null;
		try {
			in = new Scanner(new File("res/day08_input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<Command> bootCode = new ArrayList<Command>();
		
		while(in.hasNext()) {
			String line = in.nextLine();
			CommandType t = line.substring(0, 3).equals("nop") 
					? CommandType.nop : line.substring(0, 3).equals("acc")
							? CommandType.acc : CommandType.jmp;
			int value = Integer.parseInt(line.substring(4));
			bootCode.add(new Command(t, value));
		}
		
		System.out.println(partOne(bootCode)); 
		// Reset bootCode for part two
		for(Command c : bootCode) {
			c.isExecuted = false;
		}
		System.out.println(partTwo(bootCode));
		
		
	}
	
	public static int partOne(ArrayList<Command> bootCode) {
		int acc = 0;
		int index = 0;
		/* Find the value of the accumulator just before any instruction is 
		 * executed a second time */
		while(bootCode.get(index).isExecuted == false) {
			bootCode.get(index).isExecuted = true;
			switch (bootCode.get(index).type) {
			case nop:
				index++;
				break;
			case acc:
				acc += bootCode.get(index++).value;
				break;
			case jmp:
				index += bootCode.get(index).value;
				break;
			}
		}
		return acc;
	}
	
	public static int partTwo(ArrayList<Command> bootCode) {
		int acc = 0;
		int oldIndex = 0;
		int index = 0;
		while (true) {
			bootCode.get(index).isExecuted = true;
			switch (bootCode.get(index).type) {
			case nop:
				oldIndex = index;
				index += bootCode.get(index).value;
				Optional<Integer> opt = partTwoAux(bootCode, acc, index);
				if (opt.isPresent()) {
					return opt.get();
				} else {
					index = oldIndex;
					index++;
				}
				break;
			case acc:
				acc += bootCode.get(index++).value;
				break;
			case jmp:
				index++;
				Optional<Integer> opt2 = partTwoAux(bootCode, acc, index);
				if (opt2.isPresent()) {
					return opt2.get();
				} else {
					index += bootCode.get(--index).value - 1;
				}
				break;
			}
		}
		/*
		 * for each step taken:
		 * 	if acc, proceed as normal
		 *  if nop or jmp, try the other there and run through till you get to index ==
		 *  the length of bootCode (in which case return acc) or a command tries
		 *  to execute for a second time, in which leave that instruction and go forward
		 */
	}
	
	public static Optional<Integer> partTwoAux(ArrayList<Command> bootCode, int acc, int index) {
		while(index < bootCode.size() && bootCode.get(index).isExecuted == false) {
			bootCode.get(index).isExecuted = true;
			switch (bootCode.get(index).type) {
			case nop:
				index++;
				break;
			case acc:
				acc += bootCode.get(index++).value;
				break;
			case jmp:
				index += bootCode.get(index).value;
				break;
			}
		}
		return index == bootCode.size() ? Optional.of(acc) : Optional.empty();
	}
}

class Command{
	CommandType type;
	int value;
	boolean isExecuted;
	public Command(CommandType type, int value) {
		this.type = type;
		this.value = value;
		isExecuted = false;
	}
	
	@Override
	public String toString() {
		return type + " " + value + " " + isExecuted;
	}
}

enum CommandType {
	nop, acc, jmp
}

