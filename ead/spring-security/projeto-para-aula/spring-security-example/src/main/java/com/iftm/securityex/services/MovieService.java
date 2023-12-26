package com.iftm.securityex.services;

import com.iftm.securityex.entities.Movie;
import com.iftm.securityex.repositories.MovieRepository;
import com.iftm.securityex.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private PersonRepository personRepository;


    public ResponseEntity<List<Movie>> findAll() {
        var dbMovies = repository.findAll();
        if(dbMovies.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(dbMovies);
    }

    public ResponseEntity<Movie> findById(String id) {
        var dbMovie = repository.findById(id);
        if(dbMovie.isEmpty())
            return ResponseEntity.noContent().build();
        return  ResponseEntity.ok(dbMovie.get());
    }

    public ResponseEntity<Movie> save(Movie movie) {
        return ResponseEntity.ok(repository.save(movie));
    }

    public ResponseEntity<Movie> update(Movie movie) {
        if(movie.getId() == null)
            return ResponseEntity.badRequest().build();

        var dbMovie = repository.findById(movie.getId());
        var curMovie = dbMovie.get();

        curMovie.setDescription(movie.getDescription());
        curMovie.setTitle(movie.getTitle());

        return ResponseEntity.ok(repository.save(curMovie));
    }

    public ResponseEntity<Movie> addActor(String movieId, String actorId) {
        var dbMovie = repository.findById(movieId);
        if(dbMovie.isEmpty())
            return ResponseEntity.badRequest().build();

        var dbActor = personRepository.findById(actorId);
        if(dbActor.isEmpty())
            return ResponseEntity.badRequest().build();

        var curMovie = dbMovie.get();
        var curActor = dbActor.get();

        curMovie.getActors().add(curActor);
        return ResponseEntity.ok(repository.save(curMovie));
    }

    public ResponseEntity<Movie> addDirector(String movieId, String directorId) {
        var dbMovie = repository.findById(movieId);
        if(dbMovie.isEmpty())
            return ResponseEntity.badRequest().build();

        var dbDictor = personRepository.findById(directorId);
        if(dbDictor.isEmpty())
            return ResponseEntity.badRequest().build();

        var curMovie = dbMovie.get();
        var curDictor = dbDictor.get();

        curMovie.getDirectors().add(curDictor);
        return ResponseEntity.ok(repository.save(curMovie));
    }

    public ResponseEntity<?> delete(String id) {
        repository.deleteById(id);
        if(!repository.findById(id).isEmpty())
            return ResponseEntity.badRequest().build();
        return ResponseEntity.noContent().build();
    }
}
