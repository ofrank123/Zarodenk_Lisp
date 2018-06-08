package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/**************************************
 * public class Atom
 *
 * function class of the atom function
 * @author Thet Htay Zaw
 **************************************/
public class Atom extends Function
{

    /**************************************
     * implements the atom function
     * returns T if the argument is atomic
     * false otherwise
     *
     * @author Thet Htay Zaw
     **************************************/
    public Leaf evalF(Node[] args , ZEvaler evaler , Namespace nsp , Namespace gnsp)
    {
	if (args.length > 1) {
	    System.out.println("Error: atom only takes one argument, " + args.length + " given");
	    System.exit(1);
	}

	Leaf arg0 = evaler.evalNode(args[0], nsp, gnsp);

	if ( arg0 == null ) {
	    System.out.println("Error: atom received null argument");
	    System.exit(1);
	}

	if ( arg0.isAtomic() ) {
	    return new ASTBool("T");
	}

	else {
	    return new ASTBool("NIL");
	}
    }
}
