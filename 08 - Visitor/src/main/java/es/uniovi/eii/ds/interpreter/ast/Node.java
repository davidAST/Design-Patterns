package es.uniovi.eii.ds.interpreter.ast;

import es.uniovi.eii.ds.interpreter.Visitor;

public interface Node {
    Object accept(Visitor visitor, Object param);
}
