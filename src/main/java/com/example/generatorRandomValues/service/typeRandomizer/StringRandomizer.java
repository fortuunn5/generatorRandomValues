package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class StringRandomizer implements TypeRandomizer{
    @Override
    public FieldType getType() {
        return FieldType.STRING;
    }

    @Override
    public String getRandomValue() {
        StringBuilder randomString = new StringBuilder();
        Random random = new Random();
        // todo move to constants
        int count = random.nextInt(1, 100);
        for(int i =0; i<count; i++) {
            // todo move to constants
            randomString.append((char) random.nextInt(0, 127));
        }
        return randomString.toString();
    }
}
