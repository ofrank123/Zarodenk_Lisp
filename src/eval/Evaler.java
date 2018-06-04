package eval;

import java.util.HashMap;
import ast.AbstractSyntaxTree;
import error.RuntimeError;

/****************************
 * 
 * 
 * @author Oliver Frank
 *****************************/
public interface Evaler {

    public void evaluate(AbstractSyntaxTree ast);
    
    public RuntimeError[] getRuntimeErrors();
}
