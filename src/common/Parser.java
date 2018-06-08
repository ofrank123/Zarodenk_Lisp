package common;

import ast.*;

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
    public void buildAST(Lexer lex);


    /************************
     * Returns the final AST
     *
     * @author Thet Htay Zaw
     ************************/
    public AbstractSyntaxTree getAST();    
}
