package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.service.TypeFilterable;

public interface TypeRandomizer extends TypeFilterable {
    Object getRandomValue();
}
