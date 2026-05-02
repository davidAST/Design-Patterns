package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionStore implements Instruction {

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.getStack().pop();
        int address = vm.getStack().pop();
        vm.getMemory().write(value, address);
        vm.getProcessor().incIP();
    }
}