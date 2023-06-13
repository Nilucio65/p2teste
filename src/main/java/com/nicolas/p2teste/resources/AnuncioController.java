package com.nicolas.p2teste.resources;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nicolas.p2teste.entities.Anuncio;
import com.nicolas.p2teste.services.AnuncioService;


@RestController
@RequestMapping("anuncio")
@CrossOrigin
public class AnuncioController {
    
    @Autowired
    private AnuncioService anuncioService;
    
    @GetMapping
    public ResponseEntity<List<Anuncio>> getAnuncios(){
        List<Anuncio> anuncio = anuncioService.getAnuncios();
        return ResponseEntity.ok().body(anuncio);
    }

    @PostMapping
    public ResponseEntity<Anuncio> saveAnuncio(@RequestBody Anuncio anuncio){
        Anuncio newAnuncio = anuncioService.save(anuncio);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(anuncio.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newAnuncio);
    }

   
}
