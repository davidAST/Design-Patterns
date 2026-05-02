package es.uniovi.eii.ds.forms;

import java.util.*;

public class Form {
	
	private List<Field> fields = new ArrayList<>();

	public Form add(Field field) {
		fields.add(field);
		return this;
	}

	public void fill() {
		for (Field field : fields) {
			field.prompt();
		}
	}

	public String get(String label) {
		for (Field field : fields) {
			if (field.label().equals(label))
				return field.value();
		}
		return null;
	}

	public void show() {
	    System.out.println("\n--- Form values ---");
    	for (Field field : fields) {
        	System.out.printf("%-15s: %s%n", field.label(), field.value());
    	}
	}
}
