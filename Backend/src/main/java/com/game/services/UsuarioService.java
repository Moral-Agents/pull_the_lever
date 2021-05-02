package com.game.services;

import com.game.dtos.CreateUsuarioDto;
import com.game.dtos.UsuarioDto;
import com.game.exceptions.GameException;

public interface UsuarioService {
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws GameException;
}
