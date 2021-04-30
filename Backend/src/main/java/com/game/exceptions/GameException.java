package com.game.exceptions;

import com.game.dtos.ErrorDto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GameException extends Exception{
    private final String code;
    private final int responseCode;
    private final List<ErrorDto> errorDtoList = new ArrayList<>();

    public GameException(String code, int responseCode, String message){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
    }

    public GameException(String code, int responseCode, String message, List<ErrorDto> errorDtoList){
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorDtoList.addAll(errorDtoList);
    }
}
