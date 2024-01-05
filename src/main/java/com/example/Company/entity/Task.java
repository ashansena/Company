package com.example.Company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name ="task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="task_id")
	private Long taskId;

	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;

//	@Column(name="employee_id")
//	private Long employeeId;
	
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
	
	//----------------------
	
//	@ManyToOne
//	@JoinColumn(name = "class_id" , nullable = false)
//	public ClassRoom classRoomMap ;

	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name ="employee_id",nullable = false)
	public Employee employeeMap;
	
	
	public Employee getEmployeeMap() {
		return employeeMap;
	}

	public void setEmployeeMap(Employee employeeMap) {
		this.employeeMap = employeeMap;
	}


	
	
	//------------Getters and Setters---------

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

//	public Long getEmployeeId() {
//		return employeeId;
//	}
//
//	public void setEmployeeId(Long employeeId) {
//		this.employeeId = employeeId;
//	}
}
