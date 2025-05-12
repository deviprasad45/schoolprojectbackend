package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.domain.Syllabus;

/**
 * Spring Data JPA repository for the Syllabus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SyllabusRepository extends JpaRepository<Syllabus, Long> {
}
