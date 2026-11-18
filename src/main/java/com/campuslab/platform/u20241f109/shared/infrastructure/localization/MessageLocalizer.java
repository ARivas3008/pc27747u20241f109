package com.campuslab.platform.u20241f109.shared.infrastructure.localization;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageLocalizer {
    private final MessageSource messageSource;

    public MessageLocalizer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String resolve(String key, Locale requestedLocale) {
        Locale supportedLocale = requestedLocale != null
                && "es".equalsIgnoreCase(requestedLocale.getLanguage())
                ? Locale.forLanguageTag("es") : Locale.ENGLISH;
        return messageSource.getMessage(key, null, key, supportedLocale);
    }
}