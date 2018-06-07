package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/*************************************
 * public class Car
 * 
 *
 * function class for the car function
 * @author Thet Htay Zaw
 *************************************/
public class Car extends Function
{
    /***********************************
     * implements the car function
     * returns the first element in
     * the list provided in the argument
     *
     * @author Thet Htay Zaw
     ***********************************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp)
    {
	if (args.length > 1) {
	    System.out.println("Error: car takes one element, " +  args.length + " given");
	    System.exit(1);
	}

	Leaf arg0 = evaler.evalNode(args[0], nsp);

	if ( arg0 == null ) {
	    System.out.println("Error: car received null argument");
	    System.exit(1);
	}

	if ( arg0.type != NType.LIST ) {
	    System.out.println("Error: car only takes List as a parameter");
	    System.exit(1);
	}

	if ( ((ASTList) arg0).size() == 0 ) {
	    System.out.println("Error: car only takes a non-empty list");
	}

	else {
	    return ((ASTList) arg0).car();
	}

	return null;
    } 
    
}
