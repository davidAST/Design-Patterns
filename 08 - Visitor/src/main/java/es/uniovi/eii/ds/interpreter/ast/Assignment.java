package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public class Assignment implements Statement {
	
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression) {
		this.variable = variable;
		this.expression = expression;
	}

	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
