package test;


import common.*;
import ast.*;
import java.io.IOException;

public class ParserTester {
    public static void main( String[] args ) throws IOException {
	Lexer lex = new ZLexer();
	lex.buildLexer("ex2.zli");
	Parser par = new ZParser();
	par.buildAST(lex);
	AbstractSyntaxTree ast = par.getAST();
	System.out.println(ast.get(0).getVal());
	System.out.println(ast.get(1).getVal());
	System.out.println(ast.get(0).get(1).getVal());
	System.out.println(ast.get(0).get(2).get(1).getVal());
    }
}
