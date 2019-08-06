package me.syus.ticketservice.api.v1;

import me.syus.ticketservice.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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



//    @GetMapping(path="/all")
//    public @ResponseBody List<Seat> getAllSeats() {
//        return seatService.findAll();
//    }
}
