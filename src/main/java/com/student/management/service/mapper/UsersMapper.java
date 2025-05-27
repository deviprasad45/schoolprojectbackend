package com.student.management.service.mapper;

import org.mapstruct.Mapper;

import com.student.management.domain.Users;
import com.student.management.service.dto.UsersDTO;

/**
 * Mapper for the entity {@link Users} and its DTO {@link UsersDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UsersMapper extends EntityMapper<UsersDTO, Users> {}
