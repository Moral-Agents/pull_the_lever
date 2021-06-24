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
@RequestMapping(path="/pull"+"/v1")
public class RespuestaController {


   @Autowired
   private RespuestaService respuestaService;

   @ResponseStatus(HttpStatus.OK)
   @GetMapping("/respuestas/{preguntaId}")
   public GameResponse<List<RespuestaDto>> getRespuestasByPreguntaId(@PathVariable Long preguntaId) throws GameException{
       return new GameResponse<>("Success",  String.valueOf(HttpStatus.OK), "OK",
               respuestaService.getRespuestasByPreguntaId(preguntaId));
   }

   @ResponseStatus(HttpStatus.OK)
   @PostMapping("/respuestas")
   public GameResponse<RespuestaDto> createRespuesta(@RequestBody CreateRespuestaDto createRespuestaDto) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
                respuestaService.createRespuesta(createRespuestaDto));
   }

   @ResponseStatus(HttpStatus.OK)
   @GetMapping("/respuestas/{preguntaId}/{usuarioId}")
   public GameResponse<RespuestaDto> getRespuestaByPreguntaIdAndUsuarioId(@PathVariable Long preguntaId, @PathVariable Long usuarioId) throws GameException{
      return new GameResponse<>("Success", String.valueOf(HttpStatus.OK), "OK",
              respuestaService.getRespuestaByPreguntaIdAndUsuarioId(preguntaId, usuarioId));
   }

   @DeleteMapping("/respuestas/{preguntaId}")
   public void deleteRespuestasByPreguntaId(@PathVariable Long preguntaId){
      respuestaService.deleteRespuestaByPreguntaId(preguntaId);
   }
}
