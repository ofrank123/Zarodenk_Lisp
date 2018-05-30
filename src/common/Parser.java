package common;

import error.SyntacticalError;

/*
  Zarodenk Lisp 2018
  by Oliver Frank, Thet Htay Zaw, and Jude Grodesky
 */

/***************************
 * public interface Parser
 * The parser will take a token queue and turn it into an abstract syntax tree (AST)
 * to be passed to the eval machine
 * @author Thet Htay Zaw
 ***************************/

public interface Parser {

    /************************
     * Takes Token and adds it to the AST
     *
     * @param Token to be added
     * @author Thet Htay Zaw
     ************************/
    public void add(Token token);


    /************************
     * Returns the final AST
     *
     * @author Thet Htay Zaw
     ************************/
    public AbstractSyntaxTree getAST();

    /************************
     * Return a list of syntactical errors encountered
     * Any syntactical errors found (such as too few/many parens, or malformed s expressions)
     * will be caught and thrown as errors
     *
     * @author Thet Htay Zaw
     ************************/
    public SyntacticalError[] getSyntacticalErrors();
    
}
