package es.uniovi.eii.ds.main;

import java.util.Scanner;

import es.uniovi.eii.ds.fylesystem.FileSystem;
import es.uniovi.eii.ds.fylesystem.decorators.CountCharactersDecorator;
import es.uniovi.eii.ds.fylesystem.decorators.EncryptDecorator;
import es.uniovi.eii.ds.fylesystem.decorators.NormalizeDecorator;
import es.uniovi.eii.ds.fylesystem.decorators.RemoveSpacesDecorator;
import es.uniovi.eii.ds.fylesystem.outputs.*;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		FileSystem system = new FileSystem();

		system.copyFile("private.txt", new FileOutput("copy.txt"));
		system.copyFile("private.txt", new Internet("156.35.233.143"));
		system.copyFile("private.txt", new Bluetooth("César's iPhone"));

		//-- Initial redesign --------------------------------

		print("Initial redesign");
		system.copyFile("private.txt", new NormalizeDecorator(new FileOutput("copy-normalized.txt")));
		system.copyFile("private.txt", new EncryptDecorator(new Internet("156.35.233.143")));
		system.copyFile("private.txt", new RemoveSpacesDecorator(new EncryptDecorator(new Bluetooth("César's iPhone"))));

		//-- Modification 1 ----------------------------------

		print("Modification 1");
		system.copyFile("private.txt", new NormalizeDecorator(new FileOutput("a.txt")));
		system.copyFile("private.txt", new EncryptDecorator(new NormalizeDecorator(new FileOutput("b.txt"))));


		//-- Modification 2 ----------------------------------

		print("Modification 2");
		system.copyFile("private.txt", new NormalizeDecorator(new EncryptDecorator(new Internet("1.1.1.1"))));
		system.copyFile("private.txt", new RemoveSpacesDecorator (new EncryptDecorator (new Internet("1.1.1.2"))));
		system.copyFile("private.txt", new RemoveSpacesDecorator (new NormalizeDecorator(new EncryptDecorator(new Internet("1.1.1.3")))));

		//-- Modification 3 ----------------------------------

		print("Modification 3");
		CountCharactersDecorator charCounter = new CountCharactersDecorator(new Internet("1.1.1.1"));
		system.copyFile("private.txt", charCounter);
		System.out.println(charCounter.getCount() + " characters copied");


		//-- Modification 4 ----------------------------------

		print("Modification 4");
		charCounter = new CountCharactersDecorator(new Internet("1.1.1.1"));
		system.copyFile("private.txt", charCounter);

		int chars_before = charCounter.getCount();

		system.copyFile("private.txt", new NormalizeDecorator(charCounter));
		System.out.println("Before normalisation there were "  + chars_before + " characters");
		System.out.println("After normalisation " + (charCounter.getCount() - chars_before) + " chars where copied");


		// -- Modification 5 ----------------------------------

		print("Modification 5");
		// ...
	}

	private static void print(String message) {
		System.out.println("\n\n\n---------- " + message + " ----------");
	}
}
