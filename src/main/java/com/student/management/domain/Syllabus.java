package com.student.management.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.student.management.audit.Auditable;

/**
 * A Syllabus.
 */
@Entity
@Table(name = "syllabus")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Syllabus extends Auditable<Long> implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "class_id")
	private Long classId;

	@Column(name = "subject_id")
	private Long subjectId;

	@Column(name = "chapter_name")
	private String chapterName;

	@Column(name = "status")
	private Boolean status;

	public Long getId() {
		return this.id;
	}

	public Syllabus id(Long id) {
		this.setId(id);
		return this;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return this.classId;
	}

	public Syllabus classId(Long classId) {
		this.setClassId(classId);
		return this;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSubjectId() {
		return this.subjectId;
	}

	public Syllabus subjectId(Long subjectId) {
		this.setSubjectId(subjectId);
		return this;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public String getChapterName() {
		return this.chapterName;
	}

	public Syllabus chapterName(String chapterName) {
		this.setChapterName(chapterName);
		return this;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public Syllabus status(Boolean status) {
		this.setStatus(status);
		return this;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Syllabus)) {
			return false;
		}
		return getId() != null && getId().equals(((Syllabus) o).getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public String toString() {
		return "Syllabus{" + "id=" + getId() + ", classId=" + getClassId() + ", subjectId=" + getSubjectId()
				+ ", chapterName='" + getChapterName() + "'" + ", status='" + getStatus() + "'" + "}";
	}
}
