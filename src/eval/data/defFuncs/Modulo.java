package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Modulo extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	if (args.length != 2) {
	    System.out.println("Error: mod takes two arguments, " + args.length + " given");
	    System.exit(1);
	}

	Leaf left = evaler.evalNode(args[0], nsp, gnsp);
	Leaf right = evaler.evalNode(args[1], nsp, gnsp);

	if(left == null || right == null) {
	    System.out.println("Error: mod recieved null argument");
	    System.exit(1);
	}
	if(left.type != NType.NUM) {
	    System.out.println("Error: mod takes only a num, " + left.type + " given");
	    System.exit(1);
	}
	if(right.type != NType.NUM) {
	    System.out.println("Error: mod takes only a num, " + right.type + " given");
	    System.exit(1);
	}
	int mod = Integer.valueOf( left.getVal()) %  Integer.valueOf( right.getVal());
	return new ASTNum("" + mod);
    }
}



