package com.student.management.service.mapper;

import org.mapstruct.Mapper;

import com.student.management.domain.Syllabus;
import com.student.management.service.dto.SyllabusDTO;

/**
 * Mapper for the entity {@link Syllabus} and its DTO {@link SyllabusDTO}.
 */
//@Mapper(componentModel = "spring", uses = {})
@Mapper(componentModel = "spring")
public interface SyllabusMapper extends EntityMapper<SyllabusDTO, Syllabus> {
}
