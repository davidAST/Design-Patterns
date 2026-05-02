package es.uniovi.eii.ds.forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractField implements Field {

    private String label;
    private String value;

    public AbstractField(String label) {
		this.label = label;
	}

    @Override
	public void prompt() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String value = "";
		do {
			try {
				System.out.print(label + ": ");
				value = console.readLine();
				if (!isValid(value)) {
                    printErrorMessage();
                }
			} catch (IOException e) {
				System.out.println("Error reading input. Please try again.");
			}
		} while (!isValid(value));
	}
    
    @Override
	public String label() {
		return label;
	}

	@Override
	public String value() {
		return value;
	}

    public abstract boolean isValid(String value);
    public abstract void printErrorMessage();
}
