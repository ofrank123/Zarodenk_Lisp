package common;

import error.LexicalError;
import java.util.LinkedList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.regex.Pattern;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;

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
	path = "../ZLispExamples/" + path;
	_tokenQueue = new LinkedList<Token>();

	//Convert the file into a string
	byte[] encoded = Files.readAllBytes(Paths.get(path));
	String contents = new String(encoded, StandardCharsets.US_ASCII);

	/********************************************************************
	 *
	 *        ~~~*~*~**~~~ WHOLE LOTTA REGEX MAGIC ~~*~***~~~~**
	 *
	 ********************************************************************/
	
	//deal w/ comments
	contents = contents.replaceAll("#(.*)", ""); //single line comments
	contents = contents.replaceAll("\\/\\*((.|\\n|\\r\\n)*)\\*\\/", ""); //multiline comments
	
        contents = contents.replaceAll("\\(", " ( ");
	contents = contents.replaceAll("\\)", " ) ");
	contents = contents.replaceAll("'", " ' ");

	String regex = "\"([^\"]*)\"|(\\S+)";
	
	Matcher m = Pattern.compile(regex).matcher(contents);
	while (m.find()) {
	    if (m.group(1) != null) {
		_tokenQueue.addLast(new Token("\"" + m.group(1) + "\""));
	    } else {
		_tokenQueue.addLast(new Token(m.group(2)));
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
}
