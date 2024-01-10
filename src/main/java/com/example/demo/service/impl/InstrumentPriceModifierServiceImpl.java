package com.example.demo.service.impl;

import com.example.demo.model.InstrumentPriceModifier;
import com.example.demo.persistence.InstrumentPriceModifierRepository;
import com.example.demo.service.InstrumentPriceModifierService;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentPriceModifierServiceImpl implements InstrumentPriceModifierService {

    private final InstrumentPriceModifierRepository repository;

    @Autowired
    public InstrumentPriceModifierServiceImpl(InstrumentPriceModifierRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<InstrumentPriceModifier> getAllModifiers() {
        return (List<InstrumentPriceModifier>) repository.findAll();
    }

    @Override
    public Optional<InstrumentPriceModifier> getModifierById(Long id) {
        return repository.findById(id);
    }

    @Override
    public InstrumentPriceModifier createModifier(InstrumentPriceModifier modifier) {
        return repository.save(modifier);
    }

    @Override
    public InstrumentPriceModifier updateModifier(Long id, InstrumentPriceModifier modifier) {
        InstrumentPriceModifier existingModifier = repository.findById(id)
                .orElseThrow(() -> new PersistenceException("InstrumentPriceModifier with id " + id + " not found"));

        modifier.setId(id);
        repository.save(modifier);

        return modifier;
    }

    @Override
    public void deleteModifier(Long id) {
        repository.deleteById(id);
    }
}
