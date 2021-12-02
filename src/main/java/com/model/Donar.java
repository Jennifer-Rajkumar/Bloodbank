package com.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="donar")
public class Donar {
	
	@Id
	@NotEmpty
    @Column(unique=true, nullable = false)
	private String donarid;
	
	@Size(min=3, max=50)
    @Column(nullable = false)
	private String name;
	
	@NotEmpty
	private String gender;
	
	@NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate dob;
	
	@NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate lastdonatedon;
	
	@NotEmpty
	private String bloodgroup;
	
	@Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message="Enter valid mail id")
	private String email;
	
	@Override
	public String toString() {
		return "Donar [donarid=" + donarid + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", bloodgroup="
				+ bloodgroup + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(donarid, bloodgroup, dob, email, gender, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Donar other = (Donar) obj;
		return Objects.equals(donarid, other.donarid) && Objects.equals(bloodgroup, other.bloodgroup)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(name, other.name);
	}
	public String getDonarid() {
		return donarid;
	}
	public void setDonarid(String donarid) {
		this.donarid = donarid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getLastdonatedon() {
		return lastdonatedon;
	}
	public void setLastdonatedon(LocalDate lastdonatedon) {
		this.lastdonatedon = lastdonatedon;
	}
	
}
