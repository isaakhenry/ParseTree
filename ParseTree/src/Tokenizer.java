import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*  Isaak Henry
    CS202
    Karla Fant
    The purpose of this Java file is to break up a string into tokens. This will allow
    the java program to parse the code and then assign each token a job to do within a hierarchy that will
    be developed for next program.

 */
//This classes job is to separate a string into tokens
public class Tokenizer {

    //This class has a private subclass that uses a constructor to get the token info.
    private class TokenInfo {
        public final Pattern regex;
        public final int token;

        public TokenInfo(Pattern regex, int token) {
            super();
            this.regex = regex;
            this.token = token;
        }



    }
    //This is the class the the tokens will be stored in
    public class Token {
        public final int token;
        public final String sequence;
        //Constructor with arguments
        public Token(int token, String sequence) {
            super(); //Calls the constructor of the parent in the hierarchy
            this.token = token; //And assigns the values
            this.sequence = sequence; //To the arguments
        }

    }
    //A linked list of token information
    private LinkedList<TokenInfo> tokenInfos;
    //And a linked list of tokens
    private LinkedList<Token> tokens;
    //Default constructor for the tokenizer
    public Tokenizer() {
        //Allocate memory
        tokenInfos = new LinkedList<TokenInfo>();
        //And do it again
        tokens = new LinkedList<Token>();
    }
    //Add a new token to the list to parse for.
    public void add(String regex, int token) {
        tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token)); //Call the constructor using regular expressions
    }
    //Meat and potatoes of the parser, break the string into tokens
    public void tokenize(String str) {
        String s = str.trim(); //Trim the whitespace of the string
        tokens.clear(); //And clear the tokens
        while (!s.equals("")) { //Then check to make sure the string isn't empty
            boolean match = false; //And create a check
            for (TokenInfo info : tokenInfos) { //Then, as long as there is tokenInfo
                Matcher m = info.regex.matcher(s); //Check the string for matches
                if (m.find()) { //If a match is found
                    match = true; //say the match is found
                    String tok = m.group().trim(); //And take the token off of the string
                    s = m.replaceFirst("").trim(); //And then place the next non-white space at the beginning
                    tokens.add(new Token(info.token, tok)); //And add it to the token list.
                    break;
                }
            }
            if (!match) throw new ParserException("Unexpected character in input: "+s); //Exception handle
        }
    }
    //I know this usually isn't allowed in OOP, but in my mind this isn't part of the hierarchy, it's just a data struct
    public LinkedList<Token> getTokens()
    {
        return tokens; //Return the list of tokens.
    }

}
