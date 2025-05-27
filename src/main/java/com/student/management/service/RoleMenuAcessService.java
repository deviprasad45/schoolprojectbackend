package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.service.dto.RoleMenuAcessDTO;


/**
 * Service Interface for managing {@link com.school.management.domain.RoleMenuAcess}.
 */
public interface RoleMenuAcessService {
    /**
     * Save a roleMenuAcess.
     *
     * @param roleMenuAcessDTO the entity to save.
     * @return the persisted entity.
     */
    RoleMenuAcessDTO save(RoleMenuAcessDTO roleMenuAcessDTO)throws StudentManagementBusinessException;

    /**
     * Get all the roleMenuAcesses.
     *
     * @return the list of entities.
     */
    List<RoleMenuAcessDTO> findAll()throws StudentManagementBusinessException;

    /**
     * Get the "id" roleMenuAcess.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    RoleMenuAcessDTO findOne(Long id)throws StudentManagementBusinessException;

    /**
     * Delete the "id" roleMenuAcess.
     *
     * @param id the id of the entity.
     */
    void delete(Long id)throws StudentManagementBusinessException;
}
