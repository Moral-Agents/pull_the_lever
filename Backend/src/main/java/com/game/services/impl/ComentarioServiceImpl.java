package com.game.services.impl;

import com.game.dtos.ComentarioDto;
import com.game.dtos.CreateComentarioDto;
import com.game.entities.Comentario;
import com.game.entities.Pregunta;
import com.game.entities.Usuario;
import com.game.exceptions.GameException;
import com.game.exceptions.InternalServerErrorException;
import com.game.exceptions.NotFoundException;
import com.game.repositories.ComentarioRepository;
import com.game.repositories.PreguntaRepository;
import com.game.repositories.UsuarioRepository;
import com.game.services.ComentarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public ComentarioDto createComentario(CreateComentarioDto createComentarioDto) throws GameException {
        Pregunta pregunta = preguntaRepository.findById(createComentarioDto.getPreguntaId())
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "PREGUNTA_NOT_FOUND"));
        Usuario usuario = usuarioRepository.findById(createComentarioDto.getUsuarioId())
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "USUARIO_NOT_FOUND"));

        Comentario comentario = new Comentario();
        comentario.setComentario(createComentarioDto.getComentario());
        comentario.setPregunta(pregunta);
        comentario.setUsuario(usuario);

        try {
            comentario=comentarioRepository.save(comentario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getComentarioEntity(comentario.getId()), ComentarioDto.class);
    }



    @Override
    public List<ComentarioDto> getComentariosByPreguntaId(Long preguntaId) throws GameException {
        List<Comentario> comentariosEntity = comentarioRepository.findAllByPreguntaId(preguntaId);
        return comentariosEntity.stream().map(comentario -> modelMapper.map(comentario, ComentarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updateComentario(ComentarioDto comentarioDto) throws GameException {
        Comentario comentario = comentarioRepository.findById(comentarioDto.getId())
                .orElseThrow(()-> new NotFoundException("NOT FOUND-404", "COMENTARIO_NOTFOUND-404"));

        comentario.setComentario(comentarioDto.getComentario());

        try {
            comentario = comentarioRepository.save(comentario);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
    }

    @Override
    public void deleteComentario(Long comentarioId) {
        comentarioRepository.deleteById(comentarioId);
    }

    private Comentario getComentarioEntity(Long comentarioId) throws GameException {
        return comentarioRepository.findById(comentarioId)
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "COMENTARIO_NOT_FOUND"));
    }
}
