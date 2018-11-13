package com.codingmanstudio.courses.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings({"unused"})
@ResponseStatus(HttpStatus.UNAUTHORIZED)
@AllArgsConstructor
public class NoAuthenticationException extends RuntimeException {
    public NoAuthenticationException(String message) {
        super(message);
    }

    public NoAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAuthenticationException(Throwable cause) {
        super(cause);
    }
}
