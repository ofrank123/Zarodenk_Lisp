package eval;

import java.util.HashMap;
import ast.AbstractSyntaxTree;

/****************************
 * 
 * 
 * @author Oliver Frank
 *****************************/
public interface Evaler {

    public void evaluate(AbstractSyntaxTree ast);
    
    public RuntimeError[] getRuntimeErrors();
}
