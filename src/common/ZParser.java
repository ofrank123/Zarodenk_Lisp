package common;

import ast.*;
import error.SyntacticalError;
/*
  Zarodenk_Lisp 2018
  by Oliver Frank, Thet Htay Zaw, and Jude Grodesky
*/

/**
 * public class ZParser
 * Implements the Parser interface
 * @author Thet Htay Zaw
 **/
public class ZParser implements Parser
{

    private AbstractSyntaxTree _tree;

    /**
     * constructor for ZParser
     * Instantiates the AbstractSyntaxTree
     * Sets level to 0
     *
     * @author Thet Htay Zaw
     **/
    public ZParser()
    {
	_tree = new AbstractSyntaxTree();
    }


    /**
     * Takes a Token, turns it into a Node,
     * and adds it to the AST
     *
     * @param Token to be added
     * @author Thet Htay Zaw
     **/
    public void buildAST(Lexer lex)
    {
	/**
	 * Note from Thet: I can't seem to find a way to make this recursive
	 * Or maybe more so I can't think of a way to do so or this make this super clean
	 * And it's partially due to how AST's add works and this add works
	 * AST's add just add whatever it receives in, while ZParser's add 
	 * has to go as far down as a possible before adding to the tree
	 * There's also the thing with different parameters
	 **/
	
    }

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
	/* Should never reach this */
	return null;
    }
    
    /**
     *
     *
     **/
    public AbstractSyntaxTree getAST() {
	return _tree;
    } 

    /**
     * 
     *
     **/
    public SyntacticalError[] getSyntacticalErrors() {
	return null;
    }    
} 
