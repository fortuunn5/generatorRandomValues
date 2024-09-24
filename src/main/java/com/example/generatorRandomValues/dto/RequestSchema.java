package com.example.generatorRandomValues.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class RequestSchema {
    int count;
    List<RequestField> fields = new ArrayList<>();
}
