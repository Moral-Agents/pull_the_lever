package com.game.services.impl;

import com.game.dtos.CreateRespuestaDto;
import com.game.dtos.RespuestaDto;
import com.game.entities.Pregunta;
import com.game.entities.Respuesta;
import com.game.entities.Usuario;
import com.game.exceptions.GameException;
import com.game.exceptions.InternalServerErrorException;
import com.game.exceptions.NotFoundException;
import com.game.repositories.PreguntaRepository;
import com.game.repositories.RespuestaRepository;
import com.game.repositories.UsuarioRepository;
import com.game.services.RespuestaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    public static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private PreguntaRepository preguntaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public RespuestaDto createRespuesta(CreateRespuestaDto createRespuestaDto) throws GameException{
        Pregunta pregunta = preguntaRepository.findById(createRespuestaDto.getPreguntaId())
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "PREGUNTA_NOT_FOUND"));
        Usuario usuario = usuarioRepository.findById(createRespuestaDto.getUsuarioId())
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "USUARIO_NOT_FOUND"));

        if (respuestaRepository.findByPreguntaIdAndUsuarioId(pregunta.getId(), usuario.getId()).isPresent()) {
            throw new NotFoundException("Respuesta-401-1", "Respuesta_EXIST");
        }

        Respuesta respuesta = new Respuesta();
        respuesta.setEdad(usuario.getEdad());
        respuesta.setNacionalidad(usuario.getNacionalidad());
        respuesta.setGenero(usuario.getGenero());
        respuesta.setRespuesta(createRespuestaDto.getRespuesta());
        respuesta.setPregunta(pregunta);
        respuesta.setUsuario(usuario);

        if(respuesta.getRespuesta() == 0){
            pregunta.setCant_1(pregunta.getCant_1() + 1);
        }
        if(respuesta.getRespuesta() == 1){
            pregunta.setCant_2(pregunta.getCant_2() + 1);
        }

        try {
            respuesta = respuestaRepository.save(respuesta);
            pregunta = preguntaRepository.save(pregunta);
        } catch (Exception  ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getRespuestaEntity(respuesta.getId()), RespuestaDto.class);
    }

    @Override
    public List<RespuestaDto> getRespuestasByPreguntaId(Long preguntaId) throws GameException{
        List<Respuesta> respuestasEntity = respuestaRepository.findAllByPreguntaId(preguntaId);
        return respuestasEntity.stream().map(respuesta -> modelMapper.map(respuesta, RespuestaDto.class)).collect(Collectors.toList());
    }

    @Override
    public RespuestaDto getRespuestaByPreguntaIdAndUsuarioId(Long preguntaId, Long usuarioId) throws GameException {
        Respuesta respuesta = respuestaRepository.findByPreguntaIdAndUsuarioId(preguntaId, usuarioId)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404", "RESPUESTA_NOTFOUND-404"));

        return modelMapper.map(getRespuestaEntity(respuesta.getId()), RespuestaDto.class);
    }

    @Override
    public void deleteRespuestaByPreguntaId(Long preguntaId) {
        List<Respuesta> respuestas = respuestaRepository.findAllByPreguntaId(preguntaId);
        for (int i = 0; i < respuestas.size(); i++){
            respuestaRepository.deleteById(respuestas.get(i).getId());
        }
    }

    private Respuesta getRespuestaEntity(Long preguntaId) throws GameException{
        return respuestaRepository.findById(preguntaId)
                .orElseThrow(()-> new NotFoundException("NOT-401-1", "RESPUESTA_NOT_FOUND"));
    }
}