package com.student.management.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.student.management.audit.AuditableDTO;

/**
 * A DTO for the {@link com.school.management.domain.Menu} entity.
 */
public class MenuDTO extends AuditableDTO<Long> implements Serializable {

    private Long id;

    private String name;

    private String remarkes;

    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarkes() {
        return remarkes;
    }

    public void setRemarkes(String remarkes) {
        this.remarkes = remarkes;
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
        if (!(o instanceof MenuDTO)) {
            return false;
        }

        MenuDTO menuDTO = (MenuDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, menuDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MenuDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", remarkes='" + getRemarkes() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
