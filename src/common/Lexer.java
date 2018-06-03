package common;

import java.io.File;
import error.LexicalError;
import java.io.IOException;
/*
  Zarodenk Lisp 2018
  by Oliver Frank, Thet Htay Zaw, and Jude Grodesky
*/

/**************************
 * public interface Lexer
 * The lexer will take the raw LISP code and turn it into a queue of tokens
 * to be read by the parser.
 * @author Oliver Frank
 **************************/
public interface Lexer {

    /***************************
     * Takes file and generates internal Token queue.
     * 
     * @param File to be lexed, parsed, and evaled
     * @author Oliver Frank
     ***************************/
    public void buildLexer(File file) throws IOException;

    /*************************************************
     * Get the next Token in this Lexer's token queue. Tokens are
     * enqueued upon the call to buildLexer().
     * 
     * @author Oliver Frank
     *************************************************/
    public Token nextToken();
    
    /*************************************************
     * Check whether there is a next Token to get from the
     * internal Token queue.  Returns true if there are
     * more tokens, false if empty;
     *  
     * @author Oliver Frank
     *************************************************/
    public boolean hasNext();

    /************************************************
     * Returns a list of lexical errors encountered.
     * Any tokens not recognized by the lexer will be
     * caught and thrown as errors.
     *
     * @author Oliver Frank
     ************************************************/
    public LexicalError[] getLexicalErrors();
} //end interface Lexer
