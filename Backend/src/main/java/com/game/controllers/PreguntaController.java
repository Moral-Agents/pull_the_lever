package com.game.controllers;

import com.game.dtos.*;
import com.game.entities.Pregunta;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pull"+"/v1")
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
    @PutMapping("/preguntas")
    public void updatePregunta(@RequestBody UpdatePreguntaDto updatePreguntaDto) throws GameException{
        preguntaService.updatePregunta(updatePreguntaDto);
    }

    @DeleteMapping("/preguntas/{preguntaId}")
    public void deletePregunta(@PathVariable Long preguntaId){
        preguntaService.deletePreguntaById(preguntaId);
    }
}
