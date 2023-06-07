//Isaak Henry
//CS202
//Karla Fant
//The purpose of this java file is to handle the exception handling. Right now there is only one throw, and
//it is an extension of the RunTimeException built-in.

public class ParserException extends RuntimeException {
    public ParserException(String msg) {
        super(msg);
    }
}