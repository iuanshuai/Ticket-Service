package me.syus.ticketservice.service;

import me.syus.ticketservice.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void findAllTest() {
        User expectedResult = new User();
        expectedResult.setEmail("test@gmail.com");
        expectedResult.setFirstName("Appleseed");
        expectedResult.setLastName("John");
        expectedResult.setUsername("johnappleseed");
        expectedResult.setPassword("123123");
        userService.save(expectedResult);
        Iterable<User> actualResult = userService.findAll();
        assertNotNull(actualResult);
    }
}
