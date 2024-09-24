package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;

public interface RandomValueGeneratorService {
    Object generateValue(FieldType type);
}
