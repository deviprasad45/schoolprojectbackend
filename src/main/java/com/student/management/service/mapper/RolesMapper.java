package com.student.management.service.mapper;

import org.mapstruct.Mapper;

import com.student.management.domain.Roles;
import com.student.management.service.dto.RolesDTO;

/**
 * Mapper for the entity {@link Roles} and its DTO {@link RolesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RolesMapper extends EntityMapper<RolesDTO, Roles> {}
