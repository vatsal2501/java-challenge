package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Account;
import com.project.model.PersonDetail;
import com.project.repository.PersonDetailRepository;

@Service
@Transactional
public class PersonDetailServiceImplementation implements PersonDetailService {

	@Autowired
	private PersonDetailRepository personDetailRepository;
	
	public void savePersonDetail(PersonDetail personDetail) {
		this.personDetailRepository.save(personDetail);
	}
	
	public List<PersonDetail> getAllPersonDetail() {
		return personDetailRepository.findAll();
	}
	
	public PersonDetail findById(int id) {
		return this.personDetailRepository.getOne(id);
	}
	
	/*
	 * public void deletePersonDetail(PersonDetail personDetail) {
	 * personDetail.setStatus(false); saveAccount(account); }
	 */
	
}
