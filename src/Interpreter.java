import common.*;
import ast.*;
import eval.*;
import java.io.IOException;

public class Interpreter {
    public static void main( String[] args ) throws IOException {
	if(args.length != 1) {
	    System.out.println("Error: ZLisp Interpreter takes one file");
	    System.exit(1);
	}
	Lexer lex = new ZLexer();
	lex.buildLexer(args[0]);
	Parser par = new ZParser();
	par.buildAST(lex);
	AbstractSyntaxTree ast = par.getAST();
	Evaler evl = new ZEvaler();
	evl.evaluate(ast);
    }
}
