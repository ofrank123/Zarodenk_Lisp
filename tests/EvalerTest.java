import common.*;
import ast.*;
import eval.*;
import java.io.IOException;

public class EvalerTest {
    public static void main( String[] args ) throws IOException {
	Lexer lex = new ZLexer();
	lex.buildLexer("ex3.zli");
	Parser par = new ZParser();
	par.buildAST(lex);
	AbstractSyntaxTree ast = par.getAST();
	Evaler evl = new ZEvaler();
	evl.evaluate(ast);
    }
}
