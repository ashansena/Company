package com.example.Company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Company.entity.Designation;
import com.example.Company.repository.DesignationRepository;

@Service
public class DesignationService {
	
	@Autowired
	private DesignationRepository designationRepository;
	
	public String createDesignation(Designation designation){
		designationRepository.save(designation);
		return "Successfully Created";
	}
	
	public List<Designation> getAllDesignation(){
		return designationRepository.findAll();
	}
	
	public Optional<Designation> getDesignationById(Long designationId){
		Optional<Designation> optionalDesignation=designationRepository.findById(designationId);

		if(optionalDesignation.isPresent()){
			return Optional.ofNullable(optionalDesignation.get());

		}else{
			return Optional.empty();
		}
	}
	
	public Designation updateDesignation(Long designationId,Designation designation){
	//	Designation existingDesignation = designationRepository.findById(designation.getDesignationId()).get();

		Designation existingDesignation = designationRepository.findById(designationId).get();
		
		existingDesignation.setCode(designation.getCode());
		existingDesignation.setName(designation.getName());
		existingDesignation.setStatus(designation.getStatus());
		existingDesignation.setCreatedDate(designation.getCreatedDate());
		existingDesignation.setCreatedUser(designation.getCreatedUser());
		existingDesignation.setModifiedDate(designation.getModifiedDate());
		existingDesignation.setModifiedUser(designation.getModifiedUser());
		
		Designation updatedDesignation=designationRepository.save(existingDesignation);
		return updatedDesignation;
	}

	public String deleteDesignation(Long designationId){
		Optional<Designation> designation=designationRepository.findById(designationId);
		if(designation.isPresent()){
			designationRepository.deleteById(designationId);
			return "Successfully Deleted";
		}else{
			return "Not Found";
		}
	}
}