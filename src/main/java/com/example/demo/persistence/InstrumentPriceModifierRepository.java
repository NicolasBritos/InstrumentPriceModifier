package com.example.demo.persistence;

import com.example.demo.model.InstrumentPriceModifier;
import org.springframework.data.repository.CrudRepository;

public interface InstrumentPriceModifierRepository extends CrudRepository<InstrumentPriceModifier, Long> {
}
