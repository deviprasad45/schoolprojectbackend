package com.student.management.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.management.domain.Roles;
import com.student.management.repository.RolesRepository;
import com.student.management.service.RolesService;
import com.student.management.service.dto.RolesDTO;
import com.student.management.service.mapper.RolesMapper;

/**
 * Service Implementation for managing {@link Roles}.
 */
@Service
@Transactional
public class RolesServiceImpl implements RolesService {

    private final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);

    private final RolesRepository rolesRepository;

    private final RolesMapper rolesMapper;

    public RolesServiceImpl(RolesRepository rolesRepository, RolesMapper rolesMapper) {
        this.rolesRepository = rolesRepository;
        this.rolesMapper = rolesMapper;
    }

    @Override
    public RolesDTO save(RolesDTO rolesDTO) {
        log.debug("Request to save Roles : {}", rolesDTO);
        Roles roles = rolesMapper.toEntity(rolesDTO);
        roles = rolesRepository.save(roles);
        return rolesMapper.toDto(roles);
    }

  

    @Override
    @Transactional(readOnly = true)
    public List<RolesDTO> findAll() {
        log.debug("Request to get all Roles");
        return rolesMapper.toDto( rolesRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public RolesDTO findOne(Long id) {
        log.debug("Request to get Roles : {}", id);
        return rolesRepository.findById(id).map(rolesMapper::toDto).get();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Roles : {}", id);
        rolesRepository.deleteById(id);
    }
}
