package com.mahindrashowrooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mahindrashowrooms.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
