package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Add extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	int sum = 0;
	if (args.length == 0) {
	    return new ASTNum("" + sum);
	}
	for(int i = 0; i < args.length; i++) {
	    Leaf argi = evaler.evalNode(args[i], nsp, gnsp);
	    if(argi == null) {
		System.out.println("Error: add recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.NUM) {
		System.out.println("Error: add takes only a num, " + args[i].type + " given");
		System.exit(1);
	    }
	    sum += Integer.valueOf( argi.getVal());
	}

	return new ASTNum("" + sum);
    }
}
