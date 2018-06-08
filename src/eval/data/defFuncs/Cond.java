package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class Cond extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	for(int i = 0; i < args.length; i++) {
	    Node argi = args[i];
	    if(argi == null) {
		System.out.println("Error: cond recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.AST) {
		System.out.println("Error: cond takes list of boolean-statement pairs,  " + args[i].type + " recieved");
		System.exit(1);
	    }
	    AbstractSyntaxTree asti = (AbstractSyntaxTree) argi;
	    if(asti.size() != 2) {
		System.out.println("Error: cond recieved malformed boolean-statement pairs");
		System.exit(1);
	    }
	    Leaf bs1 = evaler.evalNode(asti.get(0), nsp, gnsp);
	    if(bs1.type != NType.BOOL) {
		System.out.println("Error: boolean-statement pair requires boolean as first param");
	    }
	    if(bs1.getVal().equals("T")) {
		Leaf bs2 = evaler.evalNode(asti.get(1), nsp, gnsp);
		if(bs2 == null) {
		    System.out.println("Error: cond recieved null statement to eval");
		    System.exit(1);
		}
		return bs2;
	    }
	}
	return null;
    }
}
