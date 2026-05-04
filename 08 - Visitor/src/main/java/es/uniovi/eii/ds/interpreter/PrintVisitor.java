package es.uniovi.eii.ds.interpreter;

import es.uniovi.eii.ds.interpreter.ast.Assignment;
import es.uniovi.eii.ds.interpreter.ast.Division;
import es.uniovi.eii.ds.interpreter.ast.IntegerLiteral;
import es.uniovi.eii.ds.interpreter.ast.Print;
import es.uniovi.eii.ds.interpreter.ast.Product;
import es.uniovi.eii.ds.interpreter.ast.Program;
import es.uniovi.eii.ds.interpreter.ast.Read;
import es.uniovi.eii.ds.interpreter.ast.Statement;
import es.uniovi.eii.ds.interpreter.ast.Sum;
import es.uniovi.eii.ds.interpreter.ast.Variable;

public class PrintVisitor implements Visitor {
    
   public Object visit(Program program, Object param) {
		for (Statement statement : program.statements)
			statement.accept(this, param);
        return null;
	}

	public Object visit(Print print, Object param) {
		System.out.print("print ");
		print.expression.accept(this, param);
		System.out.println(";");
        return null;
	}

	public Object visit(Assignment assignment, Object param) {
		assignment.variable.accept(this, param);
		System.out.print(" = ");
		assignment.expression.accept(this, param);
		System.out.println(";");
        return null;
	}

	public Object visit(Read read, Object param) {
		System.out.print("read ");
        read.variable.accept(this, param);
		System.out.println(";");
        return null;
	}

	public Object visit(Sum sum, Object param) {
		sum.left.accept(this, param);
		System.out.print(" + ");
		sum.right.accept(this, param);
        return null;
	}

	public Object visit(Division division, Object param) {
		division.left.accept(this, param);
		System.out.print(" / ");
		division.right.accept(this, param);
        return null;
	}

	public Object visit(Product product, Object param) {
		product.left.accept(this, param);
		System.out.print(" * ");
		product.right.accept(this, param);
        return null;
	}

	public Object visit(Variable variable, Object param) {
		System.out.print(variable.name);
        return null;
	}

	public Object visit(IntegerLiteral number, Object param) {
		System.out.print(number.value);
        return null;
	}

}
