package es.uniovi.eii.ds.main;

import java.io.*;

import es.uniovi.eii.ds.VirtualMachine;

public class Main {
	
	private static VirtualMachine vm = new VirtualMachine();

	public static void main(String[] args) throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("factorial.txt"));

		String line;
		while ((line = file.readLine()) != null)
			vm.loadSentence(line);
		file.close();

		vm.loadProgram();
	}	
}

// ORIGINAL MAIN CODE
/*
 * 
package es.uniovi.eii.ds.main;

import java.io.*;
import java.util.*;

public class Main {
	
	private static List<String[]> instructions = new ArrayList<>();
	private static int ip = 0;

	private static int[] memory = new int[1024];

	private static int[] stack = new int[32];
	private static int sp = 0;
	
	private static Scanner console = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		BufferedReader file = new BufferedReader(new FileReader("factorial.txt"));

		String line;
		while ((line = file.readLine()) != null)
			loadSentence(line);
		file.close();

		executeProgram();
	}

	private static void executeProgram() {
		while (ip < instructions.size()) {
			String[] sentence = instructions.get(ip);
			
			if (sentence[0].equals("push")) {
				push(Integer.parseInt(sentence[1]));
				ip++;
			} else if (sentence[0].equals("add")) {
				push(pop() + pop());
				ip++;
			} else if (sentence[0].equals("sub")) {
				push(pop() - pop());
				ip++;
			} else if (sentence[0].equals("mul")) {
				push(pop() * pop());
				ip++;
			} else if (sentence[0].equals("jmp")) {
				ip = Integer.parseInt(sentence[1]);
			} else if (sentence[0].equals("jmpg")) {
				int b = pop();
				int a = pop();
				if (a > b)
					ip = Integer.parseInt(sentence[1]);
				else
					ip++;
			} else if (sentence[0].equals("load")) {
				int address = pop();
				push(memory[address]);
				ip++;
			} else if (sentence[0].equals("store")) {
				int value = pop();
				int address = pop();
				memory[address] = value;
				ip++;
			} else if (sentence[0].equals("input")) {
				System.out.print("Enter a number: ");
				push(console.nextInt());
				ip++;
			} else if (sentence[0].equals("output")) {
				System.out.println(pop());
				ip++;
			}
		}
	}

	private static void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		instructions.add(tokens);
	}
	
	private static void push(int value) {
		stack[sp] = value;
		sp++;
	}

	private static int pop() {
		sp--;
		return stack[sp];
	}
}

 */