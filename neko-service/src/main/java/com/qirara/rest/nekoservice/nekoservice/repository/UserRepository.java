package com.qirara.rest.nekoservice.nekoservice.repository;

import com.qirara.rest.nekoservice.nekoservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
