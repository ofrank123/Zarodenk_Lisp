package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/*********************
 * public class Def
 * Class to hold def function.
 * 
 * @author Oliver Frank
 *********************/
public class Def extends Function {

    
    /*********************** 
     * Defines a variable in the global namespace. Takes 2
     * args.
     * 
     * @params List of args, evaler, global namespace
     * @author Oliver Frank
     ***********************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	if(args.length != 2) {
	    System.out.println("Error: def takes 2 arguments, " + (args.length - 1) + " found");
	    System.exit(1);
	}
	if(args[0].type != NType.SYM) {
	    System.out.println("Error: mismatch between defined and actual types");
	    System.exit(1);
	}
	//Add variable to global namespace
	gnsp.addVar(args[0].getVal(), evaler.evalNode(args[1]));
	return null;
    }
}
