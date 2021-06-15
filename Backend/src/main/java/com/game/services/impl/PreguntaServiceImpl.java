package com.game.services.impl;

import com.game.dtos.CreatePreguntaDto;
import com.game.dtos.PreguntaDto;
import com.game.entities.Pregunta;
import com.game.exceptions.GameException;
import com.game.exceptions.InternalServerErrorException;
import com.game.exceptions.NotFoundException;
import com.game.repositories.PreguntaRepository;
import com.game.services.PreguntaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private PreguntaRepository preguntaRepository;



    @Transactional
    @Override
    public PreguntaDto createPregunta(CreatePreguntaDto createPreguntaDto) throws GameException{
        Pregunta pregunta = new Pregunta();
        pregunta.setNombre(createPreguntaDto.getNombre());
        pregunta.setImg(createPreguntaDto.getImg());
        pregunta.setCant_si(createPreguntaDto.getCant_si());
        pregunta.setCant_no(createPreguntaDto.getCant_no());
        try {
            pregunta = preguntaRepository.save(pregunta);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getPreguntaEntity(pregunta.getId()), PreguntaDto.class);
    }

    @Override
    public PreguntaDto getPreguntaById(Long preguntaId) throws GameException {
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404", "PREGUNTA_NOTFOUND-404"));

        return modelMapper.map(getPreguntaEntity(pregunta.getId()), PreguntaDto.class);
    }

    @Override
    public List<PreguntaDto> getPreguntas() throws GameException {
        List<Pregunta> preguntasEntity = preguntaRepository.findAll();
        return preguntasEntity.stream().map(pregunta->modelMapper.map(pregunta,PreguntaDto.class)).collect(Collectors.toList());
    }


    private Pregunta getPreguntaEntity(Long preguntaID) throws GameException{
        return preguntaRepository.findById(preguntaID)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404","PREGUNTA_NOTFOUND-404"));
    }
}