package com.insea.conference.repository;

import com.insea.conference.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    <Optional>User findByEmail(String email);
}