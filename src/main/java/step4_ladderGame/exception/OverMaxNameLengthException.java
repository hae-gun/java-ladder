package step4_ladderGame.exception;

public class OverMaxNameLengthException extends IllegalArgumentException {
    public OverMaxNameLengthException(String message) {
        super(message);
    }
}
