package com.nicolas.p2teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.p2teste.entities.Anuncio;

public interface AnuncioRepository extends JpaRepository <Anuncio, Integer> {
    
}
