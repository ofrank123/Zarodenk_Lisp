package common;

import error.LexicalError;
import java.util.LinkedList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
    
/*******************************************************
 *Class lexer can convert a file into a queue of tokens
 *Has getNextToken and hasNextToken methods
 *
 *@author Jude Grodesky
 *******************************************************/
public class ZLexer implements Lexer
{
    private LinkedList<Token> _tokenQueue;

    /**********************************************
     *Reads through provided file and adds contents
     *to tokenqueue
     *Throws IOException error
     *
     *@author Jude Grodesky
     **********************************************/
    public void buildLexer(String path) throws IOException
    {
	_tokenQueue = new LinkedList<Token>();

	//Convert the file into a string
	byte[] encoded = Files.readAllBytes(Paths.get(path));
	String contents = new String(encoded, StandardCharsets.US_ASCII);

	String token = "";
	while (contents.length() > 0) {
	    String next = contents.substring(0,1);
	    if (Pattern.matches("\\s", next) ) {
		if (token.length() > 0) {
		    _tokenQueue.add( new Token(token) );
		}
	    }
	    else if (next.equals( "(" ) || next.equals( ")") ) {
		if (token.length() > 0) {
		    _tokenQueue.add( new Token(token) );
		}
		_tokenQueue.add( new Token(next) );
	    }
	    else {
		token += next;
		contents = contents.substring(1, contents.length());
	    }
	}
    }

    /**********************************************
     *Removes and returns Token at front of queue
     *
     *@author Jude Grodesky
     **********************************************/
    public Token nextToken()
    {
	return _tokenQueue.removeFirst();
    }
    
    /**********************************************
     *True if _tokenQueue ! empty
     *false otherwise
     *
     *@author Jude Grodesky
     **********************************************/
    public boolean hasNext()
    {
	return ! (_tokenQueue.isEmpty() );
    }

    /**********************************************
     *Returns token in first postion of _tokenQueue
     *
     *@author Jude Grodesky
     **********************************************/
    public Token peekToken()
    {
	return _tokenQueue.peekFirst();
    }
    
    /**********************************************
     *Returns Lexical Errors found excecuting 
     *buildLexer
     *
     *@author Jude Grodesky
     **********************************************/
    public LexicalError[] getLexicalErrors() {
	LexicalError[] errors = new LexicalError[1];
	return errors;
    }
    
}
