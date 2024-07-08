package com.library.library.controller;

import com.library.library.DTO.LibraryDTO;
import com.library.library.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    @Autowired
    LibraryService service;

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LibraryDTO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LibraryDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LibraryDTO create(@RequestBody LibraryDTO addEntityBook) {
        return service.create(addEntityBook);
    }

    @PutMapping(value = "/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LibraryDTO update(@RequestBody LibraryDTO updateEntityBook) {
        return service.update(updateEntityBook);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long deleteEntityBook) {
        service.delete(deleteEntityBook);
        return ResponseEntity.noContent().build();
    }
}
