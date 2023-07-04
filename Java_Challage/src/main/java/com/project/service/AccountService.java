package com.project.service;

import java.util.List;

import com.project.dto.AccountDTO;
import com.project.model.Account;

public interface AccountService {
	
	public void saveAccount(AccountDTO accDto) throws Exception;
	
	public void updateAccount(AccountDTO accDto,Integer id) throws Exception;
	
	public List<Account> getAllAccount();
	
	public AccountDTO findById(Integer accountId);
	
	public void deleteAccount(Integer accountId);
}
