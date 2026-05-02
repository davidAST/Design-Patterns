package es.uniovi.eii.ds;

import java.util.List;

public class Processor {

    private int ip = 0;

    public void incIP() {
        ip++;
    }

    public void setIP(int value) {
        ip = value;
    }

    public int getIP() {
        return ip;
    }

    public void loadProgram(List<Instruction> instructions, VirtualMachine vm) {
        while (ip < instructions.size()) {
            instructions.get(ip).execute(vm);
        }
    } 
}