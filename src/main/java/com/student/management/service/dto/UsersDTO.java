package com.student.management.service.dto;

import java.io.Serializable;
import java.util.Objects;

import com.student.management.audit.AuditableDTO;

/**
 * A DTO for the {@link com.school.management.domain.Users} entity.
 */
public class UsersDTO extends AuditableDTO<Long> implements Serializable {

    private Long id;

    private String name;

    private String login;

    private String userName;

    private String password;

    private String email;

    private String mobileno;

    private String opt;

    private Boolean isFirst;

    private Boolean isOnBoarded;

    private Long roleId;

    private Long lastLogingTime;

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

    public String getLogin() {
        return login;
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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }

    public Boolean getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Boolean isFirst) {
        this.isFirst = isFirst;
    }

    public Boolean getIsOnBoarded() {
        return isOnBoarded;
    }

    public void setIsOnBoarded(Boolean isOnBoarded) {
        this.isOnBoarded = isOnBoarded;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getLastLogingTime() {
        return lastLogingTime;
    }

    public void setLastLogingTime(Long lastLogingTime) {
        this.lastLogingTime = lastLogingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UsersDTO)) {
            return false;
        }

        UsersDTO usersDTO = (UsersDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, usersDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UsersDTO{" +
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
