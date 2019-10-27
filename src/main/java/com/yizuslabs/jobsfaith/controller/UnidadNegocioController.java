package com.yizuslabs.jobsfaith.controller;

import com.yizuslabs.jobsfaith.persistence.model.TbUnidadNegocio;
import com.yizuslabs.jobsfaith.persistence.repository.UnidadNegocioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/unidadnegocio"})
public class UnidadNegocioController {

    private final Logger log = LoggerFactory.getLogger(UnidadNegocioController.class);

    private UnidadNegocioRepository repository;

    UnidadNegocioController(UnidadNegocioRepository repository) {
        this.repository = repository;
    }

    //Retrieve All Contacts (GET /contacts)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    // Retrieve a Contact by ID (GET /contacts/{id})
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TbUnidadNegocio> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Create a new Contact (POST /contacts)
    @PostMapping
    public TbUnidadNegocio create(@Valid @RequestBody TbUnidadNegocio unidadNegocio, Errors errors) {


        System.out.println(" getDesUnidad " + unidadNegocio.getDesUnidad());
        System.out.println(" getUserCrea " + unidadNegocio.getUserCrea());

        return repository.save(unidadNegocio);
    }

    //Update a Contact (PUT /contacts)
    @PutMapping(value = "/{id}")
    public ResponseEntity<TbUnidadNegocio> update(@PathVariable("id") long id,
                                                  @RequestBody TbUnidadNegocio unidadNegocio) {


        System.out.println(" hola11 " + unidadNegocio.getObsUnidad());

        return repository.findById(id)
                .map(record -> {
                    record.setDesUnidad(unidadNegocio.getDesUnidad());
                    record.setCodTipUnidad(unidadNegocio.getCodTipUnidad());
                    record.setObsUnidad(unidadNegocio.getObsUnidad());
                    TbUnidadNegocio updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //Remove a Contact (DELETE /contacts/{id})
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
