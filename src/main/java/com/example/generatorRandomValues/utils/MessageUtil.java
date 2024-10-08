package com.example.generatorRandomValues.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    public static String getMessage(String messageKey) {
        MessageSource messageSource = ContextHelper.getMessageSourceBean();
        Locale locale = Locale.ROOT;
        return messageSource.getMessage(messageKey, null, locale);
    }
}
