package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumericRandomizer implements TypeRandomizer{

    @Override
    public Number getRandomValue() {
        return (new Random()).nextDouble();
    }

    @Override
    public FieldType getType() {
        return FieldType.NUMERIC;
    }
}
