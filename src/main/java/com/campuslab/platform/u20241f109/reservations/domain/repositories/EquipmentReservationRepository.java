package com.campuslab.platform.u20241f109.reservations.domain.repositories;

import com.campuslab.platform.u20241f109.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u20241f109.reservations.domain.model.valueobjects.ReservationCode;

public interface EquipmentReservationRepository {
    boolean existsByReservationCode(ReservationCode code);
    EquipmentReservation save(EquipmentReservation reservation);
}
