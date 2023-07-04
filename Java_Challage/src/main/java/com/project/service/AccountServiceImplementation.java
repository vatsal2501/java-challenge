package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.AccountDTO;
import com.project.dto.PersonDetailDTO;
import com.project.enums.ExceptionEnum;
import com.project.exception.CustomException;
import com.project.model.Account;
import com.project.model.PersonDetail;
import com.project.repository.AccountRepository;
import com.project.repository.PersonDetailRepository;
import com.project.validation.Validator;

@Service
@Transactional

public class AccountServiceImplementation implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PersonDetailRepository personDetailRepository;

	// TODO: save account and personal details
	public void saveAccount(AccountDTO accDto) throws Exception {

		PersonDetailDTO personDetailDTO = accDto.getPersonDetails();

		Account account = new Account();
		PersonDetail personDetail = new PersonDetail();

		// TODO: validate contrcat type
		if (!Validator.validateContractType(accDto.getContractType())) {
			throw new CustomException(ExceptionEnum.INVALID_CONTRACT_TYPE.getMessage(),
					ExceptionEnum.INVALID_CONTRACT_TYPE.getStatusCode());
		}

		// TODO: validate gender
		if (!Validator.validateGender(personDetailDTO.getGender())) {
			throw new CustomException(ExceptionEnum.INVALID_GENDER_TYPE.getMessage(),
					ExceptionEnum.INVALID_GENDER_TYPE.getStatusCode());
		}

		// TODO: validate date of birth
		if (!Validator.validateDob(personDetailDTO.getDob())) {
			throw new CustomException(ExceptionEnum.INVALID_DATE.getMessage(),
					ExceptionEnum.INVALID_DATE.getStatusCode());
		}

		try {

			account.setAccountType(accDto.getAccountType());
			account.setBusinessRequirements(accDto.getBusinessRequirements());
			account.setContractType(accDto.getContractType());
			account.setName(accDto.getName());
			account.setStatus(accDto.getStatus());

			personDetail.setGender(personDetailDTO.getGender());
			personDetail.setDob(new SimpleDateFormat("dd-MM-yyyy").parse(personDetailDTO.getDob()));

			personDetail.setNativePlace(personDetailDTO.getNativePlace());

			this.personDetailRepository.save(personDetail);

			account.setPersonDetails(personDetail);

			this.accountRepository.save(account);

		} catch (Exception e) {

			throw e;
		}
	}

	// TODO: update account detail
	public void updateAccount(AccountDTO accDto, Integer accountId) throws Exception {

		PersonDetailDTO personDetailDTO = accDto.getPersonDetails();

		// TODO: validate contrcat type
		if (!Validator.validateContractType(accDto.getContractType())) {
			throw new CustomException(ExceptionEnum.INVALID_CONTRACT_TYPE.getMessage(),
					ExceptionEnum.INVALID_CONTRACT_TYPE.getStatusCode());
		}

		// TODO: validate gender
		if (!Validator.validateGender(personDetailDTO.getGender())) {
			throw new CustomException(ExceptionEnum.INVALID_GENDER_TYPE.getMessage(),
					ExceptionEnum.INVALID_GENDER_TYPE.getStatusCode());
		}

		// TODO: validate date of birth
		if (!Validator.validateDob(personDetailDTO.getDob())) {
			throw new CustomException(ExceptionEnum.INVALID_DATE.getMessage(),
					ExceptionEnum.INVALID_DATE.getStatusCode());
		}

		PersonDetail personDetail = new PersonDetail();
		Account account = this.accountRepository.getOne(accountId);

		try {

			account.setAccountType(accDto.getAccountType());
			account.setBusinessRequirements(accDto.getBusinessRequirements());
			account.setContractType(accDto.getContractType());
			account.setName(accDto.getName());
			account.setStatus(accDto.getStatus());
			personDetail.setGender(personDetailDTO.getGender());
			personDetail.setDob(new SimpleDateFormat("dd-MM-yyyy").parse((String) personDetailDTO.getDob()));

			personDetail.setNativePlace(personDetailDTO.getNativePlace());

			this.personDetailRepository.save(personDetail);

			account.setPersonDetails(personDetail);

			this.accountRepository.save(account);

		} catch (Exception e) {
			throw e;
		}
	}

	// TODO: fetch all acoount
	public List<Account> getAllAccount() {

		try {

			List<Account> accList = accountRepository.findAll();

			if (accList.isEmpty()) {
				throw new CustomException(ExceptionEnum.NO_ACCOUNT_AVAILBLE.getMessage(),
						ExceptionEnum.NO_ACCOUNT_AVAILBLE.getStatusCode());
			}
			return accList;
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}
	
	//TODO: finde account by id
	public AccountDTO findById(Integer accountId) {
		AccountDTO accDto = new AccountDTO();
		try {

			Account account = this.accountRepository.getOne(accountId);

			if (account == null) {
				throw new CustomException(ExceptionEnum.NO_ACCOUNT_AVAILBLE.getMessage(),
						ExceptionEnum.NO_ACCOUNT_AVAILBLE.getStatusCode());
			}

			accDto.setAccountType(account.getAccountType());
			accDto.setBusinessRequirements(account.getBusinessRequirements());
			accDto.setContractType(account.getContractType());
			accDto.setId(account.getId());
			accDto.setName(account.getName());
			accDto.setStatus(account.getStatus());

		} catch (Exception e) {
			// TODO: handle exception
		}

		return accDto;
	}
	
	//TODO: delete account
	public void deleteAccount(Integer accountId) {

		try {

			Account account = this.accountRepository.getOne(accountId);

			if (account == null) {

				throw new CustomException(ExceptionEnum.NO_ACCOUNT_AVAILBLE.getMessage(),
						ExceptionEnum.NO_ACCOUNT_AVAILBLE.getStatusCode());
			}

			account.setStatus(false);
			account.getPersonDetails().setStatus(false);

			this.accountRepository.save(account);

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

	}

}
