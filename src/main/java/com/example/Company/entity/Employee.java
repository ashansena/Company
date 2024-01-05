package com.example.Company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@Column(name="contact_number")
	private String contactNumber;

//	@Column(name="designation_id")
//	private Long designationId;;   //foreign key

	@Column(name="status")
	private String status;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="created_user")
	private String createdUser;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="modified_user")
	private String modifiedUser;
	
	//-------------------------------
	
//	@ManyToOne
//	@JoinColumn(name = "class_id" , nullable = false)
//	public ClassRoom classRoomMap ;

	@JsonIgnore
	@OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "designation_id", nullable = false)
	public Designation designationMap; // designationMap change to designations
	
	
	public Designation getDesignationMap() {
		return designationMap;
	}

	public void setDesignationMap(Designation designationMap) {
		this.designationMap = designationMap;
	}

	
	
	
	//------------Getters and Setters---------

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

//	public Long getDesignationId() {
//		return designationId;
//	}
//
//	public void setDesignationId(Long designationId) {
//		this.designationId = designationId;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	
	
}