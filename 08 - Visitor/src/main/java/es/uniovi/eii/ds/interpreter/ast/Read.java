package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public class Read implements Statement {
	
	public Variable variable;

	public Read(Variable variable) {
		this.variable = variable;
	}

	public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
