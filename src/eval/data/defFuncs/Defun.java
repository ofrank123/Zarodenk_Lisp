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
public class Defun extends Function {
    
    /*********************** 
     * Defines a variable in the global namespace. Takes 2
     * args.
     * 
     * @params List of args, evaler, global namespace
     * @author Oliver Frank
     ***********************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp) {
	if(args.length != 3) {
	    System.out.println("Error: def takes 3 arguments, " + (args.length) + " found");
	    System.exit(1);
	}
	if(args[0].type != NType.SYM) {
	    System.out.println("Error: mismatch between defined and actual types");
	    System.exit(1);
	}
	AbstractSyntaxTree passToLambda = new AbstractSyntaxTree();
	passToLambda.add(new ASTSym("lambda"));
	passToLambda.add(args[1]);
	passToLambda.add(args[2]);
	
	//Add variable to global namespace
	nsp.addFunc(args[0].getVal(), evaler.lambda(passToLambda));
	return null;
    }
}
