package eval.data;

import ast.*;

public class Function {
    AbstractSyntaxTree ast;
    Leaf[] args;
    
    public Function(AbstractSyntaxTree cast, Leaf[] cargs) {
	ast = cast;
	args = cargs;
    }
    
    public AbstractSyntaxTree getVal() {
	return ast;
    }
}
