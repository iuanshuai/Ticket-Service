package me.syus.ticketservice.repository;

import me.syus.ticketservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
