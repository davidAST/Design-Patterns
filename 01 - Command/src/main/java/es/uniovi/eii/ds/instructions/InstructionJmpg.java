package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionJmpg implements Instruction {
    private int value;

    public InstructionJmpg(int value) {
        this.value = value;
    }    

    @Override
    public void execute(VirtualMachine vm) {
        int value1 = vm.getStack().pop();
        int value2 = vm.getStack().pop();
        if (value1 > value2) 
		    vm.getProcessor().setIP(value);
        else
            vm.getProcessor().incIP();
    }
}