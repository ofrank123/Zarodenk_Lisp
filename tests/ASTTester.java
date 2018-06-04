package test;

import ast.*;

public class ASTTester
{
    
    public static void main(String[] args)
    {

	//Testing  out the individal leaves
	ASTNum NumNode = new ASTNum("11");
	System.out.println("Value of NumNode: " + NumNode.getVal());
	System.out.println("is Atomic?: " + NumNode.isAtomic());

	ASTStr StrNode = new ASTStr("Big");
	System.out.println("\nValue of StrNode: " + StrNode.getVal());
	System.out.println("is Atomic?: " + StrNode.isAtomic());

	ASTSym SymNode = new ASTSym("def");
	System.out.println("\nValue of SymNode: " + SymNode.getVal());
	System.out.println("is Atomic?: " + SymNode.isAtomic());

	System.out.println("\n");
	
	//Testing out AbstractSyntaxTree
	AbstractSyntaxTree sample = new AbstractSyntaxTree();
	sample.add(SymNode);
	sample.add(NumNode);
	sample.add(StrNode);

	System.out.println( sample.get(0).getVal() ); //Should be def
	System.out.println( sample.get(1).getVal() ); //Should be 11
	System.out.println( sample.get(2).getVal() ); //Should be Big

	AbstractSyntaxTree example = new AbstractSyntaxTree();
	ASTNum NNode = new ASTNum("20");
	ASTStr STNode = new ASTStr("Small");
	ASTSym SYNode = new ASTSym(">");

	sample.add(example);
	System.out.println("\nTesting subtree"); 
	System.out.println( "is Atomic?: " + sample.get(3).isAtomic() );
	sample.get(3).add(NNode);
	sample.get(3).add(STNode);
	sample.get(3).add(SYNode);
	System.out.println( sample.get(3).get(0).getVal() ); //Should be 20
	System.out.println( sample.get(3).get(1).getVal() ); //Should be Small
	System.out.println( sample.get(3).get(2).getVal() ); //Should be >
	
	
    } 



} 
