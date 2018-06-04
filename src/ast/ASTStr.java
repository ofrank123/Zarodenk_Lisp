package ast;

/********************
 * public class ASTStr
 * Represents the STR token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTStr extends Leaf {

    //private String _str;

    /****************************
     * constructor for ASTStr
     * sets _str to inputted value
     *
     * @author Thet Htay Zaw
     ****************************/
    public ASTStr(String value)
    {
	//_str = value;
	_val = value;
    }

    /****************************
     * returns the value of
     * the node (_str)
     *
     * @author Thet Htay Zaw
     ****************************/ 
    public String getVal()
    {
	//return _str;
	return _val;
    } 

} 
