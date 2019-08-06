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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
@WebAppConfiguration
public class SeatServiceTest {
    @Autowired
    private SeatService seatService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional
    public void findAllTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("29.99"));
        expectedResult.setAvailability(true);
        seatService.save(expectedResult);
        logger.debug("the seat id is: " + expectedResult.getId());
        List<Seat> actualResult = seatService.findAll();
        assertNotNull(actualResult);

    }

    @Test
    @Transactional
    public void findByIdTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("39.99"));
        expectedResult.setAvailability(true);
        seatService.save(expectedResult);
        Seat actualResult = seatService.findById(expectedResult.getId());
        assertEquals(expectedResult.getId(), actualResult.getId());
    }


    @Test
    @Transactional
    public void findAvailableSeatsTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("29.99"));
        expectedResult.setAvailability(true);
        seatService.save(expectedResult);
        logger.debug("the seat id is: " + expectedResult.getId());
        List<Seat> actualResult = seatService.findAllAvailableSeat();
        System.out.println(actualResult);
        assertNotNull(actualResult);
    }
}
