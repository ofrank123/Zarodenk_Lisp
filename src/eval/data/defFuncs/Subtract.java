package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;

public class Subtract extends Function
{
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	int difference = 0;
	if (args.length == 0) {
	    return new ASTNum("" + difference);
	}
	for(int i = 0; i < args.length; i++) {
	    Leaf argi = evaler.evalNode(args[i], nsp, gnsp);
	    if(argi == null) {
		System.out.println("Error: subtract recieved null argument");
		System.exit(1);
	    }
	    if(argi.type != NType.NUM) {
		System.out.println("Error: subtract takes only a num, " + args[i].type + " given");
		System.exit(1);
	    }
	    if ( i == 0 && args.length > 1){
		difference = Integer.valueOf( argi.getVal());		
	    }
	    else {
		difference -= Integer.valueOf( argi.getVal());		
	    }
	}
	return new ASTNum("" + difference);
    }
}
