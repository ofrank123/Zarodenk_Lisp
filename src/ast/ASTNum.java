package ast;

/********************
 * public class ASTNum
 * Represents the NUM token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTNum extends Leaf {

    private int _num;

    public ASTNum(String value)
    {
	_num = Integer.parseInt(value);
    }

    public int getVal()
    {
	return _num;
    } 

} 
