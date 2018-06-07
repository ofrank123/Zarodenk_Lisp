package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/*************************************
 * public class Cdr
 *
 * function class for the cdr function
 * @author Thet Htay Zaw
 *************************************/
public class Cdr extends Function
{
    /******************************
     * implements the cdr function
     * evaluates the list provided 
     * without its first element
     *
     * @author Thet Htay Zaw
     ******************************/
    public Leaf evalF(Node[] args , ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	
	if (args.length > 1) {
	    System.out.println("Error: cdr takes one element, " +  args.length + " given");
	    System.exit(1);
	}

	Leaf arg0 = evaler.evalNode(args[0], nsp, gnsp);

	if ( arg0 == null ) {
	    System.out.println("Error: cdr received null argument");
	    System.exit(1);
	}

	if ( arg0.type != NType.LIST ) {
	    System.out.println("Error: cdr only takes List as a parameter");
	    System.exit(1);
	}

	if ( ((ASTList) arg0).size() == 0 ) {
	    System.out.println("Error: cdr only takes a non-empty list");
	}

	else {
	    return ((ASTList) arg0).cdr();
	}

	return null;
    }
}

