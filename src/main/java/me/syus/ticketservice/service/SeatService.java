package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> findAll() {

        List<Seat> seats = seatRepository.findAll();
        return seats;

    }

    public Seat findById(Long id) {
        Seat seat = seatRepository.findById(id);
        return seat;
    }

    public List<Seat> findAvailable() {
        List<Seat> seats = seatRepository.findAvailable();
        return seats;
    }

}
