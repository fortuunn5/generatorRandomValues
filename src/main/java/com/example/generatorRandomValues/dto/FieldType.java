package com.example.generatorRandomValues.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

@Getter
@AllArgsConstructor
public enum FieldType {
    NUMERIC("Numeric", Number.class),
    STRING("String", String.class),
    DATE("Date", LocalDate.class),
    TIME("Time", LocalTime.class),
    DATE_AND_TIME("DateAndTime", Date.class),
    INTEGER("Integer", Integer.class),
    CHAR("Char", Character.class)
    ;


    private final String name;
    private final Class clazz;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static FieldType findByName(String name){
        return Arrays.stream(values())
                .filter(x -> x.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return name;
    }
}
