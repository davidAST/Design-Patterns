package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionLoad implements Instruction {


    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.getStack().pop();
        vm.getStack().push(vm.getMemory().read(value));
		vm.getProcessor().incIP();
    }
}