package eval.data.defFuncs;

import eval.*;
import eval.data.*;
import ast.*;

/*********************** 
 * public class Quote
 * Object to hold the Quote function
 * 
 * @author Oliver Frank
 ***********************/
public class Quote extends Function {

    /*********************** 
     * Returns the Node passed,
     * evaluated. Will update to support
     * lists (it's main function) in future
     * 
     * @author Oliver Frank
     ***********************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	if(args.length != 1) {
	    System.out.println("Error: quote takes 1 arguments, " + (args.length - 1) + " found");
	    System.exit(1);
	}
	if(args[0] == null) {
	    System.out.println("Error: Quote passed a null argument");
	    System.exit(1);
	}
	return evaler.evalNode(args[0]);
    }
}
