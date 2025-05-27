package com.student.management.domain;

import java.io.Serializable;

import com.student.management.audit.Auditable;

import jakarta.persistence.*;

/**
 * A Roles.
 */
@Entity
@Table(name = "roles")
public class Roles extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "remarkes")
    private String remarkes;

    @Column(name = "status")
    private Boolean status;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Roles id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Roles name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarkes() {
        return this.remarkes;
    }

    public Roles remarkes(String remarkes) {
        this.setRemarkes(remarkes);
        return this;
    }

    public void setRemarkes(String remarkes) {
        this.remarkes = remarkes;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public Roles status(Boolean status) {
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
        if (!(o instanceof Roles)) {
            return false;
        }
        return id != null && id.equals(((Roles) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Roles{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", remarkes='" + getRemarkes() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
}
