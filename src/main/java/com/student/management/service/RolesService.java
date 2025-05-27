package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.service.dto.RolesDTO;

/**
 * Service Interface for managing {@link com.school.management.domain.Roles}.
 */
public interface RolesService {
    /**
     * Save a roles.
     *
     * @param rolesDTO the entity to save.
     * @return the persisted entity.
     */
    RolesDTO save(RolesDTO rolesDTO)throws StudentManagementBusinessException;

   
    /**
     * Get all the roles.
     *
     * @return the list of entities.
     */
    List<RolesDTO> findAll()throws StudentManagementBusinessException;

    /**
     * Get the "id" roles.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    RolesDTO findOne(Long id)throws StudentManagementBusinessException;

    /**
     * Delete the "id" roles.
     *
     * @param id the id of the entity.
     */
    void delete(Long id)throws StudentManagementBusinessException;
}
