package com.campuslab.platform.u20241f109.shared.domain.exceptions;

public class DomainValidationException extends IllegalArgumentException{
    private final String messageKey;

    public DomainValidationException (String messageKey, String explanation){
        super(explanation);
        this.messageKey = messageKey;
    }
    public String getMessageKey(){
        return messageKey;
    }
}
