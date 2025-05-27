package com.student.management.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.student.management.domain.Menu;

/**
 * Spring Data SQL repository for the Menu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {}
