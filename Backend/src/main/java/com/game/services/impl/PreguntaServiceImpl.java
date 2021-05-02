package com.game.services.impl;

import com.game.dtos.PreguntaDto;
import com.game.entities.Pregunta;
import com.game.exceptions.GameException;
import com.game.repositories.PreguntaRepository;
import com.game.services.PreguntaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepository;

    private static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PreguntaDto> getPreguntas() throws GameException {
        List<Pregunta> preguntasEntity = preguntaRepository.findAll();
        return preguntasEntity.stream().map(pregunta->modelMapper.map(pregunta,PreguntaDto.class)).collect(Collectors.toList());
    }
}
