package Exceptions_Sem3_HomeTasks.Exceptions;

public class IllegalUserDetailFormatException extends NumberFormatException {


    public IllegalUserDetailFormatException(String message) {
        super("Wrong user details format: " + message +
                "Please, check it and re-enter user parameters.");
    }
}
