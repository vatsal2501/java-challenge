package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AccountDTO;
import com.project.enums.ExceptionEnum;
import com.project.exception.CustomException;
import com.project.model.Account;
import com.project.service.AccountService;
import com.project.service.PersonDetailService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PersonDetailService personDetailService;

	//TODO: save acoount
	@PostMapping(value = "/saveAccount")
	public ResponseEntity saveAccount(@Valid@RequestBody AccountDTO accountDto) throws Exception {
		try {
			
			this.accountService.saveAccount(accountDto);

		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	//TODO: view all account
	@GetMapping(value = "/viewAccounts")
	public ResponseEntity getAllAccount() {
		List<Account> sccountList = new ArrayList<>();
		
		try {
			sccountList = this.accountService.getAllAccount();
		} catch (Exception e) {
			throw e;
		}
		return new ResponseEntity<>(sccountList, HttpStatus.OK);
	}
	
	//TODO: update account
	@PostMapping(value = "/updateAndSave")
	public ResponseEntity saveAndUpdate(@RequestBody AccountDTO accDto, @RequestParam Integer accountId)
			throws Exception {
		
		if(accountId  ==  null) {
			throw new CustomException(ExceptionEnum.INVALID_ID.getMessage(), 
					ExceptionEnum.INVALID_ID.getStatusCode());
		}
		
		try {
			this.accountService.updateAccount(accDto, accountId);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}
	
	//TODO: delete account
	@GetMapping(value = "/deleteAccount")
	public ResponseEntity deleteAccount(@RequestParam Integer accountId) {
		
		try {
			if(accountId  ==  null) {
				throw new CustomException(ExceptionEnum.INVALID_ID.getMessage(), 
						ExceptionEnum.INVALID_ID.getStatusCode());
			}
			
			this.accountService.deleteAccount(accountId);
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
