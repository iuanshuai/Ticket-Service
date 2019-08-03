package me.syus.ticketservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("unit")
public class TicketServiceApplicationTests {


	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		logger.info("test logging");

	}

}
