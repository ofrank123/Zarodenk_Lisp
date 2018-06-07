package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class Not extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp) {
	if(args.length > 1) {
	    System.out.println("Error: not takes one argument, " + args.length + " given");
	    System.exit(1);
	}
	Leaf b = evaler.evalNode(args[0], nsp);
	if(b == null) {
	    System.out.println("Error: not recieved null argument");
	    System.exit(1);
	}
	if(b.type != NType.BOOL) {
	    System.out.println("Error: not takes only a bool, " + args[0].type + " given");
	}
	if(b.getVal().equals("T")) {
	    return new ASTBool("NIL");
	}
	else {
	    return new ASTBool("T");
	}
    }
}
