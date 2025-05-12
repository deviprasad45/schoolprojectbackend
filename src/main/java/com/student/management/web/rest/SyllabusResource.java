package com.student.management.web.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.exception.StudentManagementBusinessException;
import com.student.management.repository.SyllabusRepository;
import com.student.management.service.SyllabusService;
import com.student.management.service.dto.SyllabusDTO;
import com.student.management.util.ApplicationConstants;
import com.student.management.util.ResponseObject;
import com.student.management.util.StudentManagementResponseUtil;

/**
 * REST controller for managing {@link com.student.management.domain.Syllabus}.
 */
@RestController
@RequestMapping("/syllabus")
public class SyllabusResource {

	private final SyllabusService syllabusService;

	private final SyllabusRepository syllabusRepository;

	public SyllabusResource(SyllabusService syllabusService, SyllabusRepository syllabusRepository) {
		this.syllabusService = syllabusService;
		this.syllabusRepository = syllabusRepository;
	}

	@PostMapping("/add")
	public ResponseObject createSyllabus(@RequestHeader(required = true) Long userid,
			@RequestHeader(required = true) String authToken, @RequestBody SyllabusDTO syllabusDTO) {
		List<SyllabusDTO> data = null;
		SyllabusDTO result = null;
		try {
			if (syllabusDTO.getId() != null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = syllabusService.save(syllabusDTO);
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

	@PutMapping("/update")
	public ResponseObject updateSyllabus(@RequestHeader(required = true) Long userid,
			@RequestHeader(required = true) String authToken, @RequestBody SyllabusDTO syllabusDTO) {

		List<SyllabusDTO> data = null;
		SyllabusDTO result = null;
		try {
			if (syllabusDTO.getId() == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			result = syllabusService.save(syllabusDTO);
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

	@GetMapping("/get_all")
	public ResponseObject getAllSyllabi(@RequestHeader(required = true) Long userid,
			@RequestHeader(required = true) String authToken) {
		List<SyllabusDTO> result = null;
		try {
			result = syllabusService.findAll();
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

	@GetMapping("/get")
	public ResponseObject getSyllabus(@RequestHeader(required = true) Long userid,
			@RequestHeader(required = true) String authToken, @RequestHeader(required = true) Long id) {

		List<SyllabusDTO> data = null;
		try {
			SyllabusDTO result = syllabusService.findOne(id);
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

	@DeleteMapping("/remove")
	public ResponseObject deleteSyllabus(@RequestHeader(required = true) Long userid,
			@RequestHeader(required = true) String authToken, @RequestHeader(required = true) Long id) {
		try {
			if (id == null) {
				return StudentManagementResponseUtil.buildResponse(ApplicationConstants.RES_STATUS_ERROR,
						ApplicationConstants.BAD_REQUEST, null);
			}
			syllabusService.delete(id);
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
