package eval.data;

import java.util.HashMap;
import ast.*;

public class Namespace {
    private HashMap<String, Function> funcs;
    private HashMap<String, Integer> nums;
    private HashMap<String, String> strings;
    
    public void addFunc(String name, AbstractSyntaxTree ast, Leaf[] args) {
	funcs.put(name, new Function(ast, args));
    }

    public void addNum(String name, ASTNum num) {
	nums.put(name, num.getVal());
    }

    public void addString(String name, ASTStr str) {
	strings.put(name, str.getVal());
    }
    
    public Function getFunc(String name) {
	if(funcs.get(name) != null)
	    return funcs.get(name);
	System.out.println("no such function");
	return null;
    }

    public Integer getNum(String name) {
	if(nums.get(name) != null)
	    return nums.get(name);
	System.out.println("no such variable");
	return null;
    }

    public String getString(String name) {
	if(strings.get(name) != null)
	    return strings.get(name);
	System.out.println("no such string");
	return null;
    }
}
