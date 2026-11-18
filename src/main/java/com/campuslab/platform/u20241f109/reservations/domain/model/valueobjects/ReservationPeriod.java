package com.campuslab.platform.u20241f109.reservations.domain.model.valueobjects;
import java.time.LocalDate;
import com.campuslab.platform.u20241f109.shared.domain.exceptions.DomainValidationException;

public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {
    public ReservationPeriod {
        if (startDate == null) {
            throw new DomainValidationException("validation.period.start.required",
                    "Reservation start date must not be null");
        }
        if (endDate == null) {
            throw new DomainValidationException("validation.period.end.required",
                    "Reservation end date must not be null");
        }
        if (!endDate.isAfter(startDate)) {
            throw new DomainValidationException("validation.period.order",
                    "Reservation end date must be after start date");
        }

    }

    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new DomainValidationException("validation.period.check.required",
                    "Check date must not be null");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
