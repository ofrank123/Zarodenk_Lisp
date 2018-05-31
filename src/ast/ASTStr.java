package ast;

/********************
 * public class ASTStr
 * Represents the STR token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTStr extends Leaf {

    private String _str;

    public ASTStr(String value)
    {
	_str = value;
    }

    public String getVal()
    {
	return _str;
    } 

} 
