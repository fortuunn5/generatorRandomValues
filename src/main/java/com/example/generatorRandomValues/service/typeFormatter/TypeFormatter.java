package com.example.generatorRandomValues.service.typeFormatter;

import com.example.generatorRandomValues.service.TypeFilterable;

public interface TypeFormatter extends TypeFilterable {
    String format(Object obj, String format);
    String getDefaultFormat();
}
