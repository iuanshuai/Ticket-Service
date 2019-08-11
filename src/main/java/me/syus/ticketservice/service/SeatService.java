package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private UserService userService;

    public Seat save(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat update(Seat seat) {
        return seatRepository.update(seat);
    }

    public List<Seat> findAll() {

        List<Seat> seats = seatRepository.findAll();
        return seats;

    }

    public Seat findById(Long id) {
        Seat seat = seatRepository.findById(id);
        return seat;
    }

    public List<Seat> findAllAvailableSeat() {
        List<Seat> seats = seatRepository.findAllAvailableSeats();
        return seats;
    }

    public List<Seat> findAndHoldSeat(int numSeats, String email) {
        List<Seat> holdSeatList = new ArrayList<>();
        List<Seat> seatList = seatRepository.findAllAvailableSeats();
        if (seatList.size() < numSeats) return null; // TODO Exception Handle
        for (int i = 0; i < numSeats; i++) {
            Seat seat = seatList.get(i);
            seat.setAvailability(2);
            seat.setUser(userService.findByEmail(email));
            update(seat);
            holdSeatList.add(seat);
        }
        return holdSeatList;
    }

    public String reserveSeats(String email) {
        // TODO
        List<Seat> reservedSeatList = new ArrayList<>();
        return null;
    }

    public int checkAvailableById(Long id) {
        Seat seat = seatRepository.findById(id);
        return seat.getAvailability();
    }

    public List<Seat> findByUser(Long id) {
        return seatRepository.findByUser(id);
    }

}
