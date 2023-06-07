import java.util.Scanner;
/*
* Isaak Henry
* CS202
* Karla Fant
* The purpose of this Java file is to act as a driver and test environment for parsing my program.
* The driver program will try to prompt for user input for code, and then spit out the token number
* and what the token represents while making sure input is correct by extending the RunTimeException default class.
*/

public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        Scanner input = new Scanner(System.in);
        tokenizer.add("for|while|do", 1); //Loops
        tokenizer.add("\\{", 2); // Open Bracket
        tokenizer.add("\\}", 3); // Close Bracket ** As per my language rules, this will be when execution stops
        tokenizer.add("[+-]", 4); //Plus and minus
        tokenizer.add("[*/]", 5); //Multiply and divide
        tokenizer.add("\\^", 6); //Power of
        tokenizer.add("[0-9]+", 7); //Integers to parse
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 8); //Variable name
        //tokenizer.add("\\=", 9); // Equals
        tokenizer.add("<|>|<=|>=|==|!=", 10); //Conditionals

            try {
                System.out.println("Please enter your code: "); //Prompt for code
                String code = input.nextLine(); //Get code
                tokenizer.tokenize(code); //Split the code into tokens
                for (Tokenizer.Token tok : tokenizer.getTokens()) //And then for each token
                    System.out.println("" + tok.token + " " + tok.sequence); //print out the token


            } catch (ParserException e) { //Exception
                System.out.println((e.getMessage())); //Handling
            }
    }
}
