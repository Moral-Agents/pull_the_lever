package com.game.controllers;

import com.game.dtos.PreguntaDto;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/pull-the-lever"+"/v1")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/preguntas")
    public GameResponse<List<PreguntaDto>> getPreguntas() throws GameException {
        return new GameResponse<>("Success",String.valueOf(HttpStatus.OK),"OKAY", preguntaService.getPreguntas());
    }
}
