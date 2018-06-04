package test;

import common.*; 

public class TokenTester
{
    public static void main(String[] args)
    {

	Token a = new Token("(");
	System.out.println( a.getData() ); 
	System.out.println( a.getType() );
	
	Token b = new Token(")");
	System.out.println( "\n" + b.getData() );
	System.out.println( b.getType() );
	
	Token c = new Token("def");
	System.out.println( "\n" + c.getData() );
	System.out.println( c.getType() );
	
	Token d = new Token("<");
	System.out.println( "\n" + d.getData() );
	System.out.println( d.getType() );

	Token e = new Token("\"Big\"");
	System.out.println("\n" + e.getData() );
	System.out.println( e.getType() );

	Token f = new Token("15");
	System.out.println("\n" + f.getData() );
	System.out.println( f.getType() );
	
    } 
}
