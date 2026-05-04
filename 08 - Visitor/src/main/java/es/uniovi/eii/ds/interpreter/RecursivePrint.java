package es.uniovi.eii.ds.interpreter;

import es.uniovi.eii.ds.interpreter.ast.*;

 // Prints the program traversing the AST using a recursive approach.
 //
public class RecursivePrint {
	
	public void visit(Node node) {
		
		if (node instanceof Program) {
			for (Statement statement : ((Program) node).statements)
				visit(statement);
		} else if (node instanceof Print) {
			System.out.print("print ");
			visit(((Print) node).expression);
			System.out.println(";");
		} else if (node instanceof Read) {
			System.out.print("read ");
			visit(((Read) node).variable);
			System.out.println(";");
		} else if (node instanceof Assignment) {
			visit(((Assignment) node).variable);
			System.out.print(" = ");
			visit(((Assignment) node).expression);
			System.out.println(";");
		} else if (node instanceof IntegerLiteral) {
			System.out.print(((IntegerLiteral) node).value);
		} else if (node instanceof Product) {
			visit(((Product) node).left);
			System.out.print(" * ");
			visit(((Product) node).right);
		} else if (node instanceof Division) {
			visit(((Division) node).left);
			System.out.print(" / ");
			visit(((Division) node).right);
		} else if (node instanceof Sum) {
			visit(((Sum) node).left);
			System.out.print(" + ");
			visit(((Sum) node).right);
		} else if (node instanceof Variable) {
			System.out.print(((Variable) node).name);
		}
	}
}
