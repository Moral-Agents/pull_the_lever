package com.game.controllers;

import com.game.dtos.CreateUsuarioDto;
import com.game.dtos.UsuarioDto;
import com.game.exceptions.GameException;
import com.game.responses.GameResponse;
import com.game.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/pull-the-lever"+"/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuario")
    public GameResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto) throws GameException {
        return new GameResponse<>("Success",String.valueOf(HttpStatus.OK), "OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

}
