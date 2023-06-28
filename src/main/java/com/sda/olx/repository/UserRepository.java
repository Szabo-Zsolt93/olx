package com.sda.olx.repository;

import com.sda.olx.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);

}
