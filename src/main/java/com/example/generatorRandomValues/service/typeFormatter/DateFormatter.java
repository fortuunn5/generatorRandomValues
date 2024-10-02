package com.example.generatorRandomValues.service.typeFormatter;

import com.example.generatorRandomValues.dto.FieldType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DateFormatter extends AbstractTypeFormatter {

    @Override
    protected String getStringFormattedData(Object obj, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = (LocalDate) obj;
        return formatter.format(localDate);
    }

    @Override
    public String getDefaultFormat() {
        return "dd.MM.yyyy";
    }

    @Override
    public FieldType getType() {
        return FieldType.DATE;
    }
}
