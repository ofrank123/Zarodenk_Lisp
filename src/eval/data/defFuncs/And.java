package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class And extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	for(int i = 0; i < args.length; i++) {
	    Leaf argi = evaler.evalNode(args[i]);
	    if(argi == null) {
		System.out.println("Error: and recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.BOOL) {
		System.out.println("Error: and takes only a bool, " + args[i].type + " given");
		System.exit(1);
	    }
	    if(argi.getVal().equals("NIL")) {
		return new ASTBool("NIL");
	    }
	}
	return new ASTBool("T");
    }
}
