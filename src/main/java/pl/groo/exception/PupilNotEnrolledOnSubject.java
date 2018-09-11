package pl.groo.exception;

public class PupilNotEnrolledOnSubject extends RuntimeException {

    public PupilNotEnrolledOnSubject() {
        super();
    }

    public PupilNotEnrolledOnSubject(String message) {
        super(message);
    }

    public PupilNotEnrolledOnSubject(Throwable cause) {
        super(cause);
    }

    public PupilNotEnrolledOnSubject(String message, Throwable cause) {
        super(message, cause);
    }
}
