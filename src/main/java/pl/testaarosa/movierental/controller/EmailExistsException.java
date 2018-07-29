package pl.testaarosa.movierental.controller;

public class EmailExistsException extends RuntimeException {
    public EmailExistsException(final String message) {
        super(message);
    }
}
