package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Multiply extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	int product = 1;
	if (args.length == 0) {
	    return new ASTNum("" + product);
	}
	for(int i = 0; i < args.length; i++) {
	    Leaf argi = evaler.evalNode(args[i], nsp, gnsp);
	    if(argi == null) {
		System.out.println("Error: multiply recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.NUM) {
		System.out.println("Error: multiply takes only a num, " + args[i].type + " given");
		System.exit(1);
	    }
	    product *= Integer.valueOf( argi.getVal());
	}

	return new ASTNum("" + product);
    }
}
