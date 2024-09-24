package com.example.generatorRandomValues.utils;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import jakarta.annotation.Nonnull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ContextHelper implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextHelper.context = applicationContext;
    }

    public static TypeRandomizer getRandomizerBeanByType(FieldType type) {
        return getRandomizerBeanByType(type.getName());
    }

    public static TypeRandomizer getRandomizerBeanByType(@Nonnull String type){
        assertContextInjected();
        Map<String, TypeRandomizer> beansOfType = context.getBeansOfType(TypeRandomizer.class);
        return beansOfType.values().stream()
                .filter(x -> x.getType().getName().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(); //  todo custom exception
    }

    private static void assertContextInjected(){
        assert context != null;
    }
}
