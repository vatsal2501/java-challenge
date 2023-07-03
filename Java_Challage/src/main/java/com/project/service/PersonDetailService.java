package com.project.service;

import java.util.List;

import com.project.model.PersonDetail;

public interface PersonDetailService {

	public void savePersonDetail(PersonDetail personDetail);
	public List<PersonDetail> getAllPersonDetail();
	public PersonDetail findById(int id);
	
}
