package eval;

import ast.*;
import common.*;
import eval.data.*;
import error.RuntimeError;
import java.util.regex.Pattern;

/***********************
 * public class ZEvaler
 * Implements Evaler interface.  Is capable of evaluating a valid AST.
 * Errors thrown if AST is invalid.
 * 
 * @author Oliver Frank
 ***********************/
public class ZEvaler implements Evaler {
    /***********************
     * Creates new ZEvaler and sets up the
     * global namespace
     * 
     * @author Oliver Frank
     ***********************/
    public ZEvaler() {
  }

    /*********************** 
     * Evaluates the top level AST passed. 
     * Handles errors if AST is not valid.
     *
     * @param AbstractSyntaxTree to evaluate
     * @author Oliver Frank
     ***********************/
    public void evaluate(AbstractSyntaxTree ast) {
	Namespace gnsp = new Namespace(this);
	for(int i = 0; i < ast.size(); i++) {
	    Node s = ast.get(i);
	    if(s.isAtomic()) { //Atoms cannot be evaluated on their own
		System.out.println("Error: atoms not allowed in top level");
		System.exit(1);
	    }
	    Leaf ev = evalNode(s, gnsp, gnsp);
	    if(ev != null) {
		System.out.println(ev.getVal());
	    }
	}
    }

    /***********************************************
     * Evaluates the Node passed. If node is atomic
     * the value is just returned.
     * 
     * @param Node to evaluate
     * @author Oliver Frank
     ***********************************************/
    public Leaf evalNode(Node n, Namespace lnsp, Namespace gnsp) {
	if(n.type == NType.SYM) {
	    return lnsp.getVar(n.getVal());
	} else if (n.type == NType.AST){
	    return evalAST((AbstractSyntaxTree) n, lnsp, gnsp);
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
    public Leaf evalAST(AbstractSyntaxTree ast, Namespace lnsp, Namespace gnsp) {
	if(ast.size() < 2) {
	    System.out.println("Error: not a statement");
	    System.exit(1);
	}
	Node[] args = new Node[ast.size() - 1];
	for(int i = 1; i < ast.size(); i++) {
	    args[i-1] = ast.get(i);
	}
	return evalAsF(ast.get(0), lnsp, gnsp).evalF(args, this, lnsp, gnsp);
    }

    public Function evalAsF(Node f, Namespace lnsp, Namespace gnsp) {
	if(f.type == NType.SYM) {
	    return lnsp.getFunc(f.getVal());
	} else if (f.isAtomic() || f.type == NType.LIST) {
	    System.out.println("Error: " + f.getVal() + "Not a function");
	    System.exit(1);
	    return null;
	} else {
	    return lambda((AbstractSyntaxTree) f);
	}
    }

    public Function lambda(AbstractSyntaxTree fast) {
	if(!fast.get(0).getVal().equals("lambda")) {
	    System.out.println("Error: Function required, statement given");
	    System.exit(1);
	    return null;
	}
	if(fast.get(1).type != NType.AST) {
	    System.out.println("Error: List of args required as first argument");
	    System.exit(1);
	}
	AbstractSyntaxTree argAst = (AbstractSyntaxTree) fast.get(1);
	ASTSym[] argNames = new ASTSym[argAst.size()];
	for(int i = 0; i < argAst.size(); i++) {
	    if(argAst.get(i).type != NType.SYM) {
		System.out.println("Error: List of sybols required");
		System.exit(1);
	    } else {
		argNames[i] = (ASTSym) argAst.get(i);
	    }
	}
	return new UserFunc(argNames, fast.get(2));
    }
    
    /*********************** 
     * Returns Errors.  Will probably be removed soon.
     * 
     * @author Oliver Frank
     ***********************/
    public RuntimeError[] getRuntimeErrors() {
	return null;
    }
}
