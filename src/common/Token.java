package common;

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
	
	if (data.equals("(")) {
	    _type = TokenType.LPAREN;
	}
	else if (data.equals(")")) {
	    _type = TokenType.RPAREN;
	}
	else if ( data.substring(0, 1).equals('"') ) {
	    _type = TokenType.STR;
	}




    }//end constructor
}//end Token
