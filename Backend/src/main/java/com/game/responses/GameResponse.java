package com.game.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse<T> {
    private String status;
    private String code;
    private String message;
    private T data;

    public GameResponse(String status, String code, String message){
        this.status = status;
        this.code=code;
        this.message=message;
    }
}
