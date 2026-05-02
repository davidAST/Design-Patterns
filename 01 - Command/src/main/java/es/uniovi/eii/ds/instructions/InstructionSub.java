package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionSub implements Instruction {

    public void execute(VirtualMachine vm) {
        int value1 = vm.getStack().pop();
        int value2 = vm.getStack().pop();
        vm.getStack().push(value1 - value2);
		vm.getProcessor().incIP();
    }
}