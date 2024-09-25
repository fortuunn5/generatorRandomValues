package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class TimeRandomizer implements TypeRandomizer{
    @Override
    public FieldType getType() {
        return FieldType.TIME;
    }

    @Override
    public LocalTime getRandomValue() {
        Random random = new Random();
        // todo move to constants
        return LocalTime.of(random.nextInt( 0, 23),
                random.nextInt(0, 59),
                random.nextInt(0, 59));
    }
}
