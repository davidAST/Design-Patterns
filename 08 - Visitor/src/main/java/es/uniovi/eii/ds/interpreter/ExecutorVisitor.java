package es.uniovi.eii.ds.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

public class ExecutorVisitor implements Visitor {

    private Map<String, Integer> variables = new HashMap<String,Integer>();
    private Scanner scanner;

    public ExecutorVisitor(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public Object visit(Program program, Object param) {
        for (Statement statement : program.statements)
			statement.accept(this, param);
        return null;
    }

    @Override
    public Object visit(Assignment assingment, Object param) {
        Integer ret = (Integer) assingment.expression.accept(this, param);
        variables.put(assingment.variable.name, ret);
        return null;
    }

    @Override
    public Object visit(Division division, Object param) {
        Integer a = (Integer) division.left.accept(this, param);
        Integer b = (Integer) division.right.accept(this, param);
        return a / b;
    }

    @Override
    public Object visit(IntegerLiteral integerLiteral, Object param) {
        return Integer.valueOf(integerLiteral.value);
    }

    @Override
    public Object visit(Print print, Object param) {
        System.out.println(print.expression.accept(this, param));
        return null;
    }

    @Override
    public Object visit(Product product, Object param) {
        Integer a = (Integer) product.left.accept(this, param);
        Integer b = (Integer) product.right.accept(this, param);
        return a * b;
    }

    @Override
    public Object visit(Read read, Object param) {
        Integer ret = scanner.nextInt();
        variables.put(read.variable.name,ret);
        return null;
    }

    @Override
    public Object visit(Sum sum, Object param) {
        Integer a = (Integer) sum.left.accept(this, param);
        Integer b = (Integer) sum.right.accept(this, param);
        return a + b;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        return variables.get(variable.name);
    }

}
