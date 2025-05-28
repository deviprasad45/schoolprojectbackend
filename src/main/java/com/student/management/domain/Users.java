package com.student.management.domain;

import java.io.Serializable;

import com.student.management.audit.Auditable;

import jakarta.persistence.*;

/**
 * A Users.
 */
@Entity
@Table(name = "users")
public class Users extends Auditable<Long> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "mobileno")
    private String mobileno;

    @Column(name = "opt")
    private String opt;

    @Column(name = "is_first")
    private Boolean isFirst;

    @Column(name = "is_on_boarded")
    private Boolean isOnBoarded;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "last_loging_time")
    private Long lastLogingTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Users id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Users name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return this.login;
    }

    public Users login(String login) {
        this.setLogin(login);
        return this;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return this.password;
    }

    public Users password(String password) {
        this.setPassword(password);
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public Users email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return this.mobileno;
    }

    public Users mobileno(String mobileno) {
        this.setMobileno(mobileno);
        return this;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getOpt() {
        return this.opt;
    }

    public Users opt(String opt) {
        this.setOpt(opt);
        return this;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Boolean getIsFirst() {
        return this.isFirst;
    }

    public Users isFirst(Boolean isFirst) {
        this.setIsFirst(isFirst);
        return this;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public Boolean getIsOnBoarded() {
        return this.isOnBoarded;
    }

    public Users isOnBoarded(Boolean isOnBoarded) {
        this.setIsOnBoarded(isOnBoarded);
        return this;
    }

    public void setIsOnBoarded(Boolean isOnBoarded) {
        this.isOnBoarded = isOnBoarded;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public Users roleId(Long roleId) {
        this.setRoleId(roleId);
        return this;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getLastLogingTime() {
        return this.lastLogingTime;
    }

    public Users lastLogingTime(Long lastLogingTime) {
        this.setLastLogingTime(lastLogingTime);
        return this;
    }

    public void setLastLogingTime(Long lastLogingTime) {
        this.lastLogingTime = lastLogingTime;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Users)) {
            return false;
        }
        return id != null && id.equals(((Users) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Users{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", login='" + getLogin() + "'" +
            ", username='" + getUserName() + "'" +
            ", password='" + getPassword() + "'" +
            ", email='" + getEmail() + "'" +
            ", mobileno='" + getMobileno() + "'" +
            ", opt='" + getOpt() + "'" +
            ", isFirst='" + getIsFirst() + "'" +
            ", isOnBoarded='" + getIsOnBoarded() + "'" +
            ", roleId=" + getRoleId() +
            ", lastLogingTime=" + getLastLogingTime() +
            "}";
    }
}
