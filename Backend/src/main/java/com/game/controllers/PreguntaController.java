package com.game.controllers;

import com.game.dtos.CreatePreguntaDto;
import com.game.dtos.CreateUsuarioDto;
import com.game.dtos.PreguntaDto;
import com.game.dtos.UsuarioDto;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/preguntas")
    public GameResponse<PreguntaDto> createPregunta(@RequestBody CreatePreguntaDto createPreguntaDto) throws GameException {
        return new GameResponse<>("Success",String.valueOf(HttpStatus.OK), "OK",
                preguntaService.createPregunta(createPreguntaDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/preguntas/{preguntaId}")
    public GameResponse<PreguntaDto> getPreguntaById(@PathVariable Long preguntaId) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                preguntaService.getPreguntaById(preguntaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updatePregunta")
    public void updatePregunta(@RequestBody PreguntaDto preguntaDto) throws GameException{
        preguntaService.updatePregunta(preguntaDto);
    }

    @DeleteMapping("/deletePregunta/{preguntaId}")
    public void deletePregunta(@PathVariable Long preguntaId){
        preguntaService.deletePreguntaById(preguntaId);
    }
}
