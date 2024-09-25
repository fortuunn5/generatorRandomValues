package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CharRandomizer implements TypeRandomizer{
    @Override
    public FieldType getType() {
        return FieldType.CHAR;
    }

    @Override
    public Character getRandomValue() {
        Random random = new Random();
        return (char) random.nextInt(0, 127);
    }
}
