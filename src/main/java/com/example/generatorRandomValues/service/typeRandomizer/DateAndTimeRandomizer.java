package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DateAndTimeRandomizer implements TypeRandomizer {
    @Override
    public FieldType getType() {
        return FieldType.DATE_AND_TIME;
    }

    @Override
    public Date getRandomValue() {
        Random random = new Random();
        return new Date(random.nextInt() * 1000L);
    }
}
