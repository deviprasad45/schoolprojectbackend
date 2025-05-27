package com.student.management.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.tomcat.util.http.HeaderUtil;
import org.apache.tomcat.util.http.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.repository.MenuRepository;
import com.student.management.service.MenuService;
import com.student.management.service.dto.MenuDTO;
import com.student.management.service.dto.RoleMenuAcessDTO;
import com.student.management.util.ApplicationConstants;
import com.student.management.util.ResponseObject;
import com.student.management.util.StudentManagementResponseUtil;

/**
 * REST controller for managing {@link com.school.management.domain.Menu}.
 */
@RestController
@RequestMapping("/api")
public class MenuResource {

    private final Logger log = LoggerFactory.getLogger(MenuResource.class);

    private static final String ENTITY_NAME = "schoolMenu";


    private final MenuService menuService;

    private final MenuRepository menuRepository;

    public MenuResource(MenuService menuService, MenuRepository menuRepository) {
        this.menuService = menuService;
        this.menuRepository = menuRepository;
    }

    /**
     * {@code POST  /menus} : Create a new menu.
     *
     * @param menuDTO the menuDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new menuDTO, or with status {@code 400 (Bad Request)} if the menu has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/add")
    public ResponseObject createMenu(@RequestBody MenuDTO menuDTO) throws URISyntaxException {
        log.debug("REST request to save Menu : {}", menuDTO);
        List<MenuDTO> data = null;
        MenuDTO result = null;
		try {
			if (menuDTO.getId() != null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = menuService.save(menuDTO);
			data = new ArrayList<>();
			data.add(result);
		} catch (StudentManagementBusinessException e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SYLLABUS + ApplicationConstants.CREATE_RECORD_FAILED + "," + e.getMessage(),
					data);
		} catch (Exception e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SERVER_ERROR, null);
		}
		return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_SUCCESS,
				ApplicationConstants.SYLLABUS + ApplicationConstants.CREATE_RECORD_SUCESS, data);
    }

    /**
     * {@code PUT  /menus/:id} : Updates an existing menu.
     *
     * @param id the id of the menuDTO to save.
     * @param menuDTO the menuDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated menuDTO,
     * or with status {@code 400 (Bad Request)} if the menuDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the menuDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/menus/{id}")
    public ResponseObject updateMenu(@PathVariable(value = "id", required = false) final Long id, @RequestBody MenuDTO menuDTO)
        throws URISyntaxException {
        log.debug("REST request to update Menu : {}, {}", id, menuDTO);
        List<MenuDTO> data = null;
        MenuDTO result = null;
		try {
			if (menuDTO.getId() == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = menuService.save(menuDTO);
			data = new ArrayList<>();
			data.add(result);
		} catch (StudentManagementBusinessException e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SYLLABUS + ApplicationConstants.UPDATE_RECORD_FAILED + "," + e.getMessage(),
					data);
		} catch (Exception e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SERVER_ERROR, null);
		}
		return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_SUCCESS,
				ApplicationConstants.SYLLABUS + ApplicationConstants.UPDATE_RECORD_SUCESS, data);
    }

  

    /**
     * {@code GET  /menus} : get all the menus.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of menus in body.
     */
    @GetMapping("/get_all")
    public ResponseObject getAllMenus() {
        log.debug("REST request to get all Menus");
        List<MenuDTO> result = null;
		try {
			result = menuService.findAll();
		} catch (StudentManagementBusinessException e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SYLLABUS + ApplicationConstants.FETCH_RECORD_FAILED, result);
		} catch (Exception e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SERVER_ERROR, null);
		}
		return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_SUCCESS,
				ApplicationConstants.SYLLABUS + ApplicationConstants.FETCH_RECORD_SUCESS, result);
    }

    /**
     * {@code GET  /menus/:id} : get the "id" menu.
     *
     * @param id the id of the menuDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the menuDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/menus/{id}")
    public ResponseObject getMenu(@PathVariable Long id) {
        log.debug("REST request to get Menu : {}", id);
        List<MenuDTO> data = null;
		try {
			MenuDTO result = menuService.findOne(id);
			data = new ArrayList<>();
			data.add(result);
		} catch (StudentManagementBusinessException e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SYLLABUS + ApplicationConstants.FETCH_RECORD_FAILED, data);
		} catch (Exception e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SERVER_ERROR, null);
		}
		return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_SUCCESS,
				ApplicationConstants.SYLLABUS + ApplicationConstants.FETCH_RECORD_SUCESS, data);
    }

    /**
     * {@code DELETE  /menus/:id} : delete the "id" menu.
     *
     * @param id the id of the menuDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/menus/{id}")
    public ResponseObject deleteMenu(@PathVariable Long id) {
        log.debug("REST request to delete Menu : {}", id);
        try {
			if (id == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			menuService.delete(id);
		} catch (StudentManagementBusinessException e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SYLLABUS + ApplicationConstants.DELETE_RECORD_FAILED + "," + e.getMessage(),
					null);
		} catch (Exception e) {
			return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
					ApplicationConstants.SERVER_ERROR, null);
		}
		return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_SUCCESS,
				ApplicationConstants.SYLLABUS + ApplicationConstants.DELETE_RECORD_SUCESS, null);
    }
}
