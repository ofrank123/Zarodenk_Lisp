package eval.data;

import java.util.HashMap;
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
    private HashMap<String, String> vars;

    /*********************** 
     * Namespace to hold function and variable
     * definitions in hashmaps.
     * 
     * @author Oliver Frank
     ***********************/
    public Namespace() {
	funcs = new HashMap<String, Function>();
	vars = new HashMap<String, String>();

	/*******************************
         * DEFAULT FUNCTION DEFINITIONS
	 *******************************/
	addFunc("quote", new Quote());
	addFunc("def", new Def());
	addFunc("equal", new Equal());
	//Boolean Operators
	addFunc("and", new And());
	addFunc("not", new Not());
	addFunc("or", new Or());
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
    public void addVar(String name, String l) {
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
    public String getVar(String name) {
	if(vars.containsKey(name)) {
	    return vars.get(name);
	}
	System.out.println("Error: No such variable: " + "\"" + name + "\"");
	System.exit(1);
	return "error";
    }
}
