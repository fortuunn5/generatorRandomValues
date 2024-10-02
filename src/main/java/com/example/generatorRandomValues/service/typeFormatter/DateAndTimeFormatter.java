package com.example.generatorRandomValues.service.typeFormatter;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class DateAndTimeFormatter extends AbstractTypeFormatter {
    @Override
    protected String getStringFormattedData(Object obj, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(obj);
    }

    @Override
    public String getDefaultFormat() {
        return "dd.MM.yyyy HH:mm:ss";
    }

    @Override
    public FieldType getType() {
        return FieldType.DATE_AND_TIME;
    }
}
