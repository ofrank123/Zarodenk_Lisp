package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/**************************************
 * public class Cons
 *
 * function class for the cons function
 **************************************/
public class Cons extends Function
{

    /****************************************************************
     * implements the cons function
     * adds the first argument to the front of the last item in the
     * ast provided in the second argument
     *
     * @author Thet Htay Zaw
     ****************************************************************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp){
	
	if (args.length != 2) {
	    System.out.println("Error: cons takes two arguments, " + args.length + " given");
	    System.exit(1);
	}

	if (evaler.evalNode(args[0]) == null || evaler.evalNode(args[1]) == null ) {
	    System.out.println("Error: cons received null argument");
	    System.exit(1);
	} 

	if ( evaler.evalNode(args[1]).type != NType.AST ) {
	    System.out.println("Error: cons second parameter only takes an AST, " + args[1].type + " given");
	    System.exit(1);
	}

	else {
	    args[1].addLeaf(args[0]);
	    return args[1];
	}
    }
}
