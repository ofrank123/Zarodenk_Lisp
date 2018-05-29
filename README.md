# Zarodenk_Lisp  
![Alt logo](img/logoColor.svg "logo")

A Lisp interpreter for our custom LISP dialect, built in Java and running on the JVM.  Final project for Mr. Brown's APCS class, second semester. The dialect will include a few unusual features, such as the ability to include other files and define macros as preprocessor directives.  The initial implementation will be minimalist and based upon John McCarthy's classic paper "A Micro-Manual for LISP - Not the whole truth," a copy of which has been provided in this repository.  We will then slowly add features on an experimental branch and push to the master branch when they are stable.  Our implementation of LISP will utilize some of the datastructures and algorithms we have learned throughout the semester, namely queues and trees.  More will be added here in the next few weeks.

Below is a diagram for how the broadphases of our interpreter should work eventually:

![Alt ZLisp Broadphase](img/ZLispBroadDiagram.png "broadphase diagram")

## Preprocessor  
Any files that are included using the `#include "filename"` directive will be copied directly into the string passed to the lexer in order.  The `#macro "find" "replace"` directive will replace all instances of the find string with the replace string.  These features will be added much later, as they are secondary to our primary goal, which is getting a working interpreter up and running.

## Lexer (Lexical Analysis)
The lexer will take the raw LISP code and turn it into a queue of tokens to be read by the parser.  It will accomplish this via the following steps:
1. Read file as a `String`  
2. add whitespace around `(` and `)`  
3. Use scanner to split resulting string on whitespace (except in the case of `Strings`, which should be kept together), and pass all non-whitespace `Strings` to Tokens  
4. Tokens will determine type by using regular expressions (RegEx), and be added in order to a queue of tokens.  A list of Token types has been listed below.  
   * `LPAREN`: "("  
   * `RPAREN`: ")"  
   * `SYM`: a  
   * `STR`: "a"  
   * `NUM`: 1 (floating points to be added later)  
   * `FUNC`: f (preceding `LPAREN`, unless it's in a cond)  
5. The queue of tokens will be returned and subsequently fed to the parser
NOTE: conditional (`cond`) are the exception to the function rule mentioned above, as they are of the form `(cond (S-EXPR S-EXPR) (S-EXPR S-EXPR))`, where the first `S-EXPR` where the value of the expression is the value of which ever `S-EXPR` evaluates true first  

Ex:
#### Code
	(def a 3)
	(cond
	  ((> a 2)
	   (print "Big num"))
	  (T
	   (print "Small num")))
	(print "Done!")
#### Token queue returned
	Token(LPAREN,)
	Token(FUNC,)
	Token(SYM,)
	Token(NUM,)
	Token(RPAREN,)
	Token(LPAREN,)
	Token(FUNC,)
	Token(LPAREN,)
	Token(LPAREN,)
	Token(FUNC,)
	Token(SYM,)
	Token(NUM,)
	Token(FUNC,)
	Token(STR,)
	Token(RPAREN,)
	Token(RPAREN,)
	Token(LPAREN,)
	Token(SYM,)
	Token(LPAREN,)
	Token(FUNC,)
	Token(STR,)
	Token(RPAREN,)
	Token(RPAREN,)
	Token(RPAREN,)
	Token(LPAREN,)
	Token(FUNC,)
	Token(STR,)
	Token(RPAREN,)

## Parser (Syntactical and Semantic Analysis)