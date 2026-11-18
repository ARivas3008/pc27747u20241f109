package com.campuslab.platform.u20241f109.reservations.domain.model.valueobjects;

import com.campuslab.platform.u20241f109.shared.domain.exceptions.DomainValidationException;

public record ReservationCode (String code){
    public ReservationCode{
        if(code == null|| code.isBlank()){
            throw new DomainValidationException("calidation.code.required", "Reservation code must not be null or blank");
        }
    }
}
