package com.example.Company.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="designation")
public class Designation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="designation_id")
	private Long designationId;

	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;

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


	//------------Getters and Setters---------

	public Long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
