package com.example.generatorRandomValues.service;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.service.typeFormatter.TypeFormatter;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import com.example.generatorRandomValues.utils.ContextHelper;
import jakarta.annotation.Nullable;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RandomValueGeneratorServiceImpl implements  RandomValueGeneratorService {

    /**
     *Generate value and format it by format
     * @param type - type for generate value
     * @param format - format from request. if it not present - use {@link TypeFormatter#getDefaultFormat()} for given type
     * @return formatted value if format present.
     */
    @Override
    public Object getFormattedValue(FieldType type, @Nullable String format){
        Object value = generateValue(type);

        TypeFormatter formatter = ContextHelper.getFormatterBeanByType(type);

        if (formatter != null){
            return formatter.format(value, format);
        }
        return value;
    }

    @Override
    public Object generateValue(FieldType type) {
        assert type != null;
        log.debug("Starting generate value for type = {}", type.getName());

        TypeRandomizer randomizerBeanByType = ContextHelper.getRandomizerBeanByType(type);
        Object randomValue = randomizerBeanByType.getRandomValue();

        log.debug("End generating value = {} for type = {}", randomValue, type.getName());
        return randomValue;
    }
}