package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}
