package com.game.controllers;

import com.game.dtos.ComentarioDto;
import com.game.dtos.CreateComentarioDto;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pull-the-lever"+"/v1")
public class ComentarioController {


    @Autowired
    private ComentarioService comentarioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/comentarios/{preguntaId}")
    public GameResponse<List<ComentarioDto>> getComentariosByPreguntaId(@PathVariable Long preguntaId) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                comentarioService.getComentariosByPreguntaId(preguntaId));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/comentarios")
    public GameResponse<ComentarioDto> createComentario(@RequestBody CreateComentarioDto createComentarioDto) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                comentarioService.createComentario(createComentarioDto));

    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateComentarios/{comentarioId}/{comentarioDescripcion}")
    public void updateComentarioById(@PathVariable Long comentarioId, @PathVariable String comentarioDescripcion) throws GameException{
        comentarioService.updateComentarioById(comentarioId, comentarioDescripcion);
    }

    @DeleteMapping("/deleteComentarios/{comentarioId}")
    public void deleteComentario(@PathVariable Long comentarioId){
        comentarioService.deleteComentario(comentarioId);
    }
}
