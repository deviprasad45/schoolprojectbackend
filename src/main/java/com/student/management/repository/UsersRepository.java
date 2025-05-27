package com.student.management.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.student.management.domain.Users;

/**
 * Spring Data SQL repository for the Users entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Users findByUsernameAndPassword(String username, String password);
	
}
