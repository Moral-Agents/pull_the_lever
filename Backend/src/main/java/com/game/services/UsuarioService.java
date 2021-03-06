package com.game.services;

import com.game.dtos.CreateUsuarioDto;
import com.game.dtos.UsuarioDto;
import com.game.entities.Usuario;
import com.game.exceptions.GameException;

public interface UsuarioService {
    UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws GameException;
    UsuarioDto getUsuarioByCorreoAndClave(String correoUsuario, String claveUsuario) throws GameException;
    void updateTipoUsuario(String correoUsuario, Character tipoUsuario) throws GameException;
    void updateClave(String correoUsuario, String claveUsuario) throws GameException;
}
