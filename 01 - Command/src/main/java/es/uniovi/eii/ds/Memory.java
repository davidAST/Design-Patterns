package es.uniovi.eii.ds;

public class Memory {
    private static int[] memory = new int[1024];

    public int read(int pos) {
        return memory[pos];
    }

    public void write(int value, int pos) {
        memory[pos] = value;
    }
}