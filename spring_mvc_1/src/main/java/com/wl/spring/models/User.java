package com.wl.spring.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"users\"")
public class User implements Serializable {
	private static final long serialVersionUID = 3L;
	public static final String USER = "ROLE_USER";
	public static final String ADMIN = "ROLE_ADMIN";

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "active")
	private boolean active;

//	@Column(name = "user_role")
//	private String userRole;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	@JsonIgnore
	private String password;

	@Transient
	private String confirmPassword;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Column(name = "cover_image")
	private String coverImage;

	@Column(name = "created_at")
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date createdAt;

	@Column(name = "role")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> listRoles = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

//	public String getUserRole() {
//		return userRole;
//	}
//
//	public void setUserRole(String userRole) {
//		this.userRole = userRole;
//	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Set<Role> getListRoles() {
		return listRoles;
	}

	public void setListRoles(Set<Role> listRoles) {
		this.listRoles = listRoles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", active=" + active + ", username=" + username
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phone=" + phone + ", email=" + email + ", avatar=" + avatar
				+ ", coverImage=" + coverImage + ", createdAt=" + createdAt + ", listRoles=" + listRoles + "]";
	}
	

}
