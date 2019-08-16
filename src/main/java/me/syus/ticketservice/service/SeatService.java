package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
        //UUID uuid = UUID.randomUUID();
        for (int i = 0; i < numSeats; i++) {
            Seat seat = seatList.get(i);
            seat.setAvailability(1);
            seat.setUser(userService.findByEmail(email));
            update(seat);
            holdSeatList.add(seat);
        }
        TimerTask releaseTask = new TimerTask() {
            @Override
            public void run() {
                releaseSeat(holdSeatList);
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 30000L;
        timer.schedule(releaseTask, delay);
        return holdSeatList;
    }

    public void releaseSeat(List<Seat> seats) {
        if (seats.get(0).getAvailability() != 2) {
            for (int i = 0; i < seats.size(); i++) {
                Seat seat = seats.get(i);
                seat.setUser(null);
                seat.setAvailability(0);
                update(seat);
            }
        }
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
