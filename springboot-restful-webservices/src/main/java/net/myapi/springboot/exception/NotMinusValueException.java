package net.myapi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotMinusValueException extends RuntimeException{

    private String message;

    public NotMinusValueException(String message) {
        super(message);
    }

}
