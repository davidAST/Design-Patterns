package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionJmp implements Instruction {
    private int value;

    public InstructionJmp(int value) {
        this.value = value;
    }    

    @Override
    public void execute(VirtualMachine vm) {
		vm.getProcessor().setIP(value);
    }
}