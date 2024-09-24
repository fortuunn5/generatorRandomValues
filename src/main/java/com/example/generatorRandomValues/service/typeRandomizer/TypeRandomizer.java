package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;

public interface TypeRandomizer {
    FieldType getType();
    Object getRandomValue();
}
