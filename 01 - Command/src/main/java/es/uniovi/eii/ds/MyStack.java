package es.uniovi.eii.ds;

public class MyStack {
    
    private int[] stack = new int[32];
    private static int sp = 0;

    public void push(int value) {
		stack[sp] = value;
		sp++;
	}

	public int pop() {
		sp--;
		return stack[sp];
	}
}