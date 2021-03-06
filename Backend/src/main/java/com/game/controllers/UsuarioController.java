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
@RequestMapping(path="/pull"+"/v1")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/usuarios")
    public GameResponse<UsuarioDto> createUsuario(@RequestBody CreateUsuarioDto createUsuarioDto) throws GameException {
        return new GameResponse<>("Success",String.valueOf(HttpStatus.OK), "OK",
                usuarioService.createUsuario(createUsuarioDto));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/usuarios/{correoUsuario}/{claveUsuario}")
    public GameResponse<UsuarioDto> getUsuarioByCorreoAndClave(@PathVariable String correoUsuario, @PathVariable String claveUsuario) throws GameException{
        return new GameResponse<>("Success", String.valueOf(HttpStatus.OK),"OK",
                usuarioService.getUsuarioByCorreoAndClave(correoUsuario, claveUsuario));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/usuarios/tipo/{correoUsuario}/{tipoUsuario}")
    public void updateTipoDeUsuario(@PathVariable String correoUsuario, @PathVariable Character tipoUsuario) throws GameException{
        usuarioService.updateTipoUsuario(correoUsuario, tipoUsuario);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/usuarios/{correoUsuario}/{claveUsuario}")
    public void updateClave(@PathVariable String correoUsuario, @PathVariable String claveUsuario) throws GameException{
        usuarioService.updateClave(correoUsuario, claveUsuario);
    }
}
