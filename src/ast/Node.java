package ast;

/*********************************************
 * abstract class Node
 * used to group all of its subclasses together
 * for use in AbstractSyntaxTree
 *
 * @author Thet Htay Zaw
 *********************************************/
public abstract class Node {

    public NType type;
    
    protected String _val; 
    /*****************************
     * returns whether or not 
     * the Node is an atomic value
     *
     * @author Oliver Frank
     *****************************/
    public abstract boolean isAtomic();

    
    /***************************
     * returns the value of _val
     *
     * @author Thet Htay Zaw
     ***************************/
    public abstract String getVal();

    public abstract void add(Node node);

    public abstract Node get(int i);
} 
