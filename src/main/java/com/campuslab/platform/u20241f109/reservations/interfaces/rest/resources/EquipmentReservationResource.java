package com.campuslab.platform.u20241f109.reservations.interfaces.rest.resources;
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Created reservation including its generated database identifier.")
public record EquipmentReservationResource(
        Long id,
        String reservationCode,
        String laboratoryId,
        String reservationPeriodStartDate,
        String reservationPeriodEndDate,
        Integer equipmentBatchQuantity,
        String equipmentBatchUnit,
        Integer accessLevel,
        String status,
        String reservationNotes) {
}
