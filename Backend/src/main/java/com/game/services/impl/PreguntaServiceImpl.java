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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        pregunta.setDescripcion(createPreguntaDto.getDescripcion());
        pregunta.setImg("https://picsum.photos/100");
        pregunta.setCant_si(0l);
        pregunta.setCant_no(0l);
        pregunta.setVisitas(0l);
        pregunta.setFecha_creacion(createPreguntaDto.getFecha_creacion());
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

        pregunta.setVisitas(pregunta.getVisitas() + 1);
        try {
            pregunta = preguntaRepository.save(pregunta);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getPreguntaEntity(pregunta.getId()), PreguntaDto.class);
    }

    @Override
    public List<PreguntaDto> getPreguntas() throws GameException {
        List<Pregunta> preguntasEntity = preguntaRepository.findAll();
        return preguntasEntity.stream().map(pregunta->modelMapper.map(pregunta,PreguntaDto.class)).collect(Collectors.toList());
    }

    @Override
    public void updatePregunta(PreguntaDto preguntaDto) throws GameException {
        Pregunta pregunta = preguntaRepository.findById(preguntaDto.getId())
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404", "PREGUNTA_NOTFOUND-404"));

        pregunta.setNombre(preguntaDto.getNombre());
        pregunta.setDescripcion(preguntaDto.getDescripcion());

        try{
            pregunta = preguntaRepository.save(pregunta);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
    }

    @Override
    public void deletePreguntaById(Long preguntaId) {
        preguntaRepository.deleteById(preguntaId);
    }

    @Override
    public Page<Pregunta> findAll(Pageable pageable) throws GameException {
        return preguntaRepository.findAll(pageable);
    }


    private Pregunta getPreguntaEntity(Long preguntaID) throws GameException{
        return preguntaRepository.findById(preguntaID)
                .orElseThrow(() -> new NotFoundException("NOT FOUND-404","PREGUNTA_NOTFOUND-404"));
    }
}