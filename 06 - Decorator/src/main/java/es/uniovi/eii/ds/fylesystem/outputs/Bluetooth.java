package es.uniovi.eii.ds.fylesystem.outputs;

import es.uniovi.eii.ds.fylesystem.Output;

public class Bluetooth implements Output {
    
    String device;
    private StringBuilder output;

    public Bluetooth(String device) {
        this.device = device;
    }

    @Override
    public void open() {
        output = new StringBuilder();
        output.append("\n--- START Bluetooth [" + device + "]\n");
    }

    @Override
    public void write(char c) {
        output.append(c);
    }

    @Override
    public void close() {
        System.out.println(output.toString());
        System.out.println("--- END   Bluetooth");
    }
}
