package com.codingmanstudio.courses.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings({"unused"})
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
@AllArgsConstructor
public class WrongDataFormatException extends RuntimeException{
    public WrongDataFormatException(String message) {
        super(message);
    }

    public WrongDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongDataFormatException(Throwable cause) {
        super(cause);
    }
}
