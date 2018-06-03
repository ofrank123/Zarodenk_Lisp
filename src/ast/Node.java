package ast;

/*********************************************
 * abstract class Node
 * used to group all of its subclasses together
 * for use in AbstractSyntaxTree
 *
 * @author Thet Htay Zaw
 *********************************************/
abstract class Node {

    /*****************************
     * returns whether or not 
     * the Node is an atomic value
     *
     * @author Oliver Frank
     *****************************/
    public abstract boolean isAtomic();
} 
