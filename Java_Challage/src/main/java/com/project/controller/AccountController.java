package com.project.controller;

import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AccountDTO;
import com.project.model.Account;
import com.project.model.PersonDetail;
import com.project.service.AccountService;
import com.project.service.PersonDetailService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private PersonDetailService personDetailService;

	@PostMapping(value = "/saveAccount")
	public ResponseEntity saveAccount(@RequestBody AccountDTO accountDto) throws Exception {
		HttpStatus status;
		try {
			this.accountService.saveAccount(accountDto);
			status=HttpStatus.OK;
		} catch (Exception e) {
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			throw e;
		}
		return new ResponseEntity<>(status);
	}

	@GetMapping(value = "/viewAccounts")
	public ResponseEntity getAllAccount() {
		List<Account> sccountList = new ArrayList<>();
		HttpStatus status;
		
		try {
			sccountList = this.accountService.getAllAccount();
			status=HttpStatus.OK;
		} catch (Exception e) {
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			throw e;
		}
		return new ResponseEntity<>(sccountList, status);
	}

	@PostMapping(value = "/saveAndUpdate")
	public ResponseEntity saveAndUpdate(@RequestBody AccountDTO accDto, @RequestParam Integer accountId)
			throws Exception {
		try {
			this.accountService.updateAccount(accDto, accountId);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}
	}

	@GetMapping(value = "/deleteAccounts")
	public ResponseEntity deleteAccounts(@RequestParam int accountId) {

		this.accountService.deleteAccount(accountId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
