package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
