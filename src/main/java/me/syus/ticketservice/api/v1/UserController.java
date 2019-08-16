package me.syus.ticketservice.api.v1;

import me.syus.ticketservice.domain.User;
import me.syus.ticketservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v1/users")
@ResponseBody
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> findAll() {
        logger.info("list all users");
        return userService.findAll();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) {
        userService.save(user);
        return user;
    }

}
