package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Add extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	int sum = 0;
	for(int i = 0; i < args.length; i++) {
	    if (args.length < 2) {
		System.out.println("Error: add takes 2 or more arguments, " + args.length + " given");
		System.exit(1);
	    }
	    Leaf argi = evaler.evalNode(args[i]);
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
