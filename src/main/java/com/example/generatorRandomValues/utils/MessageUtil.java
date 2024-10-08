package com.example.generatorRandomValues.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String messageKey) {
        Locale locale = Locale.ROOT;
        return messageSource.getMessage(messageKey, null, locale);
    }
}
