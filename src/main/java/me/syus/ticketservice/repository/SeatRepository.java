package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;

import java.util.List;

public interface SeatRepository extends CRUDRepository<Seat, Long> {
    List<Seat> findAllAvailableSeats();

}
