package eval.data;

import java.util.HashMap;
import eval.*;
import eval.data.*;
import eval.data.defFuncs.*;
import ast.*;

/*********************** 
 * public class Namespace
 * Namespace to hold function and variable
 * definitions in hashmaps.
 * 
 * @author Oliver Frank
 ***********************/
public class Namespace {
    private HashMap<String, Function> funcs;
    private HashMap<String, Leaf> vars;
    private ZEvaler evaler;
    
    /*********************** 
     * Namespace to hold function and variable
     * definitions in hashmaps.
     * 
     * @author Oliver Frank
     ***********************/
    public Namespace(ZEvaler cevaler) {
	funcs = new HashMap<String, Function>();
	vars = new HashMap<String, Leaf>();
	evaler = cevaler;
	
	/*******************************
         * DEFAULT FUNCTION DEFINITIONS
	 *******************************/
	addFunc("quote", new Quote());
	addFunc("def", new Def());
	addFunc("equal", new Equal());
	addFunc("=", new Equal());
	addFunc("defun", new Defun());
	addFunc("cond", new Cond());
	//List Handling
	addFunc("cons", new Cons());
	addFunc("cdr", new Cdr());
	addFunc("car", new Car());
	//Boolean Operators
	addFunc("and", new And());
	addFunc("not", new Not());
	addFunc("or", new Or());
	//Arithmetic
	addFunc("+", new Add());
	addFunc("-", new Subtract());
	addFunc("*", new Multiply());
	addFunc("/", new Divide());	
    }

    public Namespace(ZEvaler cevaler, Namespace nsp) {
	funcs = new HashMap<String, Function>();
	vars = new HashMap<String, Leaf>();
	for(String key: nsp.funcs.keySet()) {
	    funcs.put(key, nsp.getFunc(key));
	}
	for(String key: nsp.vars.keySet()) {
	    vars.put(key, nsp.getVar(key));
	}
	evaler = cevaler;
    }
    
    /*********************** 
     * Add function to this namespace
     * 
     * @param name of var, function to add
     * @author Oliver Frank
     ***********************/
    public void addFunc(String name, Function f) {
	funcs.put(name, f);
    }

    /*********************** 
     * Add variable to this namespace
     * 
     * @param name of var, value of variable
     * @author Oliver Frank
     ***********************/
    public void addVar(String name, Leaf l) {
	vars.put(name, l);
    }

    /*********************** 
     * get the function with specified
     * name.
     * 
     * @param name of function
     * @author Oliver Frank
     **********************/
    public Function getFunc(String name) {
	if(funcs.containsKey(name))
	    return funcs.get(name);
	System.out.println("Error: No such function, " + name + " exists");
	System.exit(1);
	return null;
    }

    /*********************** 
     * get the variable with specified
     * name.
     * 
     * @param name of variable
     * @author Oliver Frank
     ***********************/
    public Leaf getVar(String name) {
	if(vars.containsKey(name)) {
	    return vars.get(name);
	}
	System.out.println("Error: No such variable: " + "\"" + name + "\"");
	System.exit(1);
	return null;
    }
    
    public boolean contains(String name) {
	if(vars.containsKey(name))
	    return true;
	if(funcs.containsKey(name))
	    return true;
	return false;
    }

}
