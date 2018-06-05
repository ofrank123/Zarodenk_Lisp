package ast;

/********************
 * public class ASTSym
 * Represents the Boolean data type
 *
 * @author Thet Htay Zaw
 ********************/
public class ASTBool extends Leaf {

    /****************************
     * constructor for ASTBool
     * inits vars
     * 
     * @author Thet Htay Zaw
     ****************************/
    public ASTBool(String val) {
	type= NType.BOOL;
	_val = val;
    }
    
    /****************************
     * returns the value of _val
     *
     * @author Thet Htay Zaw
     ****************************/ 
    public String getVal() {
	return _val;
    }
}
