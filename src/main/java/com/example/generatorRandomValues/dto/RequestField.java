package com.example.generatorRandomValues.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestField {
    private FieldType type;
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String format;
}




