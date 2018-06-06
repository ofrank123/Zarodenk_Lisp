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
    private Namespace nsp; //global namespace

    /***********************
     * Creates new ZEvaler and sets up the
     * global namespace
     * 
     * @author Oliver Frank
     ***********************/
    public ZEvaler() {
	nsp = new Namespace();
    }

    /*********************** 
     * Evaluates the top level AST passed. 
     * Handles errors if AST is not valid.
     *
     * @param AbstractSyntaxTree to evaluate
     * @author Oliver Frank
     ***********************/
    public void evaluate(AbstractSyntaxTree ast) {
	for(int i = 0; i < ast.size(); i++) {
	    Node s = ast.get(i);
	    if(s.isAtomic()) { //Atoms cannot be evaluated on their own
		System.out.println("Error: atoms not allowed in top level");
		System.exit(1);
	    }
	    if(evalNode(s) != null) {
		System.out.println(evalNode(s).getVal());
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
    public Leaf evalNode(Node n) {
	if(n.isAtomic()) {
	    if(n.type == NType.SYM) {
		String val = nsp.getVar(n.getVal());
		if(Pattern.matches("\"(.*?)\"", val)) {
		    return new ASTStr(val);
		} else if (Pattern.matches("[-+]?\\d+", val)) {
		    return new ASTNum(val);
		} else if (Pattern.matches("T|NIL", val)) {
		    return new ASTBool(val);
		} else {
		    return evalNode(new ASTSym(val));
		}
	    }
	    else {
		return (Leaf) n;
	    }
	} else {
	    return evalAST((AbstractSyntaxTree) n);
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
    public Leaf evalAST(AbstractSyntaxTree ast) {
	if(ast.size() < 2) {
	    System.out.println("Error: not a statement");
	    System.exit(1);
	}
	Node[] args = new Node[ast.size() - 1];
	for(int i = 1; i < ast.size(); i++) {
	    args[i-1] = ast.get(i);
	}
	return nsp.getFunc(ast.get(0).getVal()).evalF(args, this, nsp);
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
