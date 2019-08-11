package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.Seat;
import me.syus.ticketservice.domain.User;
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
import java.util.ArrayList;
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

    @Autowired
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    @Transactional
    public void findAllTest() {
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("29.99"));
        expectedResult.setAvailability(2);
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
        expectedResult.setAvailability(0);
        seatService.save(expectedResult);
        Seat actualResult = seatService.findById(expectedResult.getId());
        assertEquals(expectedResult.getId(), actualResult.getId());
    }


    @Test
    @Transactional
    public void findAvailableSeatsTest() {
        // TODO Revise
        Seat expectedResult = new Seat();
        expectedResult.setPrice(new BigDecimal("29.99"));
        expectedResult.setAvailability(0);
        seatService.save(expectedResult);
        logger.debug("the seat id is: " + expectedResult.getId());
        List<Seat> actualResult = seatService.findAllAvailableSeat();
        System.out.println(actualResult);
        assertNotNull(actualResult);
    }

    @Test
    @Transactional
    public void findAndHoldSeatTest() {
        Seat testSeat = new Seat();
        testSeat.setPrice(new BigDecimal("29.99"));
        testSeat.setAvailability(0);
        seatService.save(testSeat);
//        List<Seat> availableSeatBefore = seatService.findAllAvailableSeat();
        int seatNumBefore = seatService.findAllAvailableSeat().size();
        User testUser = new User();
        testUser.setEmail("test11@gmail.com");
        testUser.setFirstName("Appleseed");
        testUser.setLastName("John");
        testUser.setUsername("testjohnappleseed");
        testUser.setPassword("123123");
        userService.save(testUser);
        seatService.findAndHoldSeat(1, "test11@gmail.com");
        int seatNumAfter = seatService.findAllAvailableSeat().size();
        assertEquals(seatNumAfter, seatNumBefore - 1);

    }

    @Test
    @Transactional
    public void findByUserTest() {
        User testUser = new User();
        testUser.setEmail("test11@gmail.com");
        testUser.setFirstName("Appleseed");
        testUser.setLastName("John");
        testUser.setUsername("testjohnappleseed");
        testUser.setPassword("123123");
        userService.save(testUser);
        Seat testSeat = new Seat();
        testSeat.setPrice(new BigDecimal("29.99"));
        testSeat.setAvailability(2);
        testSeat.setUser(testUser);
        seatService.save(testSeat);
        List<Seat> expectResult = new ArrayList<>();
        expectResult.add(testSeat);
        List<Seat> actualResult = seatService.findByUser(testUser.getId());
        assertEquals(expectResult, actualResult);

    }
}
