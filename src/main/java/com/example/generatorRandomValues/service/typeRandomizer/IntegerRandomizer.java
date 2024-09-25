package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IntegerRandomizer implements TypeRandomizer {

    @Override
    public FieldType getType() {
        return FieldType.INTEGER;
    }

    @Override
    public Integer getRandomValue() {
        Random random = new Random();
        return random.nextInt();
    }
}
