package ast;

import java.util.ArrayList;
import common.Token;
import common.TokenType;

/**
 * public class AbstractSyntaxTree
 * 
 * @author Thet Htay Zaw
 **/
public class AbstractSyntaxTree extends Node {

    //instance variables
    private ArrayList<Node> _nodeList;


    public AbstractSyntaxTree()
    {
	_nodeList = new ArrayList<Node>();
    }

    public void add(Node node) {
        _nodeList.add(node);
    }
    
    public Node get(int i) {
        return _nodeList.get(i);
    }

    public int size() {
	return _nodeList.size();
    } 

    public boolean isAtomic() {
        return false;
    }
} 
