package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.dto.RequestSchema;

import java.util.List;
import java.util.Map;

public interface RandomValueGeneratorService {
    Object generateValue(FieldType type);

    List<Map<String, Object>> generateValuesBySchema(RequestSchema schema);
}
