package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.dto.RequestField;
import com.example.generatorRandomValues.dto.RequestSchema;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import com.example.generatorRandomValues.utils.ContextHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public List<Map<String, Object>> generateValuesBySchema(RequestSchema schema) {
        List<Map<String, Object>> values = new ArrayList<>();
        for (int i = 0; i < schema.getCount(); i++) {
            values.add(generateValuesByFields(schema.getFields()));
        }
        return values;
    }

    private Map<String, Object> generateValuesByFields(List<RequestField> fields) {
        Map<String, Object> valueOfFields = new HashMap<>();
        for (RequestField field : fields) {
            valueOfFields.put(field.getName(), generateValue(field.getType()));
        }
        return valueOfFields;
    }
}