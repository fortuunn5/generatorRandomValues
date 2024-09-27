package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import jakarta.annotation.Nullable;

public interface RandomValueGeneratorService {
    Object getFormattedValue(FieldType type, @Nullable String format);
    Object generateValue(FieldType type);
}
