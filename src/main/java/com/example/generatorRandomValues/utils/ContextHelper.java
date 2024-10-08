package com.example.generatorRandomValues.utils;

import com.example.generatorRandomValues.dto.FieldType;
import com.example.generatorRandomValues.service.TypeFilterable;
import com.example.generatorRandomValues.service.typeFormatter.TypeFormatter;
import com.example.generatorRandomValues.service.typeRandomizer.TypeRandomizer;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ContextHelper implements ApplicationContextAware {
    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContextHelper.context = applicationContext;
    }

    public static TypeFormatter getFormatterBeanByType(FieldType type) {
        return getFormatterBeanByTypeName(type.getName());
    }

    public static TypeFormatter getFormatterBeanByTypeName(String type) {
        return getBeanByClassForType(TypeFormatter.class, type);
    }

    public static TypeRandomizer getRandomizerBeanByType(FieldType type) {
        return getRandomizerBeanByTypeName(type.getName());
    }

    public static TypeRandomizer getRandomizerBeanByTypeName(String type) {
        return getBeanByClassForType(TypeRandomizer.class, type);
    }

    @Nullable
    static <T extends TypeFilterable> T getBeanByClassForType(Class<T> clazz, @Nonnull String type) {
        assertContextInjected();
        Map<String, T> beansOfType = context.getBeansOfType(clazz);
        return beansOfType.values().stream()
                .filter(x -> x.getType().getName().equalsIgnoreCase(type))
                .findFirst()
                .orElse(null);
    }

    public static MessageSource getMessageSourceBean() {
        Optional<MessageSource> optionalMessageSource = Optional.of((MessageSource) context.getBean("messageSource"));
        return optionalMessageSource.orElse(null);
    }

    private static void assertContextInjected() {
        assert context != null;
    }
}
