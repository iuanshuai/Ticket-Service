package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Long> {

}
