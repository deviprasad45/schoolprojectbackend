package com.student.management.service;

import java.util.List;
import java.util.Optional;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.service.dto.MenuDTO;

/**
 * Service Interface for managing {@link com.school.management.domain.Menu}.
 */
public interface MenuService {
    /**
     * Save a menu.
     *
     * @param menuDTO the entity to save.
     * @return the persisted entity.
     */
    MenuDTO save(MenuDTO menuDTO)throws StudentManagementBusinessException;

    /**
     * Get all the menus.
     *
     * @return the list of entities.
     */
    List<MenuDTO> findAll()throws StudentManagementBusinessException;

    /**
     * Get the "id" menu.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    MenuDTO findOne(Long id)throws StudentManagementBusinessException;

    /**
     * Delete the "id" menu.
     *
     * @param id the id of the entity.
     */
    void delete(Long id)throws StudentManagementBusinessException;
}
