package com.example.Company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Company.entity.Designation;
import com.example.Company.service.DesignationService;

@RestController
@RequestMapping("/api/designation")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping
	public String createDesignation(@RequestBody Designation designation){
		return designationService.createDesignation(designation);
	}

	@GetMapping
	public List<Designation> getAllDesignation(){
		return designationService.getAllDesignation();
	}

	@GetMapping("/{designationId}")
	public Optional<Designation> getDesignationById(@PathVariable Long designationId) {
		return designationService.getDesignationById(designationId);
	}
	
	@PutMapping("/{designationId}")
	public Designation updateDesignation(@PathVariable Long designationId,@RequestBody Designation designation) {
		designation.setDesignationId(designationId);
		return designationService.updateDesignation(designationId, designation);
	}
	
	@DeleteMapping("/{designationId}")
	public String deleteDesignation(@PathVariable Long designationId){
		return designationService.deleteDesignation(designationId);
	}
	
}
