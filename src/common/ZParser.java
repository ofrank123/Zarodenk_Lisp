package common;

import ast.*;
import error.SyntacticalError;
/*
  Zarodenk_Lisp 2018
  by Oliver Frank, Thet Htay Zaw, and Jude Grodesky
*/

/*********************************
 * public class ZParser
 * Implements the Parser interface
 * @author Thet Htay Zaw
 *********************************/
public class ZParser implements Parser
{

    private AbstractSyntaxTree _tree;

    /**********************************
     * constructor for ZParser
     * Instantiates the AbstractSyntaxTree
     *
     * @author Thet Htay Zaw
     **********************************/
    public ZParser()
    {
	_tree = new AbstractSyntaxTree();
    }


    /**********************************
     * builds an AST from the Token queue within Lexer 
     * refers to buildAST_R()
     *
     * @param Lexer to be used
     * @author Oliver Frank
     **********************************/
    public void buildAST(Lexer lex)
    {
	buildAST_R(_tree, lex);
    }

    /**************************************
     * helper method for buildAST
     *
     * @param AbstractSyntaxTree to be built upon
     * @param Lexer to be used
     * @author Oliver Frank
     **************************************/
    private AbstractSyntaxTree buildAST_R(AbstractSyntaxTree ast, Lexer lex) {
	while(lex.hasNext()) {
	    switch(lex.peekToken().getType()) {
	    case LPAREN:
		lex.nextToken();
		ast.add(buildAST_R(new AbstractSyntaxTree(), lex));
		break;
	    case RPAREN:
		lex.nextToken();
		return ast;
	    case SYM:
		ast.add(new ASTSym(lex.nextToken().getData()));
		break;
	    case NUM:
		ast.add(new ASTNum(lex.nextToken().getData()));
		break;
	    case STR:
		ast.add(new ASTStr(lex.nextToken().getData()));
		break;
	    }
	}
	/* Reaches this if there isn't enough closing RPARENS */
	System.out.println("Reached EOF without closing parenthesis");
	return null;
    }
    
    /*************************
     * returns the built AST
     *
     * @author Thet Htay Zaw
     *************************/
    public AbstractSyntaxTree getAST() {
	return _tree;
    } 

    /********************************************
     * Returns an array of all syntactical errors
     *
     * @author Oliver Frank
     ********************************************/
    public SyntacticalError[] getSyntacticalErrors() {
	return null;
    }    
} 
