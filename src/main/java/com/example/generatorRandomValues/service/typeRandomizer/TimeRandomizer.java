package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class TimeRandomizer implements TypeRandomizer {

    @Override
    public FieldType getType() {
        return FieldType.TIME;
    }

    @Override
    public LocalTime getRandomValue() {
        Random random = new Random();
        return LocalTime.ofSecondOfDay(random.nextLong(86399));
    }
}
