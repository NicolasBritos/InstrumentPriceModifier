package com.example.demo.service;

import com.example.demo.model.InstrumentPriceModifier;

import java.util.List;
import java.util.Optional;

public interface InstrumentPriceModifierService {

    List<InstrumentPriceModifier> getAllModifiers();

    Optional<InstrumentPriceModifier> getModifierById(Long id);

    InstrumentPriceModifier createModifier(InstrumentPriceModifier modifier);

    InstrumentPriceModifier updateModifier(Long id, InstrumentPriceModifier modifier);

    void deleteModifier(Long id);
}
