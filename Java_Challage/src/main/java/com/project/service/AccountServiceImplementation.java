package com.project.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.AccountDTO;
import com.project.dto.PersonDetailDTO;
import com.project.exception.InavlidGenderException;
import com.project.exception.InvalidContractType;
import com.project.exception.InvalidDateException;
import com.project.model.Account;
import com.project.model.PersonDetail;
import com.project.repository.AccountRepository;
import com.project.repository.PersonDetailRepository;

@Service
@Transactional

public class AccountServiceImplementation implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PersonDetailRepository personDetailRepository;

	public void saveAccount(AccountDTO accDto) {

		Account account = new Account();
		PersonDetailDTO personDetailDTO = accDto.getPersonDetails();
		PersonDetail personDetail = new PersonDetail();

		try {
			account.setAccountType(accDto.getAccountType());
			account.setBusinessRequirements(accDto.getBusinessRequirements());
			account.setContractType(accDto.getContractType());
			account.setName(accDto.getName());
			account.setStatus(accDto.getStatus());

			personDetail.setGender(personDetailDTO.getGender());
			personDetail.setDob(new SimpleDateFormat("dd/MM/yyyy").parse((String) personDetailDTO.getDob()));


		personDetail.setNativePlace(personDetailDTO.getNativePlace());

		account.setPersonDetails(personDetail);

		this.personDetailRepository.save(personDetail);

		this.accountRepository.save(account);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateAccount(AccountDTO accDto, Integer accountId) throws Exception{

		Account account = this.accountRepository.getOne(accountId);

		PersonDetailDTO personDetailDTO = accDto.getPersonDetails();
		PersonDetail personDetail = new PersonDetail();

		try {
			account.setAccountType(accDto.getAccountType());
			account.setBusinessRequirements(accDto.getBusinessRequirements());
			account.setContractType(accDto.getContractType());
			account.setName(accDto.getName());
			account.setStatus(accDto.getStatus());
			personDetail.setGender(personDetailDTO.getGender());
			personDetail.setDob(new SimpleDateFormat("dd/MM/yyyy").parse((String) personDetailDTO.getDob()));

		personDetail.setNativePlace(personDetailDTO.getNativePlace());

		account.setPersonDetails(personDetail);

		this.personDetailRepository.save(personDetail);

		this.accountRepository.save(account);

		} catch (InvalidContractType ice) {
			ice.printStackTrace();
			throw ice;
		}catch (InavlidGenderException ige) {
			ige.printStackTrace();
			throw ige;
		}catch (InvalidDateException ide) {
			ide.printStackTrace();
			throw ide;
		}
	}

	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	public AccountDTO findById(int id) {

		Account account = this.accountRepository.getOne(id);

		AccountDTO accDto = new AccountDTO();

		accDto.setAccountType(account.getAccountType());
		accDto.setBusinessRequirements(account.getBusinessRequirements());
		accDto.setContractType(account.getContractType());
		accDto.setId(account.getId());
		accDto.setName(account.getName());
		accDto.setStatus(account.getStatus());

		return accDto;
	}

	public void deleteAccount(Integer accountId) {

		Account account = this.accountRepository.getOne(accountId);
		account.setStatus(false);

		this.accountRepository.save(account);
	}

	/*
	 * public void saveAccount(Account account) { accountRepository.save(account); }
	 */
}
