package demo.exception;

public class SaveDuplicatException extends RuntimeException {
    public SaveDuplicatException(String message) {
        super(message);
    }
}
