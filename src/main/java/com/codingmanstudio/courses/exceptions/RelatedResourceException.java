package com.codingmanstudio.courses.exceptions;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings({"unused"})
@ResponseStatus(HttpStatus.CONFLICT)
@AllArgsConstructor
public class RelatedResourceException extends RuntimeException {

    public RelatedResourceException(String message) {
        super(message);
    }

    public RelatedResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RelatedResourceException(Throwable cause) {
        super(cause);
    }

}
