package com.example.generatorRandomValues.service.typeRandomizer;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DateRandomizer implements TypeRandomizer{
    @Override
    public FieldType getType() {
        return FieldType.DATE;
    }

    @Override
    public LocalDate getRandomValue() {
        int hundredYears = 100 * 365;
        Random random = new Random();
        return LocalDate.ofEpochDay(random.nextInt(-hundredYears, hundredYears));
    }
}
