package com.campuslab.platform.u20241f109.reservations.domain.model.valueobjects;

import com.campuslab.platform.u20241f109.shared.domain.exceptions.DomainValidationException;
import java.util.UUID;

public record LaboratoryId (UUID value){
    public LaboratoryId{
        if(value==null){
            throw new DomainValidationException("validation.laboratory.required", "Laboratory ID must not be null");
        }
    }
}
