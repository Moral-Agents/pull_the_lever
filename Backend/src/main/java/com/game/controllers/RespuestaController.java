package com.game.controllers;

import com.game.dtos.CreateRespuestaDto;
import com.game.dtos.RespuestaDto;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pull-the-lever"+"/v1")
public class RespuestaController {


   @Autowired
   private RespuestaService respuestaService;

   @ResponseStatus(HttpStatus.OK)
   @GetMapping("/respuestas/{preguntaId}")
   public GameResponse<List<RespuestaDto>> getRespuestaByPreguntaId(@PathVariable Long preguntaId) throws GameException{
       return new GameResponse<>("Success",  String.valueOf(HttpStatus.OK), "OK",
               respuestaService.getRespuestaByPreguntaId(preguntaId));
   }

   @ResponseStatus(HttpStatus.OK)
   @PostMapping("/respuestas")
   public GameResponse<RespuestaDto> createRespuesta(@RequestBody CreateRespuestaDto createRespuestaDto) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                respuestaService.createRespuesta(createRespuestaDto));
   }
}
