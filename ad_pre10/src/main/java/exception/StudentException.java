package exception;

/**
 * @author weisong
 * @date 2018/12/10 9:51 PM
 */
public class StudentException extends RuntimeException {
    public StudentException() {
        super();
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }
}
