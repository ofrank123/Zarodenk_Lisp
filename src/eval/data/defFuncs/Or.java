package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class Or extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	for(int i = 0; i < args.length; i++) {
	    Leaf b = evaler.evalNode(args[i], nsp, gnsp);
	    if(b == null) {
		System.out.println("Error: or recieved null argument");
		System.exit(1);
	    }
	    if(b.type != NType.BOOL) {
		System.out.println("Error: or takes only a bool, " + args[i].type + " given");
		System.exit(1);
	    }
	    if(b.getVal().equals("T")) {
		return new ASTBool("T");
	    }
	}
	return new ASTBool("NIL");
    }
}
