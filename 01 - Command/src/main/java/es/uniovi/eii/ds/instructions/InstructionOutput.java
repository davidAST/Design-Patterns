package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionOutput implements Instruction {

    @Override
    public void execute(VirtualMachine vm) {
        String value = String.valueOf(vm.getStack().pop());
        System.out.println(value);
        vm.getProcessor().incIP();
    }
}