package com.student.management.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.management.domain.RoleMenuAcess;
import com.student.management.repository.RoleMenuAcessRepository;
import com.student.management.service.RoleMenuAcessService;
import com.student.management.service.dto.RoleMenuAcessDTO;
import com.student.management.service.mapper.RoleMenuAcessMapper;

/**
 * Service Implementation for managing {@link RoleMenuAcess}.
 */
@Service
@Transactional
public class RoleMenuAcessServiceImpl implements RoleMenuAcessService {

    private final Logger log = LoggerFactory.getLogger(RoleMenuAcessServiceImpl.class);

    private final RoleMenuAcessRepository roleMenuAcessRepository;

    private final RoleMenuAcessMapper roleMenuAcessMapper;

    public RoleMenuAcessServiceImpl(RoleMenuAcessRepository roleMenuAcessRepository, RoleMenuAcessMapper roleMenuAcessMapper) {
        this.roleMenuAcessRepository = roleMenuAcessRepository;
        this.roleMenuAcessMapper = roleMenuAcessMapper;
    }

    @Override
    public RoleMenuAcessDTO save(RoleMenuAcessDTO roleMenuAcessDTO) {
        log.debug("Request to save RoleMenuAcess : {}", roleMenuAcessDTO);
        RoleMenuAcess roleMenuAcess = roleMenuAcessMapper.toEntity(roleMenuAcessDTO);
        roleMenuAcess = roleMenuAcessRepository.save(roleMenuAcess);
        return roleMenuAcessMapper.toDto(roleMenuAcess);
    }

  

    @Override
    @Transactional(readOnly = true)
    public List<RoleMenuAcessDTO> findAll() {
        log.debug("Request to get all RoleMenuAcesses");
        return roleMenuAcessRepository.findAll().stream().map(roleMenuAcessMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    @Transactional(readOnly = true)
    public RoleMenuAcessDTO findOne(Long id) {
        log.debug("Request to get RoleMenuAcess : {}", id);
        return roleMenuAcessRepository.findById(id).map(roleMenuAcessMapper::toDto).get();
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete RoleMenuAcess : {}", id);
        roleMenuAcessRepository.deleteById(id);
    }
}
