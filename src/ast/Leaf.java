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
} 
