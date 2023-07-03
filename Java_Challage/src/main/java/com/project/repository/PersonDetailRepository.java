package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.PersonDetail;

@Repository
public interface PersonDetailRepository extends JpaRepository<PersonDetail, Integer>{

	
}
