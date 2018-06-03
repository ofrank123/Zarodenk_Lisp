
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
    private int _depth; //Keeps track of how far down the subtrees you need to go
    private int _level; //Keeps track of how far you are in the subtrees

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
	_level = 0;
    }


    /**
     * Takes a Token, turns it into a Node,
     * and adds it to the AST
     *
     * @param Token to be added
     * @author Thet Htay Zaw
     **/
    public void add(Token token)
    {
	/**
	 * Note from Thet: I can't seem to find a way to make this recursive
	 * Or maybe more so I can't think of a way to do so or this make this super clean
	 * And it's partially due to how AST's add works and this add works
	 * AST's add just add whatever it receives in, while ZParser's add 
	 * has to go as far down as a possible before adding to the tree
	 * There's also the thing with different parameters
	 **/
	if (token.getType() == TokenType.RPAREN) {
	    depth--; 
	    return;
	}

	if (token.getType() == TokenType.LPAREN) {
	    AbstractSyntaxTree insert = new AbstractSyntaxTree();
	    AbstractSyntaxTree holder = _tree;
	    if ( _depth = 0 ) { 
		_tree.add(insert);
		return; 
	    }
	    while ( _level < _depth ) {
		holder = holder.get(holder.size() - 1);
		_level++;
	    }
	    _level = 0; 
	    _holder.add(insert);
	    _depth++;
	    return;
	}
	if (token.getType() == TokenType.SYM) {
	    ASTSym insert = new ASTSym(Token.getData());
	    AbstractSyntaxTree holder = _tree;
	    if ( _depth == 0 ) {
		_tree.add(insert);
		return;
	    } 
    
	    //Goes down the tree
	    while ( _level < _depth ) {
		 holder = holder.get(holder.size() - 1);
		//If you're still going down the trees, the most recent addition will be the path to the subtree
		_level++;
	    }
	    _holder.add(insert);
	    _level = 0; 
	    return;
	}

    }

    /**
     *
     *
     **/
    public AbstractSyntaxTree getAST() {
	return _tree;
    } 
	    
	

    } 
