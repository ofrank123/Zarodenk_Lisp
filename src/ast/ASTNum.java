package ast;

/********************
 * public class ASTNum
 * Represents the NUM token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTNum extends Leaf {

    //private int _num;

    /****************************
     * constructor for ASTNum
     * sets _num to inputted value
     *
     * @author Oliver Frank
     ****************************/
    public ASTNum(String value)
    {
	type = NType.NUM;
	//_num = Integer.parseInt(value);
	_val = value;
    }

    /****************************
     * returns the value of
     * the node (_num)
     *
     * @author Thet Htay Zaw
     ****************************/ 
    public String getVal()
    {
	//return _num;
	return _val;
    } 

} 
