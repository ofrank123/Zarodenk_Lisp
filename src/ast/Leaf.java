package ast;

/**
 *
 *
 *
 **/
abstract class Leaf extends Node {
    public boolean isAtomic() {
        return true;
    }
} 
