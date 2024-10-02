package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class TimeRandomizer implements TypeRandomizer {

    private final int MIN_SEC = 0;
    private final int MAX_SEC = 86399;

    @Override
    public FieldType getType() {
        return FieldType.TIME;
    }

    @Override
    public LocalTime getRandomValue() {
        Random random = new Random();
        return LocalTime.ofSecondOfDay(random.nextLong(MIN_SEC, MAX_SEC));
    }
}
