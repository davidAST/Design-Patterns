package es.uniovi.eii.ds.places.form;

import java.io.*;

import es.uniovi.eii.ds.places.model.Monument;

/*
 	Form to edit two fields of an element.
 */
public class Form {

	public void edit(Monument monument) {
		System.out.println("Editing the monument...");

		System.out.println("Current values:");
		printMonument(monument);

		System.out.println("New values (leave blank to keep current value):");
		System.out.print(" - Author: ");
		String value = readLine();
		if (value.length() > 0)
			monument.setAuthor(value);

		System.out.print(" - Address: ");
		value = readLine();
		if (value.length() > 0)
			monument.setAddress(value);

		System.out.println("Updated values:");
		printMonument(monument);
	}

	private void printMonument(Monument monument) {
		System.out.println(" - Author: " + monument.author());
		System.out.println(" - Address: " + monument.address());
	}

	private String readLine() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				return console.readLine();
			} catch (IOException ex) {
				System.out.println("I/O error: try again.");
			}
		} while (true);
	}
}
