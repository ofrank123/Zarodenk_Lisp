package eval.data;

import eval.ZEvaler;
import ast.*;


/*********************** 
 * public abstract class Function
 * Function class to define all function objects under
 * 
 * @author Oliver Frank
 ***********************/
public abstract class Function {
    
    /*********************** 
     * Does action specified by function being written
     * 
     * @params List of args, evaler, global namespace
     * @author Oliver Frank
     ***********************/
    public abstract Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp);
}
