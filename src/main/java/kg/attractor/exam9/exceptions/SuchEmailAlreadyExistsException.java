package kg.attractor.exam9.exceptions;

public class SuchEmailAlreadyExistsException extends Exception {
    public SuchEmailAlreadyExistsException() {
        super("Such email already exists");
    }
}
