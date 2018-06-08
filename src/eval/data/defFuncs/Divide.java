package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Divide extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	int quotient = 1;
	if (args.length == 0) {
	    return new ASTNum("" + quotient);
	}
	for(int i = 0; i < args.length; i++) {
	    Leaf argi = evaler.evalNode(args[i], nsp, gnsp);
	    if(argi == null) {
		System.out.println("Error: divide recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.NUM) {
		System.out.println("Error: divide takes only a num, " + args[i].type + " given");
		System.exit(1);
	    }
	    if ( i == 0){
		quotient = Integer.valueOf( argi.getVal());
	    }
	    else {
		quotient /= Integer.valueOf( argi.getVal());		
	    }

	}

	return new ASTNum("" + quotient);
    }
}
