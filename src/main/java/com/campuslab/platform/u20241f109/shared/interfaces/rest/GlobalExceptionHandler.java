package com.campuslab.platform.u20241f109.shared.interfaces.rest;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.i18n.LocaleContextHolder;
import com.campuslab.platform.u20241f109.shared.domain.exceptions.DomainValidationException;
import com.campuslab.platform.u20241f109.shared.infrastructure.localization.MessageLocalizer;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final MessageLocalizer localizer;

    public GlobalExceptionHandler(MessageLocalizer localizer) {
        this.localizer = localizer;
    }

    @ExceptionHandler(DomainValidationException.class)
    public ResponseEntity<Map<String, String>> domain(DomainValidationException error) {
        return message(HttpStatus.BAD_REQUEST, error.getMessageKey());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> invalid(IllegalArgumentException error) {
        return message(HttpStatus.BAD_REQUEST, "error.invalid_request");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> unreadable(HttpMessageNotReadableException error) {
        return message(HttpStatus.BAD_REQUEST, "error.malformed_json");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> constraint(DataIntegrityViolationException error) {
        log.warn("Database integrity constraint rejected request", error);
        return message(HttpStatus.CONFLICT, "error.duplicate_code");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> unexpected(Exception error) {
        log.error("Unhandled API failure", error);
        return message(HttpStatus.INTERNAL_SERVER_ERROR, "error.unexpected");
    }

    private ResponseEntity<Map<String, String>> message(HttpStatus status, String key) {
        return ResponseEntity.status(status).body(Map.of("message",
                localizer.resolve(key, LocaleContextHolder.getLocale())));
    }
}