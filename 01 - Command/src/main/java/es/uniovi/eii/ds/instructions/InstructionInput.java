package es.uniovi.eii.ds.instructions;

import es.uniovi.eii.ds.Instruction;
import es.uniovi.eii.ds.VirtualMachine;

public class InstructionInput implements Instruction {
 
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("Enter a number: ");
        vm.getStack().push(vm.getScanner().nextInt());
        vm.getProcessor().incIP();
    }
}