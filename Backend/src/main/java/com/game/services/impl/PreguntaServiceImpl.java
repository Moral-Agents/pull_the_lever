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

    private Pregunta getPreguntaEntity(Long preguntaID) throws GameException{
        return preguntaRepository.findById(preguntaID)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404","PREGUNTA_NOTFOUND-404"));
    }
}