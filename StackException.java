public class StackException extends Exception {
    public StackException(String errorMessage) {
        super(errorMessage);
    }
    public StackException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
