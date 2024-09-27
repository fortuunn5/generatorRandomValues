package com.example.generatorRandomValues.controller;

import com.example.generatorRandomValues.dto.RequestSchema;
import com.example.generatorRandomValues.service.RandomValueGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RandomGeneratorController {
    private final RandomValueGeneratorService randomValueGeneratorService;

    @GetMapping
    public ResponseEntity<?> getValueByFieldType(@RequestBody RequestSchema schema) {
        List<Map<String, Object>> values = new ArrayList<>();
        for (int i = 0; i < schema.getCount(); i++) {
            values.add(randomValueGeneratorService.generateValuesBySchema(schema));
        }
        return ResponseEntity.ok(values);
    }
}
