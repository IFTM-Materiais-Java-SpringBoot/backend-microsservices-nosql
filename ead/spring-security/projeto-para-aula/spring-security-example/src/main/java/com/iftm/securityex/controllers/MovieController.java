package com.iftm.securityex.controllers;

import com.iftm.securityex.entities.Movie;
import com.iftm.securityex.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody Movie movie) {
        return service.save(movie);
    }

    @PostMapping("/{idMovie}/actor/{idActor}")
    public ResponseEntity<Movie> addActor(@PathVariable("idMovie") String idMovie, @PathVariable("idActor") String idActor) {
        return service.addActor(idMovie, idActor);
    }

    @PostMapping("/{idMovie}/director/{idDirector}")
    public ResponseEntity<Movie> addDirector(@PathVariable("idMovie") String idMovie, @PathVariable("idDirector") String idDirector) {
        return service.addDirector(idMovie, idDirector);
    }

    @PutMapping
    public ResponseEntity<Movie> update(@RequestBody Movie movie) {
        return service.update(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
