package com.student.management.domain;

import java.io.Serializable;

import com.student.management.audit.Auditable;

import jakarta.persistence.*;

/**
 * A RoleMenuAcess.
 */
@Entity
@Table(name = "role_menu_acess")
public class RoleMenuAcess extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "menu_id")
    private Long menuId;

    @Column(name = "remarkes")
    private String remarkes;

    @Column(name = "status")
    private Boolean status;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public RoleMenuAcess id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public RoleMenuAcess roleId(Long roleId) {
        this.setRoleId(roleId);
        return this;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return this.menuId;
    }

    public RoleMenuAcess menuId(Long menuId) {
        this.setMenuId(menuId);
        return this;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getRemarkes() {
        return this.remarkes;
    }

    public RoleMenuAcess remarkes(String remarkes) {
        this.setRemarkes(remarkes);
        return this;
    }

    public void setRemarkes(String remarkes) {
        this.remarkes = remarkes;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public RoleMenuAcess status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RoleMenuAcess)) {
            return false;
        }
        return id != null && id.equals(((RoleMenuAcess) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RoleMenuAcess{" +
            "id=" + getId() +
            ", roleId=" + getRoleId() +
            ", menuId=" + getMenuId() +
            ", remarkes='" + getRemarkes() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
