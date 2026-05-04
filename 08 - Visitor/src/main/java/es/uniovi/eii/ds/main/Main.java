package es.uniovi.eii.ds.main;

import java.util.*;

import es.uniovi.eii.ds.interpreter.*;
import es.uniovi.eii.ds.interpreter.ast.*;

public class Main {
	
	public static void main(String[] args) {
		
		/*
		 	read ancho; 
		 	read alto; 
		 	area = alto * ancho / 2; 
		 	print area + 10;
		 */

		// Build the AST for the program above
		List<Statement> statements = new ArrayList<>();
		statements.add(new Read(new Variable("ancho")));	// read ancho;
		statements.add(new Read(new Variable("alto")));	// read alto;
		// area = alto * ancho / 2;
		Product prod = new Product(new Variable("alto"), new Variable("ancho"));
		statements.add(new Assignment(new Variable("area"), new Division(prod, new IntegerLiteral("2"))));
		// print area + 10;
		statements.add(new Print(new Sum(new Variable("area"), new IntegerLiteral("10"))));
		Program program = new Program(statements);

		System.out.println("\n--- Recursive print");
		RecursivePrint recursivePrint = new RecursivePrint();
		recursivePrint.visit(program);

		// It does not compile
		//System.out.println("\n--- Ideal version: it does not work");
		//IdealPrint idealPrint = new IdealPrint();
		//idealPrint.visit(program);
		 
		// TO DO (1): You must implement the Visitor pattern to make this work
		System.out.println("\n--- Print with Visitor");
		Visitor printVisitor = new PrintVisitor();
		program.accept(printVisitor, null);
		
		// TO DO (2): Once you have printed the program, interpret it
		//            (you have to create a new visitor for execution)
		System.out.println("\n--- Execution");
		Scanner scanner = new Scanner(System.in);
		Visitor executorVisitor = new ExecutorVisitor(scanner);
		program.accept(executorVisitor, null);
		scanner.close();
		
	}
}
