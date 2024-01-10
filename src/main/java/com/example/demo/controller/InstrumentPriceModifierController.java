package com.example.demo.controller;

import com.example.demo.model.InstrumentPriceModifier;
import com.example.demo.service.InstrumentPriceModifierService;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modifiers")
public class InstrumentPriceModifierController {

    @Autowired
    private final InstrumentPriceModifierService service;

    @Autowired
    public InstrumentPriceModifierController(InstrumentPriceModifierService service) {
        this.service = service;
    }

    @GetMapping
    public List<InstrumentPriceModifier> getAllModifiers() {
        return service.getAllModifiers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentPriceModifier> getModifierById(@PathVariable Long id) {
        return service.getModifierById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InstrumentPriceModifier> createModifier(@RequestBody InstrumentPriceModifier modifier) {
        InstrumentPriceModifier createdModifier = service.createModifier(modifier);
        return ResponseEntity.ok(createdModifier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentPriceModifier> updateModifier(@PathVariable Long id, @RequestBody InstrumentPriceModifier modifier) {
        try {
            InstrumentPriceModifier updatedModifier = service.updateModifier(id, modifier);
            return ResponseEntity.ok(updatedModifier);
        } catch (PersistenceException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModifier(@PathVariable Long id) {
        try {
            service.deleteModifier(id);
            return ResponseEntity.noContent().build();
        } catch (PersistenceException e) {
            return ResponseEntity.notFound().build();
        }
    }
}