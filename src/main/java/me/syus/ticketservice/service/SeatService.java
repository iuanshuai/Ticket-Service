package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public Iterable<Seat> findAll() {

        Iterable<Seat> seats = seatRepository.findAll();
        return seats;

    }

    public Optional<Seat> findById(Long id) {
        Optional<Seat> seat = seatRepository.findById(id);
        return seat;
    }

}
