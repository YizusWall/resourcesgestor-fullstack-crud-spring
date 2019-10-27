package com.yizuslabs.jobsfaith.controller.exception;

public class UsuarioIdMismatchException extends RuntimeException{

    public UsuarioIdMismatchException() {
        super();
    }

    public UsuarioIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UsuarioIdMismatchException(final String message) {
        super(message);
    }

    public UsuarioIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
