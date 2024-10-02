package com.example.generatorRandomValues.service.typeFormatter;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeFormatter extends AbstractTypeFormatter {

    @Override
    protected String getStringFormattedData(Object obj, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalTime localTime = (LocalTime) obj;
        return formatter.format(localTime);
    }

    @Override
    public String getDefaultFormat() {
        return "HH:mm:ss";
    }

    @Override
    public FieldType getType() {
        return FieldType.TIME;
    }
}
