package me.syus.ticketservice.api.v1;

import me.syus.ticketservice.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/api/v1/seats")
@ResponseBody
public class SeatController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SeatService seatService;

    // /api/v1/seats/all GET
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List findAll() {
        logger.info("list all seats");
        return seatService.findAll();
    }

    // /api/v1/seats/available GET
    @RequestMapping(value = "/available", method = RequestMethod.GET)
    public List findAllAvailableSeats() {
        logger.info("list available seats");
        return seatService.findAllAvailableSeat();
    }

    // /api/v1/seats/availability?id=xx GET
    @RequestMapping(value = "/availability", method = RequestMethod.GET)
    public int checkAvailableById(@RequestParam("id") Long id) {
        logger.info("check available by id: " + id);
        return seatService.checkAvailableById(id);
    }

    // /api/v1/seats/hold
    @RequestMapping(value = "/hold", method = RequestMethod.GET)
    public List findAndHoldSeat(@RequestParam("num") int num, @RequestParam("email") String email) {
        return seatService.findAndHoldSeat(num, email);
    }



}
