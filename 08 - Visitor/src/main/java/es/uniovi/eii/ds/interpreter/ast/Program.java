package es.uniovi.eii.ds.interpreter.ast;

import java.util.*;

import es.uniovi.eii.ds.interpreter.Visitor;

public class Program implements Node {
    
    public List<Statement> statements;
    
    public Program(List<Statement> program) {
        this.statements = program;
    }

    public Object accept(Visitor visitor, Object param) {
		return visitor.visit(this, param);
	}
}
