package com.example.generatorRandomValues.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum FieldType {
    NUMERIC("Numeric", Number.class),
    STRING("String", String.class);

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
