import java.io.File;

package zarodenk_lisp.src;
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
    public void buildLexer(File file);

    /*************************************************
     * Get the next Token in this Lexer's token queue. Tokens are
     * enqueued upon the call to buildLexer().
     * 
     * @author Oliver Frank
     *************************************************/
    public Token nextToken();
} //end interface Lexer
