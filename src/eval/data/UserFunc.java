package eval.data;

import ast.*;
import eval.*;
import eval.data.*;

public class UserFunc extends Function {
    private ASTSym[] argNames;
    private Node funcTree;
    
    public UserFunc(ASTSym[] cargNames, Node cfuncTree) {
	argNames = cargNames;
	funcTree = cfuncTree;
    }
    
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace nsp, Namespace gnsp) {
	Namespace lnsp = new Namespace(evaler, nsp);
	if(args.length != argNames.length) {
	    System.out.println("Error: mismatch between args required and args provided");
	    System.exit(1);
	    return null;
	}
	for(int i = 0; i < args.length; i++) {
	    if(gnsp.contains(argNames[0].getVal())) {
		System.out.println("Error: namespace conflict");
		System.exit(1);
		return null;
	    } else {
		lnsp.addVar(argNames[i].getVal(), evaler.evalNode(args[i], nsp, gnsp));
	    }
	} 
	return evaler.evalNode(funcTree, lnsp, gnsp);
    }
}
