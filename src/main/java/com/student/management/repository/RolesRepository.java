package com.student.management.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.student.management.domain.Roles;

/**
 * Spring Data SQL repository for the Roles entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {}
