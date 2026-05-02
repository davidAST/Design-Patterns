package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionPush implements Instruction{
    private int value;

    public InstructionPush(int value) {
        this.value = value;
    }    

    public void execute(VirtualMachine vm) {
        vm.getStack().push(value);
		vm.getProcessor().incIP();
    }
}