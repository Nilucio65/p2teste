package com.nicolas.p2teste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.p2teste.entities.Anuncio;
import com.nicolas.p2teste.repositories.AnuncioRepository;


@Service
public class AnuncioService {
    
    @Autowired
    private AnuncioRepository anuncioRepository;

    public Anuncio save(Anuncio anuncio) {
        return anuncioRepository.save(anuncio);
    }

    public List<Anuncio> getAnuncios(){
        return anuncioRepository.findAll();
    }
}
