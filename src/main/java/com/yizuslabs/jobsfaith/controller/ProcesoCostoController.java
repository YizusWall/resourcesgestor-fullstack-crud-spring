package com.yizuslabs.jobsfaith.controller;

import com.yizuslabs.jobsfaith.persistence.model.TbProcesoCosto;
import com.yizuslabs.jobsfaith.persistence.repository.ProcesoCostoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/procesocosto"})
public class ProcesoCostoController {

    private ProcesoCostoRepository repository;

    ProcesoCostoController(ProcesoCostoRepository repository) {
        this.repository = repository;
    }

    //Retrieve All Contacts (GET /contacts)
    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    // Retrieve a Contact by ID (GET /contacts/{id})
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TbProcesoCosto> findById(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    //Create a new Contact (POST /contacts)
    @PostMapping
    public TbProcesoCosto create(@RequestBody TbProcesoCosto procesoCosto) {
        return repository.save(procesoCosto);
    }

    //Update a Contact (PUT /contacts)
    @PutMapping(value = "/{id}")
    public ResponseEntity<TbProcesoCosto> update(@PathVariable("id") long id,
                                                 @RequestBody TbProcesoCosto procesoCosto) {
        return repository.findById(id)
                .map(record -> {
                    record.setCodEmpleado(procesoCosto.getCodEmpleado());
                    record.setCodFormato(procesoCosto.getCodFormato());
                    record.setCostoAsignado(procesoCosto.getCostoAsignado());
                    TbProcesoCosto updated = repository.save(record);
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
