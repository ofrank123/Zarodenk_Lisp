package ast;

/********************
 * public class ASTSym
 * Represents the SYM token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTSym extends Leaf {

    //private String _sym;

    /****************************
     * constructor for ASTSym
     * sets _sym to inputted value
     *
     * @author Thet Htay Zaw
     ****************************/
    public ASTSym(String value)
    {
	//_sym = value;
	_val = value;
    }

    /****************************
     * returns the value of
     * the node (_sym)
     *
     * @author Thet Htay Zaw
     ****************************/ 
    public String getVal()
    {
	//return _sym;
	return _val;
    } 

} 
