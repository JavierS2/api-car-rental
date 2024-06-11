package edu.unimagdalena.api.exceptions;

public class ResourceNotAbleToDeleteException extends ResourceNotFoundException {
    public ResourceNotAbleToDeleteException() {
    }

    public ResourceNotAbleToDeleteException(String message) {
        super(message);
    }

    public ResourceNotAbleToDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotAbleToDeleteException(Throwable cause) {
        super(cause);
    }

    public ResourceNotAbleToDeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
