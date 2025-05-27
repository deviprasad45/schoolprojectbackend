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
import com.student.management.repository.RolesRepository;
import com.student.management.service.RolesService;
import com.student.management.service.dto.RolesDTO;
import com.student.management.service.dto.SyllabusDTO;
import com.student.management.util.ApplicationConstants;
import com.student.management.util.ResponseObject;
import com.student.management.util.StudentManagementResponseUtil;

/**
 * REST controller for managing {@link com.school.management.domain.Roles}.
 */
@RestController
@RequestMapping("/roles")
public class RolesResource {

    private final Logger log = LoggerFactory.getLogger(RolesResource.class);

    private static final String ENTITY_NAME = "schoolRoles";


    private final RolesService rolesService;

    private final RolesRepository rolesRepository;

    public RolesResource(RolesService rolesService, RolesRepository rolesRepository) {
        this.rolesService = rolesService;
        this.rolesRepository = rolesRepository;
    }

    /**
     * {@code POST  /roles} : Create a new roles.
     *
     * @param rolesDTO the rolesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new rolesDTO, or with status {@code 400 (Bad Request)} if the roles has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/add")
    public ResponseObject createRoles(@RequestBody RolesDTO rolesDTO) throws URISyntaxException {
        log.debug("REST request to save Roles : {}", rolesDTO);
    	List<RolesDTO> data = null;
    	RolesDTO result = null;
		try {
			if (rolesDTO.getId() != null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = rolesService.save(rolesDTO);
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
     * {@code PUT  /roles/:id} : Updates an existing roles.
     *
     * @param id the id of the rolesDTO to save.
     * @param rolesDTO the rolesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated rolesDTO,
     * or with status {@code 400 (Bad Request)} if the rolesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the rolesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/update/{id}")
    public ResponseObject updateRoles(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody RolesDTO rolesDTO
    ) throws URISyntaxException {
    	List<RolesDTO> data = null;
    	RolesDTO result = null;
		try {
			if (rolesDTO.getId() == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = rolesService.save(rolesDTO);
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
     * {@code GET  /roles} : get all the roles.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of roles in body.
     */
    @GetMapping("/get_all")
    public ResponseObject getAllRoles() {
        log.debug("REST request to get all Roles");
        List<RolesDTO> result = null;
		try {
			result = rolesService.findAll();
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
     * {@code GET  /roles/:id} : get the "id" roles.
     *
     * @param id the id of the rolesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the rolesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/get/{id}")
    public ResponseObject getRoles(@PathVariable Long id) {
        log.debug("REST request to get Roles : {}", id);
        List<RolesDTO> data = null;
		try {
			RolesDTO result = rolesService.findOne(id);
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
     * {@code DELETE  /roles/:id} : delete the "id" roles.
     *
     * @param id the id of the rolesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseObject deleteRoles(@PathVariable Long id) {
        log.debug("REST request to delete Roles : {}", id);
        try {
			if (id == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			rolesService.delete(id);
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
