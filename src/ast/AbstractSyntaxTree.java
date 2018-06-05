package ast;

import java.util.ArrayList;
import common.Token;
import common.TokenType;

/********************************
 * public class AbstractSyntaxTree
 * 
 * @author Thet Htay Zaw
 ********************************/
public class AbstractSyntaxTree extends Node {

    private ArrayList<Node> _nodeList;
    
    /************************************
     * constructor for AbstractSyntaxTree
     * instantiates the ArrayList of Nodes
     *
     * @author Thet Htay Zaw
     ************************************/
    public AbstractSyntaxTree()
    {
	_nodeList = new ArrayList<Node>();
	type = NType.AST;
    }

    /******************************
     * adds a Node to the ArrayList
     *
     * @param Node to be added
     * @author Oliver Frank
     ******************************/
    public void add(Node node) {
        _nodeList.add(node);
    }

    /******************************
     * returns specified Node
     *
     * @param index of Node returned
     * @author Oliver Frank
     ******************************/
    public Node get(int i) {
        return _nodeList.get(i);
    }

    /*******************************
     * returns the size of the ArrayList
     *
     * @author Thet Htay Zaw
     *******************************/
    public int size() {
	return _nodeList.size();
    } 

    /*******************************
     * returns false
     * because an AST is not atomic
     *
     * @author Oliver Frank
     *******************************/
    public boolean isAtomic() {
        return false;
    }

    public String getVal() {
	return "~~ASTObject~~";
    } 
} 
