package io.github.samirsales.curso.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class User {

	private Long id;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String firstName;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Field must have between {min} and {max} characters.")
	private String lastName;
	
	@NotNull(message = "This birth date field is required.")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dtBirth;
	
	private Gender gender;

	public User() {
		
	}
	
	public User(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public User(Long id, String firstName, String lastName, LocalDate dtBorn) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dtBirth = dtBorn;
	}
	
	public User(Long id, String firstName, String lastName, LocalDate dtBirth, Gender gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dtBirth = dtBirth;
		this.gender = gender;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "User [id: "+id+", firstName: "+firstName+", lastName: "+lastName+"]";
	}

	public LocalDate getDtBirth() {
		return dtBirth;
	}

	public void setDtBirth(LocalDate dtBirth) {
		this.dtBirth = dtBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
