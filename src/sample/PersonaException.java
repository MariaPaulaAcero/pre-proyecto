package sample;

public class PersonaException extends Exception {

    public static String BAD_DETHDATE_LOWER = "The age must be greater than 0";
    public static String BAD_DETHDATE_UPPER = "The age must be lower than 120";
    public static String BAD_AGE = "this text is not an age";

    public PersonaException(String message) {
        super(message);
    }

}