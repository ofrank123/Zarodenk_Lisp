package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class Equal extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	String check = evaler.evalNode(args[0]).getVal();
	for(int i = 1; i < args.length; i++) {
	    if(!check.equals(evaler.evalNode(args[i]).getVal())) {
		return new ASTBool("NIL");
	    }
	}
	return new ASTBool("T");
    }
}
