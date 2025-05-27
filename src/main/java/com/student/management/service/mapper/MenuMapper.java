package com.student.management.service.mapper;

import org.mapstruct.*;

import com.student.management.domain.Menu;
import com.student.management.service.dto.MenuDTO;

/**
 * Mapper for the entity {@link Menu} and its DTO {@link MenuDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {}
