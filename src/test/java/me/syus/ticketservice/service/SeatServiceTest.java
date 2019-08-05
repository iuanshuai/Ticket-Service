package me.syus.ticketservice.service;


import me.syus.ticketservice.domain.Seat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.Optional;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
@WebAppConfiguration
public class SeatServiceTest {
    @Autowired
    private SeatService seatService;

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void findAllTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("29.99"));
        expectedResult.setAvailability(true);
        seatService.save(expectedResult);
        logger.info("the seat id is: " + expectedResult.getId());
        Iterable<Seat> actualResult = seatService.findAll();
        assertNotNull(actualResult);

    }

    @Test
    public void findByIdTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("19.99"));
        expectedResult.setAvailability(true);
        seatService.save(expectedResult);
        Optional<Seat> actualResult = seatService.findById(expectedResult.getId());
        assertEquals(expectedResult.getId(), actualResult.get().getId());
    }
}
