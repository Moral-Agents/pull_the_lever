package com.game.exceptions;

import com.game.dtos.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class InternalServerErrorException extends GameException{
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
