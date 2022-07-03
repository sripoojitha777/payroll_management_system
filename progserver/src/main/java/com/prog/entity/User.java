package com.prog.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String phone;
	private String password;
	private String profileUrl;
	
	
	private String designation;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate doj;
	
	private boolean enabled = true;
	
	
	//User has many roles
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();


	public User() {

	}



	public User(Long id, String firstName, String lastName, String email, String userName, String phone,
			String password, String profileUrl, String designation, LocalDate doj, boolean enabled,
			Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.phone = phone;
		this.password = password;
		this.profileUrl = profileUrl;
		this.designation = designation;
		this.doj = doj;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

//	{
//	    "userName":"Evan563",
//	    "firstName":"Evan",
//	    "lastName":"Rob",
//	    "email":"Evan5@gmail.com",
//	    "phone":"4561237890",
//	    "password":"Evan123",
//	    "designation":"Developer"
//	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getProfileUrl() {
		return profileUrl;
	}


	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public LocalDate getDoj() {
		return doj;
	}


	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Set<UserRole> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", phone=" + phone + ", password=" + password + ", profileUrl="
				+ profileUrl + ", designation=" + designation + ", doj=" + doj + ", enabled=" + enabled + ", userRoles="
				+ userRoles + "]";
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Set<Authority> set = new HashSet<>();
		
		this.userRoles.forEach(userRole -> {
			set.add(new Authority(userRole.getRole().getRoleName()));
		});
		System.out.println(set.toString());
		return set;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getUserName();
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
}
