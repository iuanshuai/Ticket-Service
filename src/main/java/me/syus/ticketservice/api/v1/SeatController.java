package me.syus.ticketservice.api.v1;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/v1/seats")
public class SeatController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SeatService seatService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Seat> getAllSeats() {
        return seatService.findAll();
    }



}
