package ast;
import java.util.LinkedList;

/********************
 * public class ASTStr
 * Represents the STR token type
 *
 *@author Thet Htay Zaw
 ********************/
public class ASTList extends Leaf {
    LinkedList<Leaf> _data;
    
    /****************************
     * constructor for ASTStr
     * sets _str to inputted value
     *
     * @author Thet Htay Zaw
     ****************************/
    public ASTList()
    {
	_data = new LinkedList<Leaf>();
	type = NType.LIST;
    }

    public void addLeaf(Leaf l) {
	_data.addFirst(l);
    }
    
    public Leaf car() {
	return _data.getFirst();
    }

    public ASTList cdr() {
	_data.removeFirst();
	return this;
    }

    public boolean isAtomic() {
	return false;
    }
    
    /****************************
     * returns string version of list
     * @author Thet Htay Zaw
     ****************************/ 
    public String getVal()
    {
	if(_data.size() == 0) {
	    return "()";
	}
        String ret = "(";
	for(int i = 0; i < _data.size(); i++) {
	    ret += _data.get(i).getVal() + " ";
	}
	ret = ret.substring(0, ret.length() - 1);
	return ret + ")";
    } 

} 
