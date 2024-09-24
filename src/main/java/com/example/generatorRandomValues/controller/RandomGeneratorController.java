package com.example.generatorRandomValues.controller;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.dto.RequestSchema;
import com.example.generatorRandomValues.service.RandomValueGeneratorService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RandomGeneratorController {
    private final RandomValueGeneratorService randomValueGeneratorService;

    @GetMapping
    public ResponseEntity<?> getValueByFieldType(@RequestBody RequestSchema schema){
        return ResponseEntity.ok(randomValueGeneratorService.generateValue(schema.getFields().get(0).getType()));
    }
}
