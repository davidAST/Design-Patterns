package es.uniovi.eii.ds.interpreter;

import es.uniovi.eii.ds.interpreter.ast.Assignment;
import es.uniovi.eii.ds.interpreter.ast.Division;
import es.uniovi.eii.ds.interpreter.ast.IntegerLiteral;
import es.uniovi.eii.ds.interpreter.ast.Print;
import es.uniovi.eii.ds.interpreter.ast.Product;
import es.uniovi.eii.ds.interpreter.ast.Program;
import es.uniovi.eii.ds.interpreter.ast.Read;
import es.uniovi.eii.ds.interpreter.ast.Sum;
import es.uniovi.eii.ds.interpreter.ast.Variable;

public interface Visitor {
    Object visit(Assignment assingment, Object param);
    Object visit(Division division, Object param);
    Object visit(IntegerLiteral integerLiteral, Object param);
    Object visit(Print print, Object param);
    Object visit(Product product, Object param);
    Object visit(Program program, Object param);
    Object visit(Read read, Object param);  
    Object visit(Sum sum, Object param); 
    Object visit(Variable variable, Object param); 
    
}
