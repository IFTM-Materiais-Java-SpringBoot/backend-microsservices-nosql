package com.iftm.logpool.services;

import com.iftm.logpool.models.dtos.LogDTO;
import com.iftm.logpool.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogRepository repository;

    public ResponseEntity<List<LogDTO>> findAll() {
        var dbLogs = repository.findAll();
        if(dbLogs == null || dbLogs.isEmpty())
            return ResponseEntity.notFound().build();
        var dbLogsDTO = dbLogs.stream().map(log -> {
            return new LogDTO(log);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dbLogsDTO);
    }

    public ResponseEntity<LogDTO> save(LogDTO logDTO) {
        if(logDTO.getAction().isBlank() || logDTO.getObject() == null)
            return ResponseEntity.badRequest().build();
        var dbLog = repository.save(logDTO.toLog());
        return ResponseEntity.ok(new LogDTO(dbLog));
    }
}
