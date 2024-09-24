package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import com.example.generatorRandomValues.utils.ContextHelper;
import org.springframework.stereotype.Service;

@Service
public class RandomValueGeneratorServiceImpl implements  RandomValueGeneratorService {

    @Override
    public Object generateValue(FieldType type) {
        assert type != null;

        TypeRandomizer randomizerBeanByType = ContextHelper.getRandomizerBeanByType(type);
        return randomizerBeanByType.getRandomValue();
    }
}
