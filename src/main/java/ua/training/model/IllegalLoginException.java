package ua.training.model;

public class IllegalLoginException extends RuntimeException {
    public IllegalLoginException(String message){
        super("Login exists: " + message);
    }
}
