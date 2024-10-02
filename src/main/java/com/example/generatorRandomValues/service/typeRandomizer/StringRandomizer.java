package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StringRandomizer implements TypeRandomizer {

    final int MIN_CHAR_COUNT = 1;
    final int MAX_CHAR_COUNT = 100;
    final int START_ASCII_CODE = 0;
    final int END_ASCII_CODE = 127;

    @Override
    public FieldType getType() {
        return FieldType.STRING;
    }

    @Override
    public String getRandomValue() {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        int count = random.nextInt(MIN_CHAR_COUNT, MAX_CHAR_COUNT);
        for (int i = 0; i < count; i++) {
            randomString.append((char) random.nextInt(START_ASCII_CODE, END_ASCII_CODE));
        }
        return randomString.toString();
    }
}
