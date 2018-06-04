package ast;

/*******************************
 * abstract class Leaf
 * used to classify all of its subclasses
 * as leaves to the AST
 *
 * @author Thet Htay Zaw
 *******************************/
public abstract class Leaf extends Node {

    /********************************
     * returns true because the value
     * of the leaves will be atomic
     *
     * @author Oliver Frank
     ********************************/
    public boolean isAtomic() {
        return true;
    }

    public void add(Node node) {
	System.out.println("Item atomic");
    }

    public Node get(int i) {
	System.out.println("Item atomic");
	return null;
    }
} 
