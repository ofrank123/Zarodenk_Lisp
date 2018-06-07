package eval.data;

import ast.*;
import eval.*;
import eval.data.*;

public class UserFunc {
    private ASTSym[] argNames;
    private AbstractSyntaxTree funcTree;
    
    public UserFunc(ASTSym[] cargNames, AbstractSyntaxTree cfuncTree) {
	argNames = cargNames;
	cfuncTree = funcTree;
    }
    
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	Namespace lnsp = new Namespace(evaler, gnsp);
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
		lnsp.addVar(argNames[i].getVal(), evaler.evalNode(args[i]));
	    }
	}
	return null;
    }

    /***********************************************
     * Evaluates the Node passed. If node is atomic
     * the value is just returned.
     * 
     * @param Node to evaluate
     * @author Oliver Frank
     ***********************************************/
    public Leaf evalNode(Node n, Namespace lnsp, Namespace gnsp, ZEvaler evaler) {
	if(n.type == NType.SYM) {
	    return lnsp.getVar(n.getVal());
	} else if (n.type == NType.AST){
	    return evalAST((AbstractSyntaxTree) n, lnsp, gnsp, evaler);
	} else {
	    return (Leaf) n;
	}
    }

    /*********************** 
     * Evaluates the AST passed and returns a Leaf.
     * Which AST can be evaluated to. Handles
     * errors if AST is not valid.
     *
     * @param AbstractSyntaxTree to evaluate
     * @author Oliver Frank
     ***********************/
    public Leaf evalAST(AbstractSyntaxTree ast, Namespace lnsp, Namespace gnsp, ZEvaler evaler) {
	if(ast.size() < 2) {
	    System.out.println("Error: not a statement");
	    System.exit(1);
	}
	Node[] args = new Node[ast.size() - 1];
	for(int i = 1; i < ast.size(); i++) {
	    args[i-1] = ast.get(i);
	}
	return evalAsF(ast.get(0), lnsp, gnsp).evalF(args, evaler, gnsp);
    }
	
    public Function evalAsF(Node f, Namespace lnsp, Namespace gnsp) {
	if(f.type == NType.SYM) {
	    return lnsp.getFunc(f.getVal());
	} else if (f.isAtomic() || f.type == NType.LIST) {
	    System.out.println("Error: " + f.getVal() + "Not a function");
	    System.exit(1);
	    return null;
	} else {
	    return null;
	}
    }
}
