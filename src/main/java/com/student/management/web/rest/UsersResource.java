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
import com.student.management.repository.UsersRepository;
import com.student.management.service.UsersService;
import com.student.management.service.dto.SyllabusDTO;
import com.student.management.service.dto.UsersDTO;
import com.student.management.util.ApplicationConstants;
import com.student.management.util.ResponseObject;
import com.student.management.util.StudentManagementResponseUtil;

/**
 * REST controller for managing {@link com.school.management.domain.Users}.
 */
@RestController
@RequestMapping("/users")
public class UsersResource {

    private final Logger log = LoggerFactory.getLogger(UsersResource.class);

    private static final String ENTITY_NAME = "schoolUsers";

    private final UsersService usersService;

    private final UsersRepository usersRepository;

    public UsersResource(UsersService usersService, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.usersRepository = usersRepository;
    }

    /**
     * {@code POST  /users} : Create a new users.
     *
     * @param usersDTO the usersDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new usersDTO, or with status {@code 400 (Bad Request)} if the users has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/add")
    public ResponseObject createUsers(@RequestBody UsersDTO usersDTO) throws URISyntaxException {
        log.debug("REST request to save Users : {}", usersDTO);
    	List<UsersDTO> data = null;
    	UsersDTO result = null;
		try {
			if (usersDTO.getId() != null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = usersService.save(usersDTO);
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
     * {@code PUT  /users/:id} : Updates an existing users.
     *
     * @param id the id of the usersDTO to save.
     * @param usersDTO the usersDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated usersDTO,
     * or with status {@code 400 (Bad Request)} if the usersDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the usersDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/update/{id}")
    public ResponseObject updateUsers(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody UsersDTO usersDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Users : {}, {}", id, usersDTO);
        List<UsersDTO> data = null;
        UsersDTO result = null;
		try {
			if (usersDTO.getId() == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = usersService.save(usersDTO);
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
     * {@code GET  /users} : get all the users.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of users in body.
     */
    @GetMapping("/get_all")
    public ResponseObject getAllUsers() {
        log.debug("REST request to get all Users");
        List<UsersDTO> result = null;
		try {
			result = usersService.findAll();
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
     * {@code GET  /users/:id} : get the "id" users.
     *
     * @param id the id of the usersDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the usersDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/get/{id}")
    public ResponseObject getUsers(@PathVariable Long id) {
        log.debug("REST request to get Users : {}", id);
        List<UsersDTO> data = null;
		try {
			UsersDTO result = usersService.findOne(id);
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
     * {@code DELETE  /users/:id} : delete the "id" users.
     *
     * @param id the id of the usersDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseObject deleteUsers(@PathVariable Long id) {
        log.debug("REST request to delete Users : {}", id);
    	try {
			if (id == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			usersService.delete(id);
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
    
    @PostMapping("/signin")
    public ResponseObject signinUsers(@RequestBody UsersDTO usersDTO) throws URISyntaxException {
        log.debug("REST request to save Users : {}", usersDTO);
    	List<UsersDTO> data = null;
    	UsersDTO result = null;
		try {
			if (usersDTO.getId() != null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = usersService.save(usersDTO);
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
}
