package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public class IntegerLiteral implements Expression {
	
	public String value;

	public IntegerLiteral(String value) {
		this.value = value;
	}

	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
