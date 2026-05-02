package es.uniovi.eii.ds;

import java.util.*;
import es.uniovi.eii.ds.instructions.*;

public class VirtualMachine {

    private static List<Instruction> instructions = new ArrayList<>();
	private static Scanner console = new Scanner(System.in); 

    private MyStack stack = new MyStack();
    private Memory memory = new Memory();
    private Processor processor = new Processor();;

    public MyStack getStack() {
        return stack;
    }

    public Memory getMemory() {
        return memory;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Scanner getScanner() {
        return console;
    }

    public void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		
		String instruction = tokens[0];

        Instruction inst = null;
        int value = 0;

		switch (instruction) {
			case "push":
				value = Integer.valueOf(tokens[1]);
				inst = new InstructionPush(value);
				break;
            case "add":
                inst = new InstructionAdd();
                break;
            case "sub":
                inst = new InstructionSub();
                break;
            case "mul":
                inst = new InstructionMul();
                break;
            case "jmp":
                value = Integer.valueOf(tokens[1]);
                inst = new InstructionJmp(value);
                break;
            case "jmpg":
                value = Integer.valueOf(tokens[1]);
                inst = new InstructionJmpg(value);
                break;
            case "load":
                inst = new InstructionLoad();
                break;
            case "store":
                inst = new InstructionStore();
                break;
            case "input":
                inst = new InstructionInput();
                break;
            case "output":
                inst = new InstructionOutput();
                break;
            default:
                inst = null;
		}
        if (inst != null)
		    instructions.add(inst);
	}

    public void loadProgram() {
        processor.loadProgram(instructions, this);
    }
}