package com.example.generatorRandomValues.utils;

import com.example.generatorRandomValues.exception.BeanNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Component
public class MessageUtil {

    public static String getMessage(String messageKey) {
        return getMessage(messageKey, null);
    }

    public static String getMessage(String messageKey, List<Object> args) {
        MessageSource messageSource = ContextHelper.getMessageSourceBean();
        if (messageSource == null)
            throw new BeanNotFoundException("messages.properties file not found");
        Locale locale = Locale.ROOT;
        return messageSource.getMessage(messageKey, args.toArray(), locale);
    }
}
