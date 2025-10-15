package net.myapi.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataAlreadyExistException extends RuntimeException{
    private String message;

    public DataAlreadyExistException(String messsage) { super(messsage); }


}
