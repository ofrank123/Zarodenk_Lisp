package eval.data.defFuncs;

import eval.*;
import eval.data.*;
import ast.*;

/*********************** 
 * public class Quote
 * Object to hold the Quote function
 * 
 * @author Oliver Frank
 ***********************/
public class Quote extends Function {

    /*********************** 
     * Returns the Node passed,
     * evaluated. Will update to support
     * lists (it's main function) in future
     * 
     * @params List of args, evaler, global namespace
     * @author Oliver Frank
     ***********************/
    public Leaf evalF(Node[] args, ZEvaler evaler, Namespace gnsp) {
	if(args.length != 1) {
	    System.out.println("Error: quote takes 1 arguments, " + (args.length - 1) + " found");
	    System.exit(1);
	}
	if(args[0] == null) {
	    System.out.println("Error: Quote passed a null argument");
	    System.exit(1);
	}
	if(args[0].type==NType.AST) {
	    return consList((AbstractSyntaxTree) args[0]);
	} else {
	    return (Leaf) args[0];
	}
    }
 
    //additional method required to build List out of an AST
    private ASTList consList(AbstractSyntaxTree ast) {
	ASTList ret = new ASTList();
	for(int i = ast.size()-1; i >= 0; i--) {
	    if(ast.get(i).type == NType.AST) {
		ret.addLeaf(consList((AbstractSyntaxTree) ast.get(i)));
	    } else {
		ret.addLeaf((Leaf) ast.get(i));
	    }
	}
	return ret;
    }
}
