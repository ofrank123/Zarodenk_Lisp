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
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp) {
	if (args.length != 2) {
	    System.out.println("Error: cons takes two arguments, " + args.length + " given");
	    System.exit(1);
	}

	Leaf arg0 = evaler.evalNode(args[0], nsp);
	Leaf arg1 = evaler.evalNode(args[1], nsp);
	
	if (arg0 == null ||  arg1 == null ) {
	    System.out.println("Error: cons received null argument");
	    System.exit(1);
	} 
	
	if ( arg1.type != NType.LIST ) {
	    System.out.println("Error: cons second parameter only takes a List, " + args[1].type + " given");
	    System.exit(1);
	}
	
	else {
	    ASTList ret = ((ASTList) arg1);
	    ret.addLeaf(arg0);
	    return ret;
	}
	return null;
    }
}
