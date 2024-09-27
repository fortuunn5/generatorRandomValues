package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.dto.RequestSchema;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import com.example.generatorRandomValues.utils.ContextHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RandomValueGeneratorServiceImpl implements RandomValueGeneratorService {

    @Override
    public Object generateValue(FieldType type) {
        assert type != null;

        TypeRandomizer randomizerBeanByType = ContextHelper.getRandomizerBeanByType(type);
        return randomizerBeanByType.getRandomValue();
    }

    @Override
    public Map<String, Object> generateValuesBySchema(RequestSchema schema) {
        Map<String, Object> valueOfFields = new HashMap<>();
        for (int i = 0; i < schema.getFields().size(); i++) {
            valueOfFields.put(schema.getFields().get(i).getName(),
                    generateValue(schema.getFields().get(i).getType()));
        }
        return valueOfFields;
    }
}