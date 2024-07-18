package leo.local.gym_exercises.exception;

public class BusinessException extends RuntimeException {
    public BusinessException (String message) {
        super(String.format(message));
    }

    public BusinessException (String message, Exception exception) {
        super(String.format(message, exception));
    }
}