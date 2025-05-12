package com.student.management.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.student.management.audit.AuditableDTO;

/**
 * A DTO for the {@link com.student.management.domain.Syllabus} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SyllabusDTO extends AuditableDTO<Long> implements Serializable {

	private Long id;

	private Long classId;

	private Long subjectId;

	private String chapterName;

	private Boolean status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SyllabusDTO)) {
			return false;
		}

		SyllabusDTO syllabusDTO = (SyllabusDTO) o;
		if (this.id == null) {
			return false;
		}
		return Objects.equals(this.id, syllabusDTO.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

	@Override
	public String toString() {
		return "SyllabusDTO{" + "id=" + getId() + ", classId=" + getClassId() + ", subjectId=" + getSubjectId()
				+ ", chapterName='" + getChapterName() + "'" + ", status='" + getStatus() + "'" + "}";
	}
}
