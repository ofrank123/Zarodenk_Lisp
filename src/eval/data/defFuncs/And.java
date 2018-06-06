package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class And extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	for(int i = 0; i < args.length; i++) {
	    if(evaler.evalNode(args[i]) == null) {
		System.out.println("Error: and recieved null argument");
		System.exit(1);
	    }
	    if(evaler.evalNode(args[i]).type != NType.BOOL) {
		System.out.println("Error: and takes only a bool, " + args[i].type + " given");
		System.exit(1);
	    }
	    if(evaler.evalNode(args[i]).getVal().equals("NIL")) {
		return new ASTBool("NIL");
	    }
	}
	return new ASTBool("T");
    }
}
