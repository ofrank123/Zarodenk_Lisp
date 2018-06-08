package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Exponent extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	if (args.length != 2) {
	    System.out.println("Error: expn takes two arguments, " + args.length + " given");
	    System.exit(1);
	}
	
	Leaf root = evaler.evalNode(args[0], nsp, gnsp);
	Leaf power = evaler.evalNode(args[1], nsp, gnsp);
	
	if(root == null || power == null) {
	    System.out.println("Error: expn recieved null argument");
	    System.exit(1);
	}
	if(root.type != NType.NUM) {
	    System.out.println("Error: add takes only a num, " + root.type + " given");
	    System.exit(1);
	}
	if(power.type != NType.NUM) {
	    System.out.println("Error: add takes only a num, " + power.type + " given");
	    System.exit(1);
	}
	int expn = (int) Math.pow( Integer.valueOf( root.getVal()), Integer.valueOf( power.getVal()) );
	return new ASTNum("" + expn);	
    }
}
