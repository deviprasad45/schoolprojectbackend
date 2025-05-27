package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.service.dto.UsersDTO;

/**
 * Service Interface for managing {@link com.school.management.domain.Users}.
 */
public interface UsersService {
    /**
     * Save a users.
     *
     * @param usersDTO the entity to save.
     * @return the persisted entity.
     */
    UsersDTO save(UsersDTO usersDTO)throws StudentManagementBusinessException;


    /**
     * Get all the users.
     *
     * @return the list of entities.
     */
    List<UsersDTO> findAll()throws StudentManagementBusinessException;

    /**
     * Get the "id" users.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    UsersDTO findOne(Long id)throws StudentManagementBusinessException;

    /**
     * Delete the "id" users.
     *
     * @param id the id of the entity.
     */
    void delete(Long id)throws StudentManagementBusinessException;
    
    UsersDTO signinUsers(UsersDTO usersDTO)throws StudentManagementBusinessException;
}
