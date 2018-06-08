package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Print extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	if(args.length != 1) {
	    System.out.println("Error: Print takes 1 argument, " + args.length + " recieved");
	}
	Leaf arg = evaler.evalNode(args[0], nsp, gnsp);
	if(arg == null) {
	    System.out.println("Error: Print recieved null argument");
	    System.exit(1);
	}
	if(arg.type == NType.STR) {
	    System.out.println(arg.getVal().substring(1,arg.getVal().length()-1));
	} else {
	    System.out.println(arg.getVal());
	}
	return null;
    }
}
