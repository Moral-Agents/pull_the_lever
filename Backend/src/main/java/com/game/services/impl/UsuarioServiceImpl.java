package com.game.services.impl;

import com.game.dtos.CreateUsuarioDto;
import com.game.dtos.UsuarioDto;
import com.game.entities.Usuario;
import com.game.exceptions.GameException;
import com.game.exceptions.InternalServerErrorException;
import com.game.exceptions.NotFoundException;
import com.game.repositories.UsuarioRepository;
import com.game.services.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    @Override
    public UsuarioDto createUsuario(CreateUsuarioDto createUsuarioDto) throws GameException{
        Usuario usuario = new Usuario();
        usuario.setNombre(createUsuarioDto.getNombre());
        usuario.setCorreo(createUsuarioDto.getCorreo());
        usuario.setClave(createUsuarioDto.getClave());
        usuario.setEdad(createUsuarioDto.getEdad());
        usuario.setNacionalidad(createUsuarioDto.getNacionalidad());
        usuario.setGenero(createUsuarioDto.getGenero());
        usuario.setTipo(createUsuarioDto.getTipo());

        try {
            usuario=usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getUsuarioEntity(usuario.getId()), UsuarioDto.class);

    }

    @Override
    public UsuarioDto getUsuarioByCorreoAndClave(String correoUsuario, String claveUsuario) throws GameException {
        Usuario usuario = usuarioRepository.findByCorreoAndClave(correoUsuario, claveUsuario)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404","USUARIO_NOTFOUND-404"));
        return modelMapper.map(getUsuarioEntity(usuario.getId()), UsuarioDto.class);
    }

    @Override
    public void updateTipoUsuario(String correoUsuario, Character tipoUsuario) throws GameException {
        Usuario usuario = usuarioRepository.findByCorreo(correoUsuario)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404", "USUARIO_NOTFOUND-404"));
        usuario.setTipo(tipoUsuario);

        try {
            usuario = usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
    }


    @Override
    public void updateClave(String correoUsuario, String claveUsuario) throws GameException {
        Usuario usuario = usuarioRepository.findByCorreo(correoUsuario)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404", "USUARIO_NOTFOUND-404"));
        usuario.setClave(claveUsuario);

        try {
            usuario = usuarioRepository.save(usuario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
    }

    private Usuario getUsuarioEntity(Long usuarioId) throws GameException {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404","USUARIO_NOTFOUND-404"));
    }


}
