package com.student.management.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.student.management.domain.RoleMenuAcess;

/**
 * Spring Data SQL repository for the RoleMenuAcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RoleMenuAcessRepository extends JpaRepository<RoleMenuAcess, Long> {}
