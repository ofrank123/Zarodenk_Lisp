package ast;

/********************
 * public class ASTSym
 * Represents the SYM token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTSym extends Leaf {

    private String _sym;

    public ASTSym(String value)
    {
	_sym = value;
    }

    public String getVal()
    {
	return _sym;
    } 

} 
