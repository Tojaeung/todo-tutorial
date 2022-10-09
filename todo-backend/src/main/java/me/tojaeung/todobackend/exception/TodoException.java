package me.tojaeung.todobackend.exception;

public class TodoException extends RuntimeException {
    private int status;

    public TodoException( int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
