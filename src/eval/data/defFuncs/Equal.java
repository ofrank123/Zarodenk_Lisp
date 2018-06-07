package eval.data.defFuncs;

import eval.ZEvaler;
import ast.*;
import eval.data.*;


public class Equal extends Function {
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp) {
	String check = evaler.evalNode(args[0], nsp).getVal();
	for(int i = 1; i < args.length; i++) {
	    if(!check.equals(evaler.evalNode(args[i], nsp).getVal())) {
		return new ASTBool("NIL");
	    }
	}
	return new ASTBool("T");
    }
}
