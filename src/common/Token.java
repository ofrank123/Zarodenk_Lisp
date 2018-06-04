package common;

import java.util.regex.Pattern;
    
/***********************
 * public class Token
 * Token contains a number, symbol, String, or Parentheses
 * 
 * @author Jude Grodesky 
 ***********************/
public class Token
{
    private TokenType _type;
    private String _data;

    /************************
     * constructor for Token
     * Denotes tokentype 
     * 
     * @author Jude Grodesky
     * @param String of token to be parsed
     ************************/
    public Token(String data)
    {
	_data = data;
	
	if (Pattern.matches("\\(", data)) { //left paren token
	    _type = TokenType.LPAREN;
	}
	else if (Pattern.matches("\\)", data)) { //right paren token
	    _type = TokenType.RPAREN;
	}
	else if (Pattern.matches("\"(.*?)\"" , data) ) { //string token
	    _type = TokenType.STR;
	}
	else if (Pattern.matches("[-+]?\\d+", data) ) { //decimal token
	    _type = TokenType.NUM;
	}
	else { //any other string is a symbol
	    _type = TokenType.SYM;
	}
    }//end constructor

    /***************
     *Accessor for _type
     *
     *@author Jude Grodesky
     ***************/
    public TokenType getType(){
	return _type;
    }

    /***************
     *Accessor for _data
     *
     *@author Jude Grodesky
     ***************/
    public String getData(){
	return _data;
    }


    /******************
     *Main testing constructor
     *
     *@author Jude Grodesky
     ******************/
    public static void main(String[] args) {
	Token a = new Token("(");
	System.out.println(a.getType());

	Token b = new Token(")");
	System.out.println(b.getType());
    }//end main
}//end Token
