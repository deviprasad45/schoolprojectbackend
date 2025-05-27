package com.student.management.service.mapper;

import org.mapstruct.Mapper;

import com.student.management.domain.RoleMenuAcess;
import com.student.management.service.dto.RoleMenuAcessDTO;

/**
 * Mapper for the entity {@link RoleMenuAcess} and its DTO {@link RoleMenuAcessDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RoleMenuAcessMapper extends EntityMapper<RoleMenuAcessDTO, RoleMenuAcess> {}
