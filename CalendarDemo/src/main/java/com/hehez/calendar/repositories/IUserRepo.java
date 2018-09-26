package com.hehez.calendar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hehez.calendar.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
