package com.student.management.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.student.management.audit.AuditableDTO;

/**
 * A DTO for the {@link com.school.management.domain.RoleMenuAcess} entity.
 */
public class RoleMenuAcessDTO extends AuditableDTO<Long> implements Serializable {

    private Long id;

    private Long roleId;

    private Long menuId;

    private String remarkes;

    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
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
        if (!(o instanceof RoleMenuAcessDTO)) {
            return false;
        }

        RoleMenuAcessDTO roleMenuAcessDTO = (RoleMenuAcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, roleMenuAcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RoleMenuAcessDTO{" +
            "id=" + getId() +
            ", roleId=" + getRoleId() +
            ", menuId=" + getMenuId() +
            ", remarkes='" + getRemarkes() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
