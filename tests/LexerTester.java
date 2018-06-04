package test;

import common.*;

public class LexerTester {

    public static void main( String[] args ) throws Exception {
	Lexer lex = new ZLexer();
	lex.buildLexer("ex1.zli");
	while(lex.hasNext()) {
	    System.out.println(lex.nextToken());
	}
    }
}
