package common;

import error.LexicalError;
import java.util.LinkedList;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.Charset;
    
/*******************************************************
 *Class lexer can convert a file into a queue of tokens
 *Has getNextToken and hasNextToken methods
 *
 *@author Jude Grodesky
 *******************************************************/
public class ZLexer implements Lexer
{
    private LinkedList<Token> _tokenQueue;

    
    public void buildLexer(File file) throws IOException
    {
	_tokenQueue = new LinkedList<Token>();

	//Convert the file into a characters
	BufferedReader reader = new BufferedReader(
	    new InputStreamReader(new FileInputStream(file),Charset.forName("UTF-8")));
	int c;
	while((c = reader.read()) != -1) {
	    String s = "" + c;
	    _tokenQueue.add(new Token(s) );
	}
    }
    
    public Token nextToken()
    {
	return _tokenQueue.removeFirst();
    }

    public boolean hasNext()
    {
	return ! (_tokenQueue.isEmpty() );
    }

    public LexicalError[] getLexicalErrors() {
	LexicalError[] errors = new LexicalError[1];
	return errors;
    }
    
}
