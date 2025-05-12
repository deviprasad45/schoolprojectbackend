package com.student.management.service;

import java.util.List;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.service.dto.SyllabusDTO;

/**
 * Service Interface for managing
 * {@link com.student.management.domain.Syllabus}.
 */
public interface SyllabusService {
	/**
	 * Save a syllabus.
	 *
	 * @param syllabusDTO the entity to save.
	 * @return the persisted entity.
	 */
	SyllabusDTO save(SyllabusDTO syllabusDTO) throws StudentManagementBusinessException;

	/**
	 * Updates a syllabus.
	 *
	 * @param syllabusDTO the entity to update.
	 * @return the persisted entity.
	 */
	SyllabusDTO update(SyllabusDTO syllabusDTO) throws StudentManagementBusinessException;

	/**
	 * Get all the syllabi.
	 *
	 * @return the list of entities.
	 */
	List<SyllabusDTO> findAll() throws StudentManagementBusinessException;

	/**
	 * Get the "id" syllabus.
	 *
	 * @param id the id of the entity.
	 * @return the entity.
	 */
	SyllabusDTO findOne(Long id) throws StudentManagementBusinessException;

	/**
	 * Delete the "id" syllabus.
	 *
	 * @param id the id of the entity.
	 */
	void delete(Long id) throws StudentManagementBusinessException;
}
