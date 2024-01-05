package com.example.Company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Company.entity.Designation;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{

}
