package com.campuslab.platform.u20241f109.reservations.domain.model.valueobjects;

import com.campuslab.platform.u20241f109.shared.domain.exceptions.DomainValidationException;


public record EquipmentBatch (Integer quantity, String unit){
    public EquipmentBatch{
        if(quantity == null || quantity <= 0){
            throw new DomainValidationException("validation.batch.quantity", "Equipment quantity must be greater than zero");
        }
            if (unit== null|| unit.isBlank()){
                throw new DomainValidationException("validation.batch.unit", "Equipment unit must not be null or blank");
            }
            unit = unit.trim();
    }

    public EquipmentBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new DomainValidationException("validation.batch.increment",
                    "Additional quantity must be greater than zero");
        }
        try {
            return new EquipmentBatch(Math.addExact(quantity, additionalQuantity), unit);
        } catch (ArithmeticException ex) {
            throw new DomainValidationException("validation.batch.overflow",
                    "Equipment quantity exceeds Integer.MAX_VALUE");
        }
    }
}
