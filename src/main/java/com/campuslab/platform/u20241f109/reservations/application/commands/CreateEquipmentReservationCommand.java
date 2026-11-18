package com.campuslab.platform.u20241f109.reservations.application.commands;

public record CreateEquipmentReservationCommand (
    String reservationCode,
    String laboratoryId,
    String reservationPeriodStartDate,
    String reservationPeriodEndDate,
    Integer equipmentBatchQuantity,
    String equipmentBatchUnit,
    Integer accessLevel,
    String status,
    boolean statusProvided,
    String reservationNotes){
}
