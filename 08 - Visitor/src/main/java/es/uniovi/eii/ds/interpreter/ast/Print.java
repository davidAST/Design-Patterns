package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public class Print implements Statement {

	public Expression expression;

	public Print(Expression expression) {
		this.expression = expression;
	}

	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
