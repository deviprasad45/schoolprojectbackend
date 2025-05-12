package com.student.management.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.management.domain.Syllabus;
import com.student.management.repository.SyllabusRepository;
import com.student.management.service.SyllabusService;
import com.student.management.service.dto.SyllabusDTO;
import com.student.management.service.mapper.SyllabusMapper;

/**
 * Service Implementation for managing
 * {@link com.student.management.domain.Syllabus}.
 */
@Service
@Transactional
public class SyllabusServiceImpl implements SyllabusService {

	private static final Logger LOG = LoggerFactory.getLogger(SyllabusServiceImpl.class);

	private final SyllabusRepository syllabusRepository;

	private final SyllabusMapper syllabusMapper;

	public SyllabusServiceImpl(SyllabusRepository syllabusRepository, SyllabusMapper syllabusMapper) {
		this.syllabusRepository = syllabusRepository;
		this.syllabusMapper = syllabusMapper;
	}

	@Override
	public SyllabusDTO save(SyllabusDTO syllabusDTO) {
		LOG.debug("Request to save Syllabus : {}", syllabusDTO);
		Syllabus syllabus = syllabusMapper.toEntity(syllabusDTO);
		syllabus = syllabusRepository.save(syllabus);
		return syllabusMapper.toDto(syllabus);
	}

	@Override
	public SyllabusDTO update(SyllabusDTO syllabusDTO) {
		LOG.debug("Request to update Syllabus : {}", syllabusDTO);
		Syllabus syllabus = syllabusMapper.toEntity(syllabusDTO);
		syllabus = syllabusRepository.save(syllabus);
		return syllabusMapper.toDto(syllabus);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SyllabusDTO> findAll() {
		LOG.debug("Request to get all Syllabi");
		return syllabusRepository.findAll().stream().map(syllabusMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	@Transactional(readOnly = true)
	public SyllabusDTO findOne(Long id) {
		SyllabusDTO syllabusDTO = null;
		Optional<Syllabus> syllabus = syllabusRepository.findById(id);
		if (syllabus.isPresent())
			syllabusDTO = syllabusMapper.toDto(syllabus.get());
		return syllabusDTO;
	}

	@Override
	public void delete(Long id) {
		LOG.debug("Request to delete Syllabus : {}", id);
		syllabusRepository.deleteById(id);
	}
}
