package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

/****************************************
 * public class List
 *
 *
 * function class for the list function
 * @author Thet Htay Zaw
 ****************************************/
public class List extends Function
{
    /***********************************************
     * implements the list function
     * turns all the arguments provided into a list
     *
     * @author Thet Htay Zaw
     ***********************************************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp)
    {
	ASTList holder = new ASTList();
	int i = args.length - 1;
	while ( i >= 0 ) {
	    Node[] pass = { args[i] , holder };
	    holder = (ASTList) nsp.getFunc("cons").evalF( pass, evaler, nsp, gnsp);
	    i--;
	}
	return holder;
    }
}

